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

	INQUESTED,

	GUARD,

	GUARDED,

	VOTE,

	ATTACK,

	AGREE,

	DISAGREE,

	OVER,

	SKIP;

	public static Topic getTopic(String string) {
		for (Topic topic : Topic.values()) {
			if (topic.toString().equalsIgnoreCase(string)) {
				return topic;
			}
		}
		return null;
	}

}
