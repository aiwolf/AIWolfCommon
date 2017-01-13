/**
 * AttackContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">襲撃発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of an attack.</div>
 * 
 * @author otsuki
 *
 */
public class AttackContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">襲撃意思表明のためのAttackContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an AttackContentBuilder to declare an attack.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被襲撃エージェント</div>
	 * 
	 *            <div lang="en">The agent to be attacked.</div>
	 * 
	 */
	public AttackContentBuilder(Agent target) {
		topic = Topic.ATTACK;
		this.target = target;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject == null ? "" : subject.toString(), Topic.ATTACK.toString(), target.toString() }).trim();
	}

}
