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
 * <div lang="en">Builder class for the report of the divination.</div>
 * 
 * @author otsuki
 *
 */
public class DivinedContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">占いの結果{@code target}が{@code result}であるとの報告のためのDivinedContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an DivinedContentBuilder for reporting that the utterer divined that {@code target} is {@code result}.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">主語を表す{@code Agent}</div>
	 *
	 *            <div lang="en">{@code Agent} representing the subject.</div>
	 * @param target
	 *            <div lang="ja">占われたエージェント</div>
	 * 
	 *            <div lang="en">The agent divined by the utterer.</div>
	 * @param result
	 *            <div lang="ja">占いの結果</div>
	 * 
	 *            <div lang="en">The species of {@code target} divined by the utterer.</div>
	 */
	public DivinedContentBuilder(Agent subject, Agent target, Species result) {
		topic = Topic.DIVINED;
		this.subject = subject;
		this.target = target;
		this.result = result;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject.toString(), Topic.DIVINED.toString(), target.toString(), result.toString() });
	}

}
