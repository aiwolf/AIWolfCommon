/**
 * DivinedResultContentBuilder.java
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
public class DivinedResultContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">占いの結果報告のためのDivinedResultContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a DivinedResultContentBuilder to report the result of a divination (with no subject specified).</div>
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
	public DivinedResultContentBuilder(Agent target, Species result) {
		this(Content.UNSPEC, target, result);
	}

	/**
	 * <div lang="ja">占いの結果報告のためのDivinedResultContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a DivinedResultContentBuilder to report the result of a divination.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">占いを行ったエージェント</div>
	 * 
	 *            <div lang="en">The agent who divined.</div>
	 * @param target
	 *            <div lang="ja">被占いエージェント</div>
	 * 
	 *            <div lang="en">The divined agent.</div>
	 * @param result
	 *            <div lang="ja">{@code target}の種族</div>
	 * 
	 *            <div lang="en">The species of {@code target}.</div>
	 */
	public DivinedResultContentBuilder(Agent subject, Agent target, Species result) {
		topic = Topic.DIVINED;
		this.subject = subject;
		this.target = target;
		this.result = result;
	}

}
