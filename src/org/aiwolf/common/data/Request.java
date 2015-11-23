package org.aiwolf.common.data;

// TODO JavaDocを付ける。どう書いたらいいかわからないため説明が書けない。
/**
 * <div lang="ja">
 * 
 * <!--説明をここに加えてください-->
 * 
 * </div>
 * 
 * <div lang="en">
 * 
 * <!--Insert English Document-->
 * 
 * </div>
 * 
 * @author tori
 *
 */
public enum Request {
	/**
	 * <div lang="ja">名前のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request name.</div>
	 */
	NAME(true),
	/**
	 * <div lang="ja">役割のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request role.</div>
	 */
	ROLE(true),
	/**
	 * <div lang="ja">会話のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request talk.</div>
	 */
	TALK(true),
	/**
	 * <div lang="ja">ささやきのリクエストを表します。</div>
	 * 
	 * <div lang="en">The request whisper.</div>
	 */
	WHISPER(true),
	/**
	 * <div lang="ja">投票のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request vote.</div>
	 */
	VOTE(true),
	/**
	 * <div lang="ja">占いのリクエストを表します。</div>
	 * 
	 * <div lang="en">The request divine.</div>
	 */
	DIVINE(true),
	/**
	 * <div lang="ja">護衛のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request guard.</div>
	 */
	GUARD(true),
	/**
	 * <div lang="ja">襲撃のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request attack.</div>
	 */
	ATTACK(true),
	/**
	 * <div lang="ja">初期化のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request initialize.</div>
	 */
	INITIALIZE(false),
	/**
	 * <div lang="ja">各日の初期化のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request daily initialize.</div>
	 */
	DAILY_INITIALIZE(false),
	/**
	 * <div lang="ja">各日の終了のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request daily finish.</div>
	 */
	DAILY_FINISH(false),
	// TODO コメントアウトされた列挙
	// UPDATE(false),
	/**
	 * <div lang="ja">終了のリクエストを表します。</div>
	 * 
	 * <div lang="en">The request finish.</div>
	 */
	FINISH(false);

	boolean hasReturn;

	private Request(boolean hasReturn) {
		this.hasReturn = hasReturn;
	}

	public boolean hasReturn() {
		return hasReturn;
	}
}
