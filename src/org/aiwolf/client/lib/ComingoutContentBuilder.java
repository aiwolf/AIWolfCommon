/**
 * ComingoutContetnBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;

/**
 * <div lang="ja">カミングアウト発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of comingout</div>
 * 
 * @author otsuki
 *
 */
public class ComingoutContentBuilder extends ContentBuilder {

	public ComingoutContentBuilder(Agent target, Role role) {
		topic = Topic.COMINGOUT;
		this.target = target;
		state = State.parseState(role);
		text = String.join(" ", new String[] { Topic.COMINGOUT.toString(), String.valueOf(target.toString()), role.toString() });
	}

}
