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
 * <div lang="en">Builder class for the utterance of estimation.</div>
 * 
 * @author otsuki
 *
 */
public class EstimateContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code target}の役職が{@code role}であるとの推測のためのEstimateContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an EstimateContentBuilder for estimating that {@code target} acts as {@code role}.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被推測エージェント</div>
	 * 
	 *            <div lang="en">The agent estimated by the utterer.</div>
	 * @param role
	 *            <div lang="ja">被推測役職</div>
	 * 
	 *            <div lang="en">The role estimated by the utterer.</div>
	 */
	public EstimateContentBuilder(Agent target, Role role) {
		topic = Topic.ESTIMATE;
		this.target = target;
		role = role;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.ESTIMATE.toString(), target.toString(), role.toString() });
	}

}
