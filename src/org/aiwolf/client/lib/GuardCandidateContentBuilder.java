/**
 * GuardCandidateContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">護衛発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of a guard.</div>
 * 
 * @author otsuki
 *
 */
public class GuardCandidateContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">護衛行為について発話するためのGuardCandidateContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a GuardCandidateContentBuilder to utter a guard (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被護衛エージェント</div>
	 * 
	 *            <div lang="en">The agent to be guarded.</div>
	 * 
	 */
	public GuardCandidateContentBuilder(Agent target) {
		this(Content.UNSPEC, target);
	}

	/**
	 * <div lang="ja">護衛行為について発話するためのGuardCandidateContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a GuardCandidateContentBuilder to utter a guard.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">護衛をするエージェント</div>
	 * 
	 *            <div lang="en">The agent who guards.</div>
	 * @param target
	 *            <div lang="ja">被護衛エージェント</div>
	 * 
	 *            <div lang="en">The agent to be guarded.</div>
	 * 
	 */
	public GuardCandidateContentBuilder(Agent subject, Agent target) {
		topic = Topic.GUARD;
		this.subject = subject;
		this.target = target;
	}

}
