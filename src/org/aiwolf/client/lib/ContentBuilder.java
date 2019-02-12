/**
 * ContentBuilder.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	static String join(CharSequence delimiter, CharSequence... elements) {
		return join(delimiter, Arrays.asList(elements));
	}

	static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
		Objects.requireNonNull(delimiter);
		Objects.requireNonNull(elements);
		StringBuilder sb = new StringBuilder();
		Iterator<? extends CharSequence> it = elements.iterator();
		sb.append(it.next());
		while (it.hasNext()) {
			sb.append(delimiter);
			sb.append(it.next());
		}
		return sb.toString();
	}

	Operator operator = null;
	Topic topic = null;
	Agent subject = Agent.UNSPEC;
	Agent target = Agent.ANY;
	Role role = null;
	Species result = null;
	TalkType talkType = null;
	int talkDay = -1;
	int talkID = -1;
	List<Content> contentList = null;
	int day = -1;

	/**
	 * @return the text of content
	 */
	abstract String getText();

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

	private static final Pattern stripPattern = Pattern.compile("^(Agent\\[\\d+\\]|ANY|)\\s*(\\p{Upper}+)(.*)$");

	String stripSubject(String input) {
		Matcher m = stripPattern.matcher(input);
		if (m.find()) {
			return m.group(2) + m.group(3);
		}
		return input;
	}

}
