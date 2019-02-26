/**
 * OrContentBuilder.java
 * 
 * Copyright (c) 2019 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.Arrays;
import java.util.List;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">OR演算子ビルダークラス</div>
 * 
 * <div lang="en">Builder class for OR operator.</div>
 * 
 * @author otsuki
 *
 */
public class OrContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">OR演算子のためのOrContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a OrContentBuilder for OR operator (with no subject specified).</div>
	 * 
	 * @param contents
	 *            <div lang="ja">{@code Content}の並び</div>
	 *
	 *            <div lang="en">The series of {@code Content}s.</div>
	 */
	public OrContentBuilder(Content... contents) {
		this(Content.UNSPEC, contents);
	}

	/**
	 * <div lang="ja">OR演算子のためのOrContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a OrContentBuilder for OR operator.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">発話エージェント</div>
	 *
	 *            <div lang="en">The agent who utters.</div>
	 * @param contents
	 *            <div lang="ja">{@code Content}の並び</div>
	 *
	 *            <div lang="en">The series of {@code Content}s.</div>
	 */
	public OrContentBuilder(Agent subject, Content... contents) {
		this(subject, Arrays.asList(contents));
	}

	/**
	 * <div lang="ja">OR演算子のためのOrContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a OrContentBuilder for OR operator (with no subject specified).</div>
	 * 
	 * @param contents
	 *            <div lang="ja">{@code Content}のリスト</div>
	 *
	 *            <div lang="en">The list of {@code Content}s.</div>
	 */
	public OrContentBuilder(List<Content> contents) {
		this(Content.UNSPEC, contents);
	}

	/**
	 * <div lang="ja">OR演算子のためのOrContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a OrContentBuilder for OR operator.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">発話エージェント</div>
	 *
	 *            <div lang="en">The agent who utters.</div>
	 * @param contents
	 *            <div lang="ja">{@code Content}のリスト</div>
	 *
	 *            <div lang="en">The list of {@code Content}s.</div>
	 */
	public OrContentBuilder(Agent subject, List<Content> contents) {
		topic = Topic.OPERATOR;
		operator = Operator.OR;
		this.subject = subject;
		contentList = contents;
	}

}
