package org.aiwolf.common.data;

/**
 * <div lang="ja">
 *
 * 投票情報です。<br>
 * いつ(何日に)誰が誰に投票したかを情報として持ちます。
 *
 * </div>
 *
 * <div lang="en">
 *
 * Information of vote.<br>
 * It has information about day, agent,and target.
 *
 * </div>
 *
 * @author tori
 *
 */
public class Vote {

	int day;
	Agent agent;
	Agent target;

	/**
	 * <div lang="ja">投票情報を構築します。</div>
	 *
	 * <div lang="en">Create new vote.</div>
	 *
	 * @param day
	 *            <div lang="ja">投票する日</div>
	 *
	 *            <div lang="en">Day</div>
	 * @param agent
	 *            <div lang="ja">投票するエージェント</div>
	 *
	 *            <div lang="en">Agent</div>
	 * @param target
	 *            <div lang="ja">投票の対象となるエージェント</div>
	 *
	 *            <div lang="en">Target</div>
	 */
	public Vote(int day, Agent agent, Agent target) {
		super();
		this.day = day;
		this.agent = agent;
		this.target = target;
	}

	/**
	 * <div lang="ja">投票する日を返します。</div>
	 *
	 * <div lang="en">Get the day.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">投票する日</div>
	 *
	 *         <div lang="en">Day</div>
	 */
	public int getDay() {
		return day;
	}

	/**
	 * <div lang="ja">投票するエージェントを返します。</div>
	 *
	 * <div lang="en">Get the agent.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">投票するエージェント</div>
	 *
	 *         <div lang="en">Agent</div>
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * <div lang="ja">投票の対象となるエージェントを返します。</div>
	 *
	 * <div lang="en">Get the target.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">投票の対象となるエージェント</div>
	 *
	 *         <div lang="en">Target</div>
	 */
	public Agent getTarget() {
		return target;
	}

	@Override
	public String toString() {
		return agent + "voted" + target + "@" + day;
	}
}
