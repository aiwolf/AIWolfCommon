/**
 * Operator.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

/**
 * <div lang="ja">{@code Content}の演算子の列挙型</div>
 *
 * <div lang="en">Enum type of operators of {@code Content}s.</div>
 * 
 * @author otsuki
 */
public enum Operator {

	/**
	 * <div lang="ja">要求</div>
	 *
	 * <div lang="en">Request</div>
	 */
	REQUEST,

	/**
	 * <div lang="ja">照会</div>
	 *
	 * <div lang="en">Inquiry</div>
	 */
	INQUIRE,

	/**
	 * <div lang="ja">理由</div>
	 *
	 * <div lang="en">Reason</div>
	 */
	BECAUSE,

	/**
	 * <div lang="ja">日付</div>
	 *
	 * <div lang="en">Day</div>
	 */
	DAY,

	/**
	 * <div lang="ja">NOT</div>
	 *
	 * <div lang="en">NOT</div>
	 */
	NOT,

	/**
	 * <div lang="ja">AND</div>
	 *
	 * <div lang="en">AND</div>
	 */
	AND,

	/**
	 * <div lang="ja">OR</div>
	 *
	 * <div lang="en">OR</div>
	 */
	OR,

	/**
	 * <div lang="ja">XOR</div>
	 *
	 * <div lang="en">XOR</div>
	 */
	XOR
}
