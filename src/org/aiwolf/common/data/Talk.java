/**
 * Talk.java
 * 
 * Copyright (c) 2014 人狼知能プロジェクト
 */
package org.aiwolf.common.data;

/**
 * <div lang="ja">人狼知能における会話です。</div>
 *
 * <div lang="en">AI Wolf Talk.</div>
 *
 * @author tori and otsuki
 *
 */
public class Talk {

	/**
	 * <div lang="ja">
	 *
	 * OVERは「今日はもう話すことはない」を意味します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * OVER means "Today, I don't speak".
	 *
	 * </div>
	 */
	final static public String OVER = "Over";
	/**
	 * <div lang="ja">
	 *
	 * SKIPは「もう少し周りの様子を見たい」を意味します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * SKIP means "I still want to hear the conversation".
	 *
	 * </div>
	 */
	final static public String SKIP = "Skip";

	int idx;
	int day;
	int turn;
	Agent agent;
	String text;

	/**
	 * <div lang="ja">会話を構築します。</div>
	 *
	 * <div lang="en">Create new talk.</div>
	 *
	 * @param idx
	 *            <div lang="ja">発言のインデックス番号</div>
	 *
	 *            <div lang="en">Index number of sentence</div>
	 * @param day
	 *            <div lang="ja">話した日</div>
	 *
	 *            <div lang="en">Tald day</div>
	 * @param turn
	 *            <div lang="ja">発言のターン</div>
	 *
	 *            <div lang="en">Turn of talk</div>
	 * @param agent
	 *            <div lang="ja">話したエージェント</div>
	 *
	 *            <div lang="en">Agent</div>
	 * @param text
	 *            <div lang="ja">発話内容テキスト</div>
	 *
	 *            <div lang="en">Uttered text of talk</div>
	 */
	public Talk(int idx, int day, int turn, Agent agent, String text) {
		super();
		this.idx = idx;
		this.day = day;
		this.turn = turn;
		this.agent = agent;
		this.text = text;
	}

	/**
	 * <div lang="ja">発言のインデックス番号を返します。</div>
	 *
	 * <div lang="en">Get the index number of sentence.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">発言のインデックス番号</div>
	 *
	 *         <div lang="en">Index number of sentence</div>
	 */
	public int getIdx() {
		return idx;
	}

	/**
	 * <div lang="ja">話した日を返します。</div>
	 *
	 * <div lang="en">Get the told day.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">話した日</div>
	 *
	 *         <div lang="en">Tald day</div>
	 */
	public int getDay() {
		return day;
	}

	/**
	 * <div lang="ja">話した時間を返します。</div>
	 *
	 * <div lang="en">Get the told time.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">話した時間</div>
	 *
	 *         <div lang="en">Tald time</div>
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * <div lang="ja">話したエージェントを返します。</div>
	 *
	 * <div lang="en">Get the agent.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">話したエージェント</div>
	 *
	 *         <div lang="en">Agent</div>
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * <div lang="ja">発話内容テキストを返します。</div>
	 *
	 * <div lang="en">
	 *
	 * Get the uttered text of talk.
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">発話内容テキスト</div>
	 *
	 *         <div lang="en">Uttered text of talk</div>
	 */
	public String getText() {
		return text;
	}

	/**
	 * <div lang="ja">
	 *
	 * 発言がSKIPならtrue、そうでない場合はfalseを返します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Returns true if utterance is "SKIP".
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">発言がSKIPならtrue、そうでない場合はfalse</div>
	 *
	 *         <div lang="en">True if utterance is "SKIP".</div>
	 */
	public boolean isSkip() {
		return text.equals(SKIP);
	}

	/**
	 * <div lang="ja">
	 *
	 * 発言がOVERならtrue、そうでない場合はfalseを返します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Returns true if utterance is "OVER".
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">
	 *
	 *         発言がOVERならtrue、そうでない場合はfalse
	 *
	 *         </div>
	 *
	 *         <div lang="en">
	 *
	 *         True if utterance is "OVER"
	 *
	 *         </div>
	 */
	public boolean isOver() {
		return text.equals(OVER);
	}

	@Override
	public String toString() {
		return String.format("Day%02d %02d[%03d]\t%s\t%s", day, turn, idx, agent, text);
	}

}
