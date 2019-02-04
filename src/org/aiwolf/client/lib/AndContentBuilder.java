/**
 * AndContentBuilder.java
 * 
 * Copyright (c) 2019 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">AND演算子ビルダークラス</div>
 * 
 * <div lang="en">Builder class for AND operator.</div>
 * 
 * @author otsuki
 *
 */
public class AndContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">AND演算子のためのAndContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a AndContentBuilder for AND operator.</div>
	 * 
	 * @param contents
	 *            <div lang="ja">{@code Content}の並び</div>
	 *
	 *            <div lang="en">The series of {@code Content}s.</div>
	 */
	public AndContentBuilder(Content... contents) {
		this(Agent.UNSPEC, contents);
	}

	/**
	 * <div lang="ja">AND演算子のためのAndContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a AndContentBuilder for AND operator.</div>
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
	public AndContentBuilder(Agent subject, Content... contents) {
		this(subject, Arrays.asList(contents));
	}

	/**
	 * <div lang="ja">AND演算子のためのAndContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a AndContentBuilder for AND operator.</div>
	 * 
	 * @param contents
	 *            <div lang="ja">{@code Content}のリスト</div>
	 *
	 *            <div lang="en">The list of {@code Content}s.</div>
	 */
	public AndContentBuilder(List<Content> contents) {
		this(Agent.UNSPEC, contents);
	}

	/**
	 * <div lang="ja">AND演算子のためのAndContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a AndContentBuilder for AND operator.</div>
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
	public AndContentBuilder(Agent subject, List<Content> contents) {
		topic = Topic.OPERATOR;
		operator = Operator.AND;
		this.subject = subject;
		contentList = contents;
	}

	@Override
	String getText() {
		return ContentBuilder.join(" ", new String[] {
				Agent.UNSPEC == subject ? "" : subject.toString(),
				operator.toString(),
				contentList.stream().map(c -> "(" + c.getText() + ")").collect(Collectors.joining(" "))
		}).trim();
	}

}
