/**
 * ContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Species;

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
	Agent subject = null;
	Agent target = null;
	Role role = null;
	Species result = null;
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
	 * @return the subject
	 */
	Agent getSubject() {
		return subject;
	}

	/**
	 * @return the target
	 */
	Agent getTarget() {
		return target;
	}

	/**
	 * @return the role
	 */
	Role getRole() {
		return role;
	}

	/**
	 * @return the result
	 */
	Species getResult() {
		return result;
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
