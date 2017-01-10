/**
 * GuardedContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">護衛報告発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the report of the guard.</div>
 * 
 * @author otsuki
 *
 */
public class GuardedContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code target}を護衛したことの報告のためのGuardedContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an GuardedContentBuilder for the report of the guard of {@code target}.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">主語を表す{@code Agent}</div>
	 *
	 *            <div lang="en">{@code Agent} representing the subject.</div>
	 * @param target
	 *            <div lang="ja">被護衛エージェント</div>
	 * 
	 *            <div lang="en">The agent the utterer guarded.</div>
	 * 
	 */
	public GuardedContentBuilder(Agent subject, Agent target) {
		topic = Topic.GUARDED;
		this.subject = subject;
		this.target = target;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { subject.toString(), Topic.GUARDED.toString(), target.toString() });
	}

}
