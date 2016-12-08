/**
 * ContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">発話ビルダー抽象クラス</div>
 * 
 * <div lang="en">Abstract builder class for utterance</div>
 * 
 * @author otsuki
 *
 */
public abstract class ContentBuilder {

	protected Topic topic = null;
	protected Agent target = null;
	protected State state = null;
	protected TalkType talkType = null;
	protected int talkDay = -1;
	protected int talkID = -1;

	/**
	 * @return the text of content
	 */
	public abstract String getText();

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

}
