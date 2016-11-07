package org.aiwolf.common.data;

/**
 * <div lang="ja">人狼知能における会話です。</div>
 *
 * <div lang="en">AI Wolf Talk.</div>
 *
 * @author tori
 *
 */
public class Talk {
	//TODO content => text
	
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
	Agent agent;
	String content;

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
	 * @param agent
	 *            <div lang="ja">話したエージェント</div>
	 *
	 *            <div lang="en">Agent</div>
	 * @param content
	 *            <div lang="ja">話の内容</div>
	 *
	 *            <div lang="en">Content of talk</div>
	 */
	public Talk(int idx, int day, Agent agent, String content) {
		super();
		this.idx = idx;
		this.day = day;
		this.agent = agent;
		this.content = content;
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
	 * <div lang="ja">話の内容を返します。</div>
	 *
	 * <div lang="en">
	 *
	 * Get the content of talk, Werewolf language.
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">話の内容</div>
	 *
	 *         <div lang="en">Content of talk</div>
	 */
	public String getContent() {
		return content;
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
	 * Returns true if content is "SKIP".
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">発言がSKIPならtrue、そうでない場合はfalse</div>
	 *
	 *         <div lang="en">True if content is "SKIP".</div>
	 */
	public boolean isSkip() {
		return content.equals(SKIP);
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
	 * Returns true if content is "OVER".
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
	 *         True if content is "OVER"
	 *
	 *         </div>
	 */
	public boolean isOver() {
		return content.equals(OVER);
	}

	@Override
	public String toString() {
		return String.format("Day%02d[%03d]\t%s\t%s", day, idx, agent, content);
	}

}
