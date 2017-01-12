/**
 * GuardedContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">護衛報告発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the report of a guard.</div>
 * 
 * @author otsuki
 *
 */
public class GuardedContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">護衛報告のためのGuardedContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a GuardedContentBuilder to report a guard.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被護衛エージェント</div>
	 * 
	 *            <div lang="en">The guarded agent.</div>
	 * 
	 */
	public GuardedContentBuilder(Agent target) {
		topic = Topic.GUARDED;
		this.target = target;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.GUARDED.toString(), target.toString() });
	}

}
