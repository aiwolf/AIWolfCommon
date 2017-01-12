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
	 * <div lang="ja">護衛行為について発話するためのGuardCandidateContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a GuardCandidateContentBuilder to utter a guard.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被護衛エージェント</div>
	 * 
	 *            <div lang="en">The agent to be guarded.</div>
	 * 
	 */
	public GuardCandidateContentBuilder(Agent target) {
		topic = Topic.GUARD;
		this.target = target;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.GUARD.toString(), target.toString() });
	}

}
