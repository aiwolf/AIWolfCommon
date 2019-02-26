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
 * <div lang="en">Builder class for the utterance of a vote.</div>
 * 
 * @author otsuki
 *
 */
public class VoteContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">投票発話のためのVoteContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a VoteContentBuilder for the utterance of a vote (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被投票エージェント</div>
	 * 
	 *            <div lang="en">The voted agent.</div>
	 * 
	 */
	public VoteContentBuilder(Agent target) {
		this(Content.UNSPEC, target);
	}

	/**
	 * <div lang="ja">投票発話のためのVoteContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a VoteContentBuilder for the utterance of a vote.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">投票をするエージェント</div>
	 * 
	 *            <div lang="en">The agent who votes.</div>
	 * @param target
	 *            <div lang="ja">被投票エージェント</div>
	 * 
	 *            <div lang="en">The voted agent.</div>
	 * 
	 */
	public VoteContentBuilder(Agent subject, Agent target) {
		topic = Topic.VOTE;
		this.subject = subject;
		this.target = target;
	}

}
