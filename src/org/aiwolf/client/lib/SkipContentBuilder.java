/**
 * SkipContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

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
	 */
	public SkipContentBuilder() {
		topic = Topic.SKIP;
	}

	@Override
	String getText() {
		return Talk.SKIP;
	}

}
