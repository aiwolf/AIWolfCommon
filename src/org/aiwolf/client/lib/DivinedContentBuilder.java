/**
 * DivinedContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">占い結果報告ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the report of a divination.</div>
 * 
 * @author otsuki
 *
 */
public class DivinedContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">占いの結果報告のためのDivinedContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a DivinedContentBuilder to report the result of a divination.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被占いエージェント</div>
	 * 
	 *            <div lang="en">The agent divined.</div>
	 * @param result
	 *            <div lang="ja">{@code target}の種族</div>
	 * 
	 *            <div lang="en">The species of {@code target}.</div>
	 */
	public DivinedContentBuilder(Agent target, Species result) {
		topic = Topic.DIVINED;
		this.target = target;
		this.result = result;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.DIVINED.toString(), target.toString(), result.toString() });
	}

}
