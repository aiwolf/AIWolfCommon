/**
 * IdentContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">霊媒結果発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the report of an identification.</div>
 * 
 * @author otsuki
 *
 */
public class IdentContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">霊媒結果の報告のためのIdentContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs an IdentContentBuilder to report an identification (with no subject specified).</div>
	 * 
	 * @param target
	 *            <div lang="ja">被霊媒エージェント</div>
	 * 
	 *            <div lang="en">The identified agent.</div>
	 * @param result
	 *            <div lang="ja">霊媒の結果</div>
	 * 
	 *            <div lang="en">The species of {@code target}.</div>
	 */
	public IdentContentBuilder(Agent target, Species result) {
		this(Content.UNSPEC, target, result);
	}

	/**
	 * <div lang="ja">霊媒結果の報告のためのIdentContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an IdentContentBuilder to report an identification.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">霊能力を行使したエージェント</div>
	 * 
	 *            <div lang="en">The agent who identified.</div>
	 * @param target
	 *            <div lang="ja">被霊媒エージェント</div>
	 * 
	 *            <div lang="en">The identified agent.</div>
	 * @param result
	 *            <div lang="ja">霊媒の結果</div>
	 * 
	 *            <div lang="en">The species of {@code target}.</div>
	 */
	public IdentContentBuilder(Agent subject, Agent target, Species result) {
		topic = Topic.IDENTIFIED;
		this.subject = subject;
		this.target = target;
		this.result = result;
	}

}
