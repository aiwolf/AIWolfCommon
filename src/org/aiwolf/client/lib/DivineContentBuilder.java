/**
 * DivineContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">占い発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of divination.</div>
 * 
 * @author otsuki
 *
 */
public class DivineContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code target}の占いのためのDivineContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an DivineContentBuilder for the divination of {@code target}.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">主語を表す{@code Agent}</div>
	 *
	 *            <div lang="en">{@code Agent} representing the subject.</div>
	 * @param target
	 *            <div lang="ja">占うエージェントを表す{@code Agent}</div>
	 * 
	 *            <div lang="en">{@code Agent} to be divined.</div>
	 */
	public DivineContentBuilder(Agent subject, Agent target) {
		topic = Topic.DIVINE;
		this.subject = subject;
		this.target = target;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject.toString(), Topic.DIVINE.toString(), target.toString() });
	}

}
