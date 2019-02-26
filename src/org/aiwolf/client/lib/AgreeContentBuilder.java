/**
 * AgreeContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">同意発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of an agreement.</div>
 * 
 * @author otsuki
 *
 */
public class AgreeContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">他の発話への同意を発話するためのAgreeContentBuilderを構築する(主語の指定なし)</div>
	 *
	 * <div lang="en">Constructs an AgreeContentBuilder to utter the agreement with the other utterance (with no subject specified).</div>
	 * 
	 * @param talkType
	 *            <div lang="ja">被同意発話のタイプ。TALKあるいはWHISPER</div>
	 *
	 *            <div lang="en">Type of the utterance agreed with. TALK or WHISPER.</div>
	 * @param talkDay
	 *            <div lang="ja">被同意発話の日</div>
	 *
	 *            <div lang="en">The day of the utterance agreed with.</div>
	 * @param talkID
	 *            <div lang="ja">被同意発話のID</div>
	 *
	 *            <div lang="en">The ID of the utterance agreed with.</div>
	 * 
	 */
	public AgreeContentBuilder(TalkType talkType, int talkDay, int talkID) {
		this(Content.UNSPEC, talkType, talkDay, talkID);
	}

	/**
	 * <div lang="ja">他の発話への同意を発話するためのAgreeContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an AgreeContentBuilder to utter the agreement with the other utterance.</div>
	 * 
	 * @param subject
	 *            <div lang="ja">同意を表明しているエージェント</div>
	 * 
	 *            <div lang="en">The agent who agrees.</div>
	 * @param talkType
	 *            <div lang="ja">被同意発話のタイプ。TALKあるいはWHISPER</div>
	 *
	 *            <div lang="en">Type of the utterance agreed with. TALK or WHISPER.</div>
	 * @param talkDay
	 *            <div lang="ja">被同意発話の日</div>
	 *
	 *            <div lang="en">The day of the utterance agreed with.</div>
	 * @param talkID
	 *            <div lang="ja">被同意発話のID</div>
	 *
	 *            <div lang="en">The ID of the utterance agreed with.</div>
	 * 
	 */
	public AgreeContentBuilder(Agent subject, TalkType talkType, int talkDay, int talkID) {
		topic = Topic.AGREE;
		this.subject = subject;
		this.talkType = talkType;
		this.talkDay = talkDay;
		this.talkID = talkID;
	}

}
