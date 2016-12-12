/**
 * GuardContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">護衛発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of guard.</div>
 * 
 * @author otsuki
 *
 */
public class GuardContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code target}を護衛したことの報告のためのGuardContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an GuardContentBuilder for reporting that the utterer guarded {@code target}.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被護衛エージェント</div>
	 * 
	 *            <div lang="en">The agent the utterer guarded.</div>
	 * 
	 */
	public GuardContentBuilder(Agent target) {
		topic = Topic.GUARDED;
		this.target = target;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.GUARDED.toString(), target.toString() });
	}

}
