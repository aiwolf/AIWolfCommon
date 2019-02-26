/**
 * VotedContentBuilder.java
 * 
 * Copyright (c) 2019 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">投票報告ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the report of a vote.</div>
 * 
 * @author otsuki
 *
 */
public class VotedContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">投票報告のためのVotedContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a VotedContentBuilder for the report of a vote (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被投票エージェント</div>
	 * 
	 *            <div lang="en">The voted agent.</div>
	 */
	public VotedContentBuilder(Agent target) {
		this(Content.UNSPEC, target);
	}

	/**
	 * <div lang="ja">投票報告のためのVotedContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a VotedContentBuilder for the report of a vote.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">投票をしたエージェント</div>
	 * 
	 *            <div lang="en">The agent who voted.</div>
	 * @param target
	 *            <div lang="ja">被投票エージェント</div>
	 * 
	 *            <div lang="en">The voted agent.</div>
	 */
	public VotedContentBuilder(Agent subject, Agent target) {
		topic = Topic.VOTED;
		this.subject = subject;
		this.target = target;
	}

}
