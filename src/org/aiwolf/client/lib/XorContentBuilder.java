/**
 * XorContentBuilder.java
 * 
 * Copyright (c) 2019 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.ArrayList;
import java.util.Arrays;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">XOR演算子ビルダークラス</div>
 * 
 * <div lang="en">Builder class for XOR operator.</div>
 * 
 * @author otsuki
 *
 */
public class XorContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">XOR演算子のためのXorContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a XorContentBuilder for XOR operator (with no subject specified).</div>
	 * 
	 * @param content1
	 *            <div lang="ja">1つ目の{@code Content}</div>
	 *
	 *            <div lang="en">The first {@code Content}.</div>
	 * @param content2
	 *            <div lang="ja">2つ目の{@code Content}</div>
	 *
	 *            <div lang="en">The second {@code Content}.</div>
	 */
	public XorContentBuilder(Content content1, Content content2) {
		this(Content.UNSPEC, content1, content2);
	}

	/**
	 * <div lang="ja">XOR演算子のためのXorContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a XorContentBuilder for XOR operator.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">発話エージェント</div>
	 *
	 *            <div lang="en">The agent who utters.</div>
	 * @param content1
	 *            <div lang="ja">1つ目の{@code Content}</div>
	 *
	 *            <div lang="en">The first {@code Content}.</div>
	 * @param content2
	 *            <div lang="ja">2つ目の{@code Content}</div>
	 *
	 *            <div lang="en">The second {@code Content}.</div>
	 */
	public XorContentBuilder(Agent subject, Content content1, Content content2) {
		topic = Topic.OPERATOR;
		operator = Operator.XOR;
		this.subject = subject;
		contentList = new ArrayList<>(Arrays.asList(content1, content2));
	}

}
