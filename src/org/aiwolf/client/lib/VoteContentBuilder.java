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
 * <div lang="en">Builder class for the utterance of vote.</div>
 * 
 * @author otsuki
 *
 */
public class VoteContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code target}の追放に投票する意思表明のためのVoteContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an VoteContentBuilder for the declaration of voting for execution of {@code target}.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">主語を表す{@code Agent}</div>
	 *
	 *            <div lang="en">{@code Agent} representing the subject.</div>
	 * @param target
	 *            <div lang="ja">被投票エージェント</div>
	 * 
	 *            <div lang="en">The agent the utterer will vote for.</div>
	 * 
	 */
	public VoteContentBuilder(Agent subject, Agent target) {
		topic = Topic.VOTE;
		this.subject = subject;
		this.target = target;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject.toString(), Topic.VOTE.toString(), target.toString() });
	}

}
