/**
 * ContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;

/**
 * <div lang="ja">発話内容ビルダー抽象クラス</div>
 * 
 * <div lang="en">Abstract builder class for content of utterance.</div>
 * 
 * @author otsuki
 *
 */
public abstract class ContentBuilder {

	Topic topic = null;
	Agent target = null;
	State state = null;
	TalkType talkType = null;
	int talkDay = -1;
	int talkID = -1;

	/**
	 * @return the text of content
	 */
	abstract String getText();

	/**
	 * @return the topic
	 */
	Topic getTopic() {
		return topic;
	}

	/**
	 * @return the target
	 */
	Agent getTarget() {
		return target;
	}

	/**
	 * @return the state
	 */
	State getState() {
		return state;
	}

	/**
	 * @return the talkType
	 */
	TalkType getTalkType() {
		return talkType;
	}

	/**
	 * @return the talkDay
	 */
	int getTalkDay() {
		return talkDay;
	}

	/**
	 * @return the talkID
	 */
	int getTalkID() {
		return talkID;
	}

}
