/**
 * DivinationContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">占い発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of a divination.</div>
 * 
 * @author otsuki
 *
 */
public class DivinationContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">占い行為について発話するためのDivinationContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a DivinationContentBuilder to utter a divination (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被占いエージェント</div>
	 * 
	 *            <div lang="en">The agent to be divined.</div>
	 */
	public DivinationContentBuilder(Agent target) {
		this(Content.UNSPEC, target);
	}

	/**
	 * <div lang="ja">占い行為について発話するためのDivinationContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a DivinationContentBuilder to utter a divination.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">占いをするエージェント</div>
	 * 
	 *            <div lang="en">The agent who divines.</div>
	 * @param target
	 *            <div lang="ja">被占いエージェント</div>
	 * 
	 *            <div lang="en">The agent to be divined.</div>
	 */
	public DivinationContentBuilder(Agent subject, Agent target) {
		topic = Topic.DIVINATION;
		this.subject = subject;
		this.target = target;
	}

}
