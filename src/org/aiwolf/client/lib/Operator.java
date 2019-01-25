/**
 * Operator.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

/**
 * <div lang="ja">{@code Content}どうしの関係を表す演算子の列挙型</div>
 *
 * <div lang="en">Enum type of operators representing the relationship among {@code Content}s.</div>
 * 
 * @author otsuki
 */
public enum Operator {

	/**
	 * <div lang="ja">行動の要求</div>
	 *
	 * <div lang="en">Request for the action.</div>
	 */
	REQUEST,

	/**
	 * <div lang="ja">行動の理由</div>
	 *
	 * <div lang="en">Reason for the action.</div>
	 */
	BECAUSE,

	/**
	 * <div lang="ja"></div>
	 *
	 * <div lang="en"></div>
	 */
	DAY,

	/**
	 * <div lang="ja"></div>
	 *
	 * <div lang="en"></div>
	 */
	NOT,

	/**
	 * <div lang="ja"></div>
	 *
	 * <div lang="en"></div>
	 */
	AND,

	/**
	 * <div lang="ja"></div>
	 *
	 * <div lang="en"></div>
	 */
	OR,

	/**
	 * <div lang="ja"></div>
	 *
	 * <div lang="en"></div>
	 */
	XOR
}
