/**
 * AttackContetnBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">襲撃発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of attack</div>
 * 
 * @author otsuki
 *
 */
public class AttackContentBuilder extends ContentBuilder {

	public AttackContentBuilder(Agent target) {
		topic = Topic.ATTACK;
		this.target = target;
		text = String.join(" ", new String[] { Topic.ATTACK.toString(), String.valueOf(target.toString()) });
	}

}
