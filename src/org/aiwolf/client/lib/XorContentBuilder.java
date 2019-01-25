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
 * <div lang="ja">排他的論理和ビルダークラス</div>
 * 
 * <div lang="en">Builder class for exclusive OR.</div>
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
		this(null, content1, content2);
	}

	/**
	 * <div lang="ja">排他的論理和のためのXorContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a XorContentBuilder for exclusive OR.</div>
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
		contentList = new ArrayList<>(Arrays.asList(content1.clone(), content2.clone()));
	}

	@Override
	String getText() {
		return ContentBuilder.join(" ", new String[] {
				subject == null ? "" : subject.toString(),
				operator.toString(),
				"(" + contentList.get(0).getText() + ")",
				"(" + contentList.get(1).getText() + ")"
		}).trim();
	}

}
