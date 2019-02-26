/**
 * DisagreeContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">不同意発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of a disagreement.</div>
 * 
 * @author otsuki
 *
 */
public class DisagreeContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">他の発話への不同意を発話するためのDisagreeContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs a DisagreeContentBuilder to utter the disagreement with the other utterance (with no subject specified).</div>
	 * 
	 * @param talkType
	 *            <div lang="ja">被不同意発話のタイプ。TALKあるいはWHISPER</div>
	 *
	 *            <div lang="en">Type of the utterance disagreed with. TALK or WHISPER.</div>
	 * @param talkDay
	 *            <div lang="ja">被不同意発話の日</div>
	 *
	 *            <div lang="en">The day of the utterance disagreed with.</div>
	 * @param talkID
	 *            <div lang="ja">被不同意発話のID</div>
	 *
	 *            <div lang="en">The ID of the utterance disagreed with.</div>
	 * 
	 */
	public DisagreeContentBuilder(TalkType talkType, int talkDay, int talkID) {
		this(Content.UNSPEC, talkType, talkDay, talkID);
	}

	/**
	 * <div lang="ja">他の発話への不同意を発話するためのDisagreeContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs a DisagreeContentBuilder to utter the disagreement with the other utterance.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">不同意を表明しているエージェント</div>
	 *
	 *            <div lang="en">Type agent who disagrees.</div>
	 * @param talkType
	 *            <div lang="ja">被不同意発話のタイプ。TALKあるいはWHISPER</div>
	 *
	 *            <div lang="en">Type of the utterance disagreed with. TALK or WHISPER.</div>
	 * @param talkDay
	 *            <div lang="ja">被不同意発話の日</div>
	 *
	 *            <div lang="en">The day of the utterance disagreed with.</div>
	 * @param talkID
	 *            <div lang="ja">被不同意発話のID</div>
	 *
	 *            <div lang="en">The ID of the utterance disagreed with.</div>
	 * 
	 */
	public DisagreeContentBuilder(Agent subject, TalkType talkType, int talkDay, int talkID) {
		topic = Topic.DISAGREE;
		this.subject = subject;
		this.talkType = talkType;
		this.talkDay = talkDay;
		this.talkID = talkID;
	}

}
