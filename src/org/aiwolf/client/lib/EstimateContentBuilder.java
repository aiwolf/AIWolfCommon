/**
 * EstimateContetnBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;

/**
 * <div lang="ja">推測発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of estimation</div>
 * 
 * @author otsuki
 *
 */
public class EstimateContentBuilder extends ContentBuilder {

	public EstimateContentBuilder(Agent target, Role role) {
		topic = Topic.ESTIMATE;
		this.target = target;
		state = State.parseState(role);
		text = String.join(" ", new String[] { Topic.ESTIMATE.toString(), String.valueOf(target.toString()), role.toString() });
	}

}
