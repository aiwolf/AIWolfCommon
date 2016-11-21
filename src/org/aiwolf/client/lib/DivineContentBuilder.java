/**
 * DivineContetnBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">占い結果発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of divination</div>
 * 
 * @author otsuki
 *
 */
public class DivineContentBuilder extends ContentBuilder {

	public DivineContentBuilder(Agent target, Species result) {
		topic = Topic.DIVINED;
		this.target = target;
		state = State.parseState(result);
		text = String.join(" ", new String[] { Topic.DIVINED.toString(), String.valueOf(target.toString()), result.toString() });
	}

}
