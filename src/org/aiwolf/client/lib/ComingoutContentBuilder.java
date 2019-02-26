/**
 * ComingoutContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;

/**
 * <div lang="ja">カミングアウト発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of a CO.</div>
 * 
 * @author otsuki
 *
 */
public class ComingoutContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">カミングアウトのためのComingoutContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a ComingoutContentBuilder for a CO (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被カミングアウトエージェント</div>
	 * 
	 *            <div lang="en">The agent whose role is disclosed.</div>
	 * @param role
	 *            <div lang="ja">被カミングアウト役職</div>
	 * 
	 *            <div lang="en">The disclosed role.</div>
	 */
	public ComingoutContentBuilder(Agent target, Role role) {
		this(Content.UNSPEC, target, role);
	}

	/**
	 * <div lang="ja">カミングアウトのためのComingoutContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a ComingoutContentBuilder for a CO.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">カミングアウトをするエージェント</div>
	 * 
	 *            <div lang="en">The agent who discloses.</div>
	 * @param target
	 *            <div lang="ja">被カミングアウトエージェント</div>
	 * 
	 *            <div lang="en">The agent whose role is disclosed.</div>
	 * @param role
	 *            <div lang="ja">被カミングアウト役職</div>
	 * 
	 *            <div lang="en">The disclosed role.</div>
	 */
	public ComingoutContentBuilder(Agent subject, Agent target, Role role) {
		topic = Topic.COMINGOUT;
		this.subject = subject;
		this.target = target;
		this.role = role;
	}

}
