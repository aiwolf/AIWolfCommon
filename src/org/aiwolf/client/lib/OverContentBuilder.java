/**
 * OverContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

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
	 */
	public OverContentBuilder() {
		topic = Topic.OVER;
	}

	@Override
	String getText() {
		return Talk.OVER;
	}

}
