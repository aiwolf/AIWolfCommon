/**
 * InquestContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">霊媒結果発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the report of a inquest.</div>
 * 
 * @author otsuki
 *
 */
public class InquestContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">霊媒結果の報告のためのInquetContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an InquestContentBuilder to report a inquest.</div>
	 * 
	 * @param target
	 *            <div lang="ja">被霊媒エージェント</div>
	 * 
	 *            <div lang="en">The agent who the inquest was hold on.</div>
	 * @param result
	 *            <div lang="ja">霊媒の結果</div>
	 * 
	 *            <div lang="en">The species of {@code target}.</div>
	 */
	public InquestContentBuilder(Agent target, Species result) {
		topic = Topic.INQUESTED;
		this.target = target;
		this.result = result;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.INQUESTED.toString(), target.toString(), result.toString() });
	}

}
