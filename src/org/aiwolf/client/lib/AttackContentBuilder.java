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
	 * <div lang="ja">襲撃発話のためのAttackContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs an AttackContentBuilder for the utterance of an attack (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被襲撃エージェント</div>
	 * 
	 *            <div lang="en">The attacked agent.</div>
	 * 
	 */
	public AttackContentBuilder(Agent target) {
		this(Content.UNSPEC, target);
	}

	/**
	 * <div lang="ja">襲撃発話のためのAttackContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an AttackContentBuilder for the utterance of an attack.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">襲撃をするエージェント</div>
	 * 
	 *            <div lang="en">The agent who attacks.</div>
	 * @param target
	 *            <div lang="ja">被襲撃エージェント</div>
	 * 
	 *            <div lang="en">The attacked agent.</div>
	 * 
	 */
	public AttackContentBuilder(Agent subject, Agent target) {
		topic = Topic.ATTACK;
		this.subject = subject;
		this.target = target;
	}

}
