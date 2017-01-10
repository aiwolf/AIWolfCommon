/**
 * OverContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Talk;

/**
 * <div lang="ja">{@code OVER}ビルダークラス</div>
 * 
 * <div lang="en">Builder class for {@code OVER}.</div>
 * 
 * @author otsuki
 *
 */
public class OverContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code OVER}のためのOverContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an OverContentBuilder for {@code OVER}.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">主語を表す{@code Agent}</div>
	 *
	 *            <div lang="en">{@code Agent} representing the subject.</div>
	 */
	public OverContentBuilder(Agent subject) {
		topic = Topic.OVER;
		this.subject = subject;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject.toString(), Talk.OVER });
	}

}
