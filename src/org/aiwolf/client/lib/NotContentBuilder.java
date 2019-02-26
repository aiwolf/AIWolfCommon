/**
 * NotContentBuilder.java
 * 
 * Copyright (c) 2019 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.ArrayList;
import java.util.Arrays;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">NOT演算子ビルダークラス</div>
 * 
 * <div lang="en">Builder class for NOT operator.</div>
 * 
 * @author otsuki
 *
 */
public class NotContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">NOT演算子のためのNotContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a NotContentBuilder for NOT operator (with no subject specified).</div>
	 * 
	 * @param content
	 *            <div lang="ja">否定される{@code Content}</div>
	 *
	 *            <div lang="en">The negated {@code Content}.</div>
	 */
	public NotContentBuilder(Content content) {
		this(Content.UNSPEC, content);
	}

	/**
	 * <div lang="ja">NOT演算子のためのNotContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a NotContentBuilder for NOT operator.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">発話エージェント</div>
	 *
	 *            <div lang="en">The agent who utters.</div>
	 * @param content
	 *            <div lang="ja">否定される{@code Content}</div>
	 *
	 *            <div lang="en">The negated {@code Content}.</div>
	 */
	public NotContentBuilder(Agent subject, Content content) {
		topic = Topic.OPERATOR;
		operator = Operator.NOT;
		this.subject = subject;
		contentList = new ArrayList<>(Arrays.asList(content));
	}

}
