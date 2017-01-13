/**
 * GuardedAgentContentBuilder.java
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
public class GuardedAgentContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">護衛報告のためのGuardedAgentContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a GuardedAgentContentBuilder to report a guard.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被護衛エージェント</div>
	 * 
	 *            <div lang="en">The guarded agent.</div>
	 * 
	 */
	public GuardedAgentContentBuilder(Agent target) {
		topic = Topic.GUARDED;
		this.target = target;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject == null ? "" : subject.toString(), Topic.GUARDED.toString(), target.toString() }).trim();
	}

}
