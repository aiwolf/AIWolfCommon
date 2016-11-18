/**
 * AgreeContetnBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.client.lib.TemplateTalkFactory.TalkType;

/**
 * <div lang="ja">同意発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for the utterance of agreement</div>
 * 
 * @author otsuki
 *
 */
public class AgreeContentBuilder extends ContentBuilder {

	/**
	 * 
	 * @param talkType
	 * @param talkDay
	 * @param talkID
	 */
	public AgreeContentBuilder(TalkType talkType, int talkDay, int talkID) {
		topic = Topic.AGREE;
		this.talkType = talkType;
		this.talkDay = talkDay;
		this.talkID = talkID;
		text = wordAttachment(new String[] { Topic.AGREE.toString(), talkType.toString(), "day" + String.valueOf(talkDay), "ID:" + String.valueOf(talkID) });
	}

}
