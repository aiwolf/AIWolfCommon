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

	DIVINATION,

	DIVINED,

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

	public static Topic getTopic(String s) {
		for (Topic topic : Topic.values()) {
			if (topic.toString().equalsIgnoreCase(s)) {
				return topic;
			}
		}
		switch (s) {
		case "REQUEST":
		case "BECAUSE":
		case "AND":
		case "OR":
		case "XOR":
		case "NOT":
			return Topic.OPERATOR;
		default:
			break;
		}
		return null;
	}

}
