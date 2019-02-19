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
	 * <div lang="ja">排他的論理和のためのXorContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a XorContentBuilder for exclusive OR.</div>
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
	 * <div lang="ja">排他的論理和のためのXorContentBuilderを構築する</div>
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

	@Override
	String getText() {
		return ContentBuilder.join(" ", new String[] {
				subject == Content.UNSPEC ? "" : subject.toString(),
				operator.toString(),
				"(" + (contentList.get(0).getSubject() == subject ? Content.stripSubject(contentList.get(0).getText()) : contentList.get(0).getText()) + ")",
				"(" + (contentList.get(1).getSubject() == subject ? Content.stripSubject(contentList.get(1).getText()) : contentList.get(1).getText()) + ")"
		}).trim();
	}

}
