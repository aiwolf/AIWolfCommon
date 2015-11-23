package org.aiwolf.common.data;

/**
 * <div lang="ja">
 * 
 * 狩人の護衛の情報です。 いつ(何日に)誰が誰を護衛したかを情報として持ちます。
 * 
 * </div>
 * 
 * <div lang="en">
 * 
 * Information of guard by bodyguard.
 * 
 * </div>
 * 
 * @author tori
 *
 */
public class Guard {

	int day;
	Agent agent;
	Agent target;

	/**
	 * <div lang="ja">狩人の護衛情報を構築します。 </div>
	 * 
	 * <div lang="en"> Create new information of guard.</div>
	 * 
	 * @param day
	 *            <div lang="ja">護衛する日</div>
	 * 
	 *            <div lang="en">Day</div>
	 * @param agent
	 *            <div lang="ja">護衛するエージェント</div>
	 * 
	 *            <div lang="en">Agent as bodyguard</div>
	 * @param target
	 *            <div lang="ja">護衛の対象となるエージェント</div>
	 * 
	 *            <div lang="en">Agent of guard target</div>
	 */
	public Guard(int day, Agent agent, Agent target) {
		super();
		this.day = day;
		this.agent = agent;
		this.target = target;
	}

	/**
	 * <div lang="ja">護衛した日を返します。</div>
	 * 
	 * <div lang="en">Get the day.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">護衛する日</div>
	 * 
	 *         <div lang="en">Day</div>
	 */
	public int getDay() {
		return day;
	}

	/**
	 * <div lang="ja">護衛するエージェントを返します。</div>
	 * 
	 * <div lang="en">Get the agent as bodyguard.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">護衛するエージェント</div>
	 * 
	 *         <div lang="en">Agent as bodyguard</div>
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * <div lang="ja">護衛の対象となるエージェントを返します。</div>
	 * 
	 * <div lang="en">Get the agent of guard target.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">護衛の対象となるエージェント</div>
	 * 
	 *         <div lang="en">Agent of guard target</div>
	 * 
	 */
	public Agent getTarget() {
		return target;
	}

	@Override
	public String toString() {
		return agent + "guarded " + target + "@" + day;
	}
}
