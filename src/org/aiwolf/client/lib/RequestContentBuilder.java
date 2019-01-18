/**
 * RequestContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.ArrayList;

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
	 * @param target
	 *            <div lang="ja">要求先のエージェント</div>
	 *
	 *            <div lang="en">The requested agent.</div>
	 * @param content
	 *            <div lang="ja">要求される行動を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the requested action.</div>
	 */
	public RequestContentBuilder(Agent target, Content content) {
		this(null, target, content);
	}

	/**
	 * <div lang="ja">他エージェントの行動を要求するためのRequestContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a RequestContentBuilder to request for the other agent's action.</div>
	 * 
	 * @param requester
	 *            <div lang="ja">要求をするエージェント</div>
	 *
	 *            <div lang="en">The agent who requests.</div>
	 * @param accepter
	 *            <div lang="ja">要求先のエージェント</div>
	 *
	 *            <div lang="en">The requested agent.</div>
	 * @param content
	 *            <div lang="ja">要求される行動を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the requested action.</div>
	 */
	public RequestContentBuilder(Agent requester, Agent accepter, Content content) {
		topic = Topic.OPERATOR;
		operator = Operator.REQUEST;
		subject = requester;
		target = accepter;
		Content newContent = content.clone();
		if (target == null && newContent.subject != null) {
			target = newContent.subject;
		}
		contentList = new ArrayList<>();
		contentList.add(newContent);
	}

	@Override
	String getText() {
		return ContentBuilder.join(" ", new String[] {
				subject == null ? "" : subject.toString(),
				Operator.REQUEST.toString(),
				target == null ? "ANY" : target.toString(),
				"(" + contentList.get(0).getText() + ")"
		}).trim();
	}

}
