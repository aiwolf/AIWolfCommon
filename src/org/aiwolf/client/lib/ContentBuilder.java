/**
 * ContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.List;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Species;

/**
 * <div lang="ja">発話内容ビルダー抽象クラス</div>
 * 
 * <div lang="en">Abstract builder class for the content of a utterance.</div>
 * 
 * @author otsuki
 *
 */
public abstract class ContentBuilder {

	Operator operator = null;
	Topic topic = null;
	Agent subject = Content.UNSPEC;
	Agent target = Content.ANY;
	Role role = null;
	Species result = null;
	TalkType talkType = null;
	int talkDay = -1;
	int talkID = -1;
	List<Content> contentList = null;
	int day = -1;

	/**
	 * @return the operator
	 */
	Operator getOperator() {
		return operator;
	}

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

	/**
	 * @return the contentList
	 */
	List<Content> getContentList() {
		return contentList;
	}

	/**
	 * @return the day
	 */
	int getDay() {
		return day;
	}

}
