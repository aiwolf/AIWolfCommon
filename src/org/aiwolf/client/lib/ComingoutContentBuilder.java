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
 * <div lang="en">Builder class for the utterance of a coming-out.</div>
 * 
 * @author otsuki
 *
 */
public class ComingoutContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">カミングアウトのためのComingoutContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a ComingoutContentBuilder for a coming-out.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被カミングアウトエージェント</div>
	 * 
	 *            <div lang="en">The agent whose role is come out with.</div>
	 * @param role
	 *            <div lang="ja">被カミングアウト役職</div>
	 * 
	 *            <div lang="en">The role come out with.</div>
	 */
	public ComingoutContentBuilder(Agent target, Role role) {
		topic = Topic.COMINGOUT;
		this.target = target;
		this.role = role;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject == null ? "" : subject.toString(), Topic.COMINGOUT.toString(), target.toString(), role.toString() }).trim();
	}

}
