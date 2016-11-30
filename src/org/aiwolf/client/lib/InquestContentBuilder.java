/**
 * InquestContetnBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">霊媒結果発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of inquest</div>
 * 
 * @author otsuki
 *
 */
public class InquestContentBuilder extends ContentBuilder {

	public InquestContentBuilder(Agent target, Species result) {
		topic = Topic.INQUESTED;
		this.target = target;
		state = State.parseState(result);
		text = String.join(" ", new String[] { Topic.INQUESTED.toString(), String.valueOf(target.toString()), result.toString() });
	}

}
