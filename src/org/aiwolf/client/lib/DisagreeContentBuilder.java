/**
 * DisagreeContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

/**
 * <div lang="ja">不同意発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of disagreement.</div>
 * 
 * @author otsuki
 *
 */
public class DisagreeContentBuilder extends ContentBuilder {

	/**
	 * <div lang="ja">{@code talkDay}日目の{@code talkID}番の{@code talkType}発話への不同意のためのDisagreeContentBuilderを構築する</div>
	 *
	 * <div lang="en">Constructs an DisagreeContentBuilder for the disagreement with the {@code talkID}-th {@code talkType} utterance on {@code talkDay}.</div>
	 * 
	 * @param talkType
	 *            <div lang="ja">被不同意発話のタイプ。TALKあるいはWHISPER</div>
	 *
	 *            <div lang="en">Type of the utterance the utterer disagrees with. TALK or WHISPER.</div>
	 * @param talkDay
	 *            <div lang="ja">被不同意発話の日</div>
	 *
	 *            <div lang="en">The day of utterance the utterer disagrees with.</div>
	 * @param talkID
	 *            <div lang="ja">被不同意発話のID</div>
	 *
	 *            <div lang="en">The ID of the utterance the utterer disagrees with.</div>
	 * 
	 */
	public DisagreeContentBuilder(TalkType talkType, int talkDay, int talkID) {
		topic = Topic.DISAGREE;
		this.talkType = talkType;
		this.talkDay = talkDay;
		this.talkID = talkID;
	}

	@Override
	String getText() {
		return String.join(" ", new String[] { Topic.DISAGREE.toString(), talkType.toString(), "day" + talkDay, "ID:" + talkID });
	}

}
