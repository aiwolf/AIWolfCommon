/**
 * AttackedContentBuilder.java
 * 
 * Copyright (c) 2019 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">襲撃報告ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the report of an attack.</div>
 * 
 * @author otsuki
 *
 */
public class AttackedContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">襲撃報告のためのAttackedContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs an AttackedContentBuilder for the report of an attack (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被襲撃エージェント</div>
	 * 
	 *            <div lang="en">The attacked agent.</div>
	 * 
	 */
	public AttackedContentBuilder(Agent target) {
		this(Content.UNSPEC, target);
	}

	/**
	 * <div lang="ja">襲撃報告のためのAttackedContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an AttackedContentBuilder for the report of an attack.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">襲撃をしたエージェント</div>
	 * 
	 *            <div lang="en">The agent who attacked.</div>
	 * @param target
	 *            <div lang="ja">被襲撃エージェント</div>
	 * 
	 *            <div lang="en">The attacked agent.</div>
	 * 
	 */
	public AttackedContentBuilder(Agent subject, Agent target) {
		topic = Topic.ATTACKED;
		this.subject = subject;
		this.target = target;
	}

}
