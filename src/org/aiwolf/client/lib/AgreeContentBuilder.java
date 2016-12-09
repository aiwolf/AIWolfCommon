/**
 * AgreeContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

/**
 * <div lang="ja">同意発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of agreement.</div>
 * 
 * @author otsuki
 *
 */
public class AgreeContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code talkDay}日目の{@code talkID}番の{@code talkType}発話への同意のためのAgreeContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an AgreeContentBuilder for the agreement with the {@code talkID}-th {@code talkType} utterance on {@code talkDay}.</div>
	 * 
	 * @param talkType
	 *            <div lang="ja">被同意発話のタイプ。TALKあるいはWHISPER</div>
	 *
	 *            <div lang="en">Type of the utterance the utterer agrees with. TALK or WHISPER.</div>
	 * @param talkDay
	 *            <div lang="ja">被同意発話の日</div>
	 *
	 *            <div lang="en">The day of utterance the utterer agrees with.</div>
	 * @param talkID
	 *            <div lang="ja">被同意発話のID</div>
	 *
	 *            <div lang="en">The ID of the utterance the utterer agrees with.</div>
	 * 
	 */
	public AgreeContentBuilder(TalkType talkType, int talkDay, int talkID) {
		topic = Topic.AGREE;
		this.talkType = talkType;
		this.talkDay = talkDay;
		this.talkID = talkID;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.AGREE.toString(), talkType.toString(), "day" + String.valueOf(talkDay), "ID:" + String.valueOf(talkID) });
	}

}
