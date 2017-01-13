/**
 * OverContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Talk;

/**
 * <div lang="ja">OVERビルダークラス</div>
 * 
 * <div lang="en">Builder class for OVER.</div>
 * 
 * @author otsuki
 *
 */
public class OverContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">OVERのためのOverContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an OverContentBuilder for OVER.</div>
	 */
	public OverContentBuilder() {
		topic = Topic.OVER;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject == null ? "" : subject.toString(), Talk.OVER }).trim();
	}

}
