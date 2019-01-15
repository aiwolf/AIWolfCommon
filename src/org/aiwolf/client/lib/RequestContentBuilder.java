/**
 * RequestContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.ArrayList;

import org.aiwolf.common.AIWolfRuntimeException;
import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">要求発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of a request.</div>
 * 
 * @author otsuki
 *
 */
public class RequestContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">他エージェントの行動を要求するためのRequestContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a RequestContentBuilder to request for the other agent's action.</div>
	 * 
	 * @param agent
	 *            <div lang="ja">要求先のエージェント</div>
	 *
	 *            <div lang="en">The requested agent.</div>
	 * @param content
	 *            <div lang="ja">要求される行動を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the requested action.</div>
	 */
	public RequestContentBuilder(Agent agent, Content content) {
		this(null, agent, content);
	}

	/**
	 * <div lang="ja">他エージェントの行動を要求するためのRequestContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a RequestContentBuilder to request for the other agent's action.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">要求をするエージェント</div>
	 *
	 *            <div lang="en">The agent who requests.</div>
	 * @param agent
	 *            <div lang="ja">要求先のエージェント</div>
	 *
	 *            <div lang="en">The requested agent.</div>
	 * @param content
	 *            <div lang="ja">要求される行動を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the requested action.</div>
	 */
	public RequestContentBuilder(Agent subject, Agent agent, Content content) {
		if (content.getOperator() != null) {
			throw new AIWolfRuntimeException("RequestContentBuilder: Can not build a request for" + content.getOperator() + ".");
		}
		topic = Topic.OPERATOR;
		operator = Operator.REQUEST;
		this.subject = subject;
		Content newContent = content.clone();
		newContent.subject = agent;
		newContent.text = ContentBuilder.join(" ", new String[] { agent == null ? "" : agent.toString(), content.text }).trim();
		contentList = new ArrayList<>();
		contentList.add(newContent);
	}

	@Override
	String getText() {
		return ContentBuilder.join(" ", new String[] { subject == null ? "" : subject.toString(), Operator.REQUEST + "(" + contentList.get(0).getText() + ")" }).trim();
	}

}
