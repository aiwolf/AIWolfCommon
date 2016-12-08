/**
 * GuardContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">護衛発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of guard</div>
 * 
 * @author otsuki
 *
 */
public class GuardContentBuilder extends ContentBuilder {

	public GuardContentBuilder(Agent target) {
		topic = Topic.GUARDED;
		this.target = target;
	}

	@Override
	public String getText() {
		return String.join(" ", new String[] { Topic.GUARDED.toString(), String.valueOf(target.toString()) });
	}

}
