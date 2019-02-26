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
	 * <div lang="ja">護衛報告のためのGuardedAgentContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a GuardedAgentContentBuilder to report a guard (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被護衛エージェント</div>
	 * 
	 *            <div lang="en">The guarded agent.</div>
	 * 
	 */
	public GuardedAgentContentBuilder(Agent target) {
		this(Content.UNSPEC, target);
	}

	/**
	 * <div lang="ja">護衛報告のためのGuardedAgentContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a GuardedAgentContentBuilder to report a guard.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">護衛を行ったエージェント</div>
	 * 
	 *            <div lang="en">The agent who guarded.</div>
	 * @param target
	 *            <div lang="ja">被護衛エージェント</div>
	 * 
	 *            <div lang="en">The guarded agent.</div>
	 * 
	 */
	public GuardedAgentContentBuilder(Agent subject, Agent target) {
		topic = Topic.GUARDED;
		this.subject = subject;
		this.target = target;
	}

}
