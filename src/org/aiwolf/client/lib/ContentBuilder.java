/**
 * ContetnBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.client.lib.TemplateTalkFactory.TalkType;
import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">発話ビルダークラス</div>
 * 
 * <div lang="en">Builder class for utterance</div>
 * 
 * @author otsuki
 *
 */
public class ContentBuilder {

	protected String text = null;
	protected Topic topic = null;
	protected Agent target = null;
	protected State state = null;
	protected TalkType talkType = null;
	protected int talkDay = -1;
	protected int talkID = -1;

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * @return the target
	 */
	public Agent getTarget() {
		return target;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @return the talkType
	 */
	public TalkType getTalkType() {
		return talkType;
	}

	/**
	 * @return the talkDay
	 */
	public int getTalkDay() {
		return talkDay;
	}

	/**
	 * @return the talkID
	 */
	public int getTalkID() {
		return talkID;
	}

	public Content build() {
		return new Content(this);
	}

	protected static String wordAttachment(String[] split) {
		String answer = "";
		for (int i = 0; i < split.length; i++) {
			answer += split[i] + " ";
		}
		return answer.trim();
	}

}
