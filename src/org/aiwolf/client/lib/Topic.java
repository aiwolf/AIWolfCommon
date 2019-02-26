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
 * @author otsuki
 */
public enum Topic {

	/**
	 * <div lang="ja">推測</div>
	 *
	 * <div lang="en">Estimate</div>
	 */
	ESTIMATE,

	/**
	 * <div lang="ja">カミングアウト</div>
	 *
	 * <div lang="en">CO</div>
	 */
	COMINGOUT,

	/**
	 * <div lang="ja">占い宣言</div>
	 *
	 * <div lang="en">Divination of a divination</div>
	 */
	DIVINATION,

	/**
	 * <div lang="ja">占い報告</div>
	 *
	 * <div lang="en">Report of a divination</div>
	 */
	DIVINED,

	/**
	 * <div lang="ja">霊媒報告</div>
	 *
	 * <div lang="en">Report of an identification</div>
	 */
	IDENTIFIED,

	/**
	 * <div lang="ja">護衛宣言</div>
	 *
	 * <div lang="en">Declaration of a guard</div>
	 */
	GUARD,

	/**
	 * <div lang="ja">護衛報告</div>
	 *
	 * <div lang="en">Report of a guard</div>
	 */
	GUARDED,

	/**
	 * <div lang="ja">投票宣言</div>
	 *
	 * <div lang="en">Declaration of a vote</div>
	 */
	VOTE,

	/**
	 * <div lang="ja">投票報告</div>
	 *
	 * <div lang="en">Report of a vote</div>
	 */
	VOTED,

	/**
	 * <div lang="ja">襲撃宣言</div>
	 *
	 * <div lang="en">Declaration of an attack</div>
	 */
	ATTACK,

	/**
	 * <div lang="ja">襲撃報告</div>
	 *
	 * <div lang="en">Report of an attack</div>
	 */
	ATTACKED,

	/**
	 * <div lang="ja">同意</div>
	 *
	 * <div lang="en">Agreement</div>
	 */
	AGREE,

	/**
	 * <div lang="ja">不同意</div>
	 *
	 * <div lang="en">Disagreement</div>
	 */
	DISAGREE,

	/**
	 * <div lang="ja">OVER</div>
	 *
	 * <div lang="en">OVER</div>
	 */
	OVER,

	/**
	 * <div lang="ja">SKIP</div>
	 *
	 * <div lang="en">SKIP</div>
	 */
	SKIP,

	/**
	 * <div lang="ja">演算子</div>
	 *
	 * <div lang="en">Operator</div>
	 */
	OPERATOR;

	/**
	 * <div lang="ja">文字列が表すTopicを返す．演算子の場合は{@code OPERATOR}を返す</div>
	 *
	 * <div lang="en">Returns the Topic that the given string represents.
	 * If the string represents an operator, this returns {@code OPERATOR}.</div>
	 * 
	 * @param s
	 *            <div lang="ja">TopicあるいはOperatorの文字列</div>
	 *
	 *            <div lang="en">String representing Topic or Operator.
	 * @return
	 * 		<div lang="ja">与えられた文字列に対応するTopic</div>
	 *
	 *         <div lang="en">Topic corresponding to the given string.
	 */
	public static Topic getTopic(String s) {
		for (Topic topic : Topic.values()) {
			if (topic.toString().equalsIgnoreCase(s)) {
				return topic;
			}
		}
		switch (s) {
		case "REQUEST":
		case "BECAUSE":
		case "INQUIRE":
		case "AND":
		case "OR":
		case "XOR":
		case "NOT":
		case "DAY":
			return Topic.OPERATOR;
		default:
			break;
		}
		return null;
	}

}
