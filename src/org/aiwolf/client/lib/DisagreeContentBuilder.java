/**
 * DisagreeContetnBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

/**
 * <div lang="ja">非同意発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of disagreement</div>
 * 
 * @author otsuki
 *
 */
public class DisagreeContentBuilder extends ContentBuilder {

	public DisagreeContentBuilder(TalkType talkType, int talkDay, int talkID) {
		topic = Topic.DISAGREE;
		this.talkType = talkType;
		this.talkDay = talkDay;
		this.talkID = talkID;
		text = wordAttachment(new String[] { Topic.DISAGREE.toString(), talkType.toString(), "day" + String.valueOf(talkDay), "ID:" + String.valueOf(talkID) });
	}

}
