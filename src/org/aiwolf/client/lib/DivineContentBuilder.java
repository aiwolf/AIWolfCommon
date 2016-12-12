/**
 * DivineContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">占い結果発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of divination.</div>
 * 
 * @author otsuki
 *
 */
public class DivineContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">占いの結果{@code target}が{@code result}であるとの報告のためのDivineContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an DivineContentBuilder for reporting that the utterer divined that {@code target} is {@code result}.</div>
	 * 
	 * @param target
	 *            <div lang="ja">占われたエージェント</div>
	 * 
	 *            <div lang="en">The agent divined by the utterer.</div>
	 * @param result
	 *            <div lang="ja">占いの結果</div>
	 * 
	 *            <div lang="en">The species of {@code target} divined by the utterer.</div>
	 */
	public DivineContentBuilder(Agent target, Species result) {
		topic = Topic.DIVINED;
		this.target = target;
		this.result = result;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.DIVINED.toString(), String.valueOf(target.toString()), result.toString() });
	}

}
