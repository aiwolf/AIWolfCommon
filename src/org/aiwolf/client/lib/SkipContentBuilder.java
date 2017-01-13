/**
 * SkipContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Talk;

/**
 * <div lang="ja">SKIPビルダークラス</div>
 * 
 * <div lang="en">Builder class for SKIP.</div>
 * 
 * @author otsuki
 *
 */
public class SkipContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">SKIPのためのSkipContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a SkipContentBuilder for SKIP.</div>
	 */
	public SkipContentBuilder() {
		topic = Topic.SKIP;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject == null ? "" : subject.toString(), Talk.SKIP }).trim();
	}

}
