/**
 * Topic.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

/**
 * <div lang="ja">文のトピックを表す列挙型</div>
 *
 * <div lang="en">Enum type representing the topic of the sentence.</div>
 * 
 */
public enum Topic {

	ESTIMATE,

	COMINGOUT,

	DIVINE,

	DIVINED,

	/**
	 * @deprecated
	 */
	INQUESTED,

	IDENTIFIED,

	GUARD,

	GUARDED,

	VOTE,

	ATTACK,

	AGREE,

	DISAGREE,

	OVER,

	SKIP,

	OPERATOR;

	public static Topic getTopic(String string) {
		if (string.equalsIgnoreCase(INQUESTED.toString())) {
			return IDENTIFIED;
		}
		for (Topic topic : Topic.values()) {
			if (topic.toString().equalsIgnoreCase(string)) {
				return topic;
			}
		}
		return null;
	}

}
