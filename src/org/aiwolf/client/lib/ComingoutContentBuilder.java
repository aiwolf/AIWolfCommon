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
 * <div lang="en">Builder class for the utterance of comingout.</div>
 * 
 * @author otsuki
 *
 */
public class ComingoutContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code target}の役職が{@code role}であるとのカミングアウトのためのComingoutContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an ComingoutContentBuilder for coming out with that {@code target} acts as {@code role}.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被カミングアウトエージェント</div>
	 * 
	 *            <div lang="en">The agent whose role the utterer comes out with.</div>
	 * @param role
	 *            <div lang="ja">被カミングアウト役職</div>
	 * 
	 *            <div lang="en">The role the utterer comes out with.</div>
	 */
	public ComingoutContentBuilder(Agent target, Role role) {
		topic = Topic.COMINGOUT;
		this.target = target;
		this.role = role;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.COMINGOUT.toString(), target.toString(), role.toString() });
	}

}
