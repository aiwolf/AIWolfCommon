/**
 * SkipContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Talk;

/**
 * <div lang="ja">{@code SKIP}ビルダークラス</div>
 * 
 * <div lang="en">Builder class for {@code SKIP}.</div>
 * 
 * @author otsuki
 *
 */
public class SkipContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code SKIP}のためのSkipContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an SkipContentBuilder for {@code SKIP}.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">主語を表す{@code Agent}</div>
	 *
	 *            <div lang="en">{@code Agent} representing the subject.</div>
	 */
	public SkipContentBuilder(Agent subject) {
		topic = Topic.SKIP;
		this.subject = subject;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject.toString(), Talk.SKIP });
	}

}
