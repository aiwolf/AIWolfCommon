/**
 * RequestContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.ArrayList;

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
	 * @param content
	 *            <div lang="ja">要求される行動を表す{@code Content}</div>
	 *
	 *            <div lang="en">{@code Content} representing the requested action.</div>
	 */
	public RequestContentBuilder(Content content) {
		operator = Operator.REQUEST;
		contentList = new ArrayList<>();
		contentList.add(content);
	}

	@Override
	String getText() {
		return Operator.REQUEST + "(" + contentList.get(0).getText() + ")";
	}

}
