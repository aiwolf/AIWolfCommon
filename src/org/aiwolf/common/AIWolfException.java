package org.aiwolf.common;

/**
 * <div lang="ja">人狼知能における例外を扱うクラスです。</div>
 *
 * <div lang="en">AI wolf game's exception.</div>
 */
public class AIWolfException extends Exception {

	private static final long serialVersionUID = -7643834149475507516L;

	/**
	 * <div lang="ja">人狼知能に関する新規例外を構築します。</div>
	 *
	 * <div lang="en">Constructs a new AI wolf game's exception.</div>
	 */
	public AIWolfException() {
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定された詳細メッセージを持つ、人狼知能に関する新規例外を構築します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Constructs a new AI wolf game's exception with the specified detail
	 * message.
	 *
	 * </div>
	 *
	 * @param message
	 *
	 *            <div lang="ja">詳細メッセージ</div>
	 *
	 *            <div lang="en">Detail message</div>
	 */
	public AIWolfException(String message) {
		super(message);
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定された詳細メッセージおよび原因を使用して
	 *
	 * 新規例外を構築します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Constructs a new AI wolf game's exception
	 *
	 * with the specified detail message and cause.
	 *
	 * </div>
	 *
	 * @param message
	 *            <div lang="ja">詳細メッセージ</div>
	 *
	 *            <div lang="en">Detail message</div>
	 * @param cause
	 *            <div lang="ja">原因</div>
	 *
	 *            <div lang="en">Cause</div>
	 */
	public AIWolfException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定された詳細メッセージ、原因、抑制の有効化または
	 *
	 * 無効化、書込み可能スタック・トレースの有効化または
	 *
	 * 無効化に基づいて、新しい例外を構築します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Constructs a new AI wolf game's exception with the specified
	 *
	 * detail message, cause, suppression enabled or disabled,
	 *
	 * and writable stack trace enabled or disabled.
	 *
	 * </div>
	 *
	 * @param message
	 *            <div lang="ja">詳細メッセージ</div>
	 *
	 *            <div lang="en">Detail message</div>
	 * @param cause
	 *            <div lang="ja">原因</div>
	 *
	 *            <div lang="en">Cause</div>
	 * @param enableSuppression
	 *            <div lang="ja">抑制の有効化または無効化</div>
	 *
	 *            <div lang="en">
	 *
	 *            Whether or not suppression is enabled or disabled
	 *
	 *            </div>
	 * @param writableStackTrace
	 *            <div lang="ja">書込み可能スタック・トレースの有効化または 無効化</div>
	 *
	 *            <div lang="en">
	 *
	 *            Whether or not the stack trace should be writable
	 *
	 *            </div>
	 */
	public AIWolfException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定された原因と詳細メッセージ
	 *
	 * {@code (cause==null ? null : cause.toString())}
	 *
	 * を持つ新しい例外を構築します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Constructs a new AI wolf game's exception
	 *
	 * with the specified cause and a detail message of
	 *
	 * {@code (cause==null ? null : cause.toString())}.
	 *
	 * </div>
	 *
	 * @param cause
	 *            <div lang="ja">原因</div>
	 *
	 *            <div lang="en">Cause</div>
	 */
	public AIWolfException(Throwable cause) {
		super(cause);
	}
}
