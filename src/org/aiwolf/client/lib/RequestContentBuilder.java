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
 * <div lang="en">Builder class for the utterance of request.</div>
 * 
 * @author otsuki
 *
 */
public class RequestContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">他エージェントの行動を要求するための{@code RequestContentBuilder}を構築する</div>
	 *
	 * <div lang="en">Constructs a {@code RequestContentBuilder} to request for the other agent's action.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">主語を表す{@code Agent}</div>
	 *
	 *            <div lang="en">{@code Agent} representing the subject.</div>
	 * @param content
	 *            <div lang="ja">要求される行動を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the requested action.</div>
	 */
	public RequestContentBuilder(Agent subject, Content content) {
		operator = Operator.REQUEST;
		this.subject = subject;
		contentList = new ArrayList<>();
		contentList.add(content);
	}

	@Override
	String getText() {
		return Operator.REQUEST + "(" + contentList.get(0).getText() + ")";
	}

}
