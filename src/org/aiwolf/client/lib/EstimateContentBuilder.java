/**
 * EstimateContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;

/**
 * <div lang="ja">推測発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of a estimation.</div>
 * 
 * @author otsuki
 *
 */
public class EstimateContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">推測のためのEstimateContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs an EstimateContentBuilder to utter an estimation (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被推測エージェント</div>
	 * 
	 *            <div lang="en">The agent estimated.</div>
	 * @param role
	 *            <div lang="ja">被推測役職</div>
	 * 
	 *            <div lang="en">The role estimated.</div>
	 */
	public EstimateContentBuilder(Agent target, Role role) {
		this(Content.UNSPEC, target, role);
	}

	/**
	 * <div lang="ja">推測のためのEstimateContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an EstimateContentBuilder to utter an estimation.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">推測をするエージェント</div>
	 * 
	 *            <div lang="en">The agent who estimates.</div>
	 * @param target
	 *            <div lang="ja">被推測エージェント</div>
	 * 
	 *            <div lang="en">The agent estimated.</div>
	 * @param role
	 *            <div lang="ja">被推測役職</div>
	 * 
	 *            <div lang="en">The role estimated.</div>
	 */
	public EstimateContentBuilder(Agent subject, Agent target, Role role) {
		topic = Topic.ESTIMATE;
		this.subject = subject;
		this.target = target;
		this.role = role;
	}

}
