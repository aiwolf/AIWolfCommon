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
	 * <div lang="ja">占い行為について発話するためのDivinationContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a DivinationContentBuilder to utter a divination.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被占いエージェント</div>
	 * 
	 *            <div lang="en">The agent to be divined.</div>
	 */
	public DivinationContentBuilder(Agent target) {
		topic = Topic.DIVINATION;
		this.target = target;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject == null ? "" : subject.toString(), Topic.DIVINATION.toString(), target.toString() }).trim();
	}

}
