/**
 * VoteContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">投票発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of vote</div>
 * 
 * @author otsuki
 *
 */
public class VoteContentBuilder extends ContentBuilder {

	public VoteContentBuilder(Agent target) {
		topic = Topic.VOTE;
		this.target = target;
	}

	@Override
	public String getText() {
		return String.join(" ", new String[] { Topic.VOTE.toString(), String.valueOf(target.toString()) });
	}

}
