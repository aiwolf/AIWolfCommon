package org.aiwolf.common.data;

/**
 * <div lang="ja">
 * 
 * 占い師の占い結果や霊媒師の霊媒結果の情報です。 いつ(何日に)誰が誰を占い(霊媒し)、その結果が何の種族だったかを情報として持ちます。
 * 
 * </div>
 * 
 * <div lang="en">
 * 
 * Information of divine by seer. Also, information of medium result.
 * 
 * </div>
 * 
 * @author tori
 *
 */
public class Judge {

	int day;
	Agent agent;
	Agent target;
	Species result;

	/**
	 * <div lang="ja"> 占い結果もしくは霊媒結果を構築します。 </div>
	 * 
	 * <div lang="en">Create new information of judge. </div>
	 * 
	 * @param day
	 *            <div lang="ja">占いもしくは霊媒をする日</div>
	 * 
	 *            <div lang="en">Day</div>
	 * @param agent
	 *            <div lang="ja">占いもしくは霊媒をするエージェント</div>
	 * 
	 *            <div lang="en">Agent as seer or medium</div>
	 * @param target
	 *            <div lang="ja">占いもしくは霊媒の対象となるエージェント</div>
	 * 
	 *            <div lang="en">Agent of judge target</div>
	 * @param result
	 *            <div lang="ja">占いもしくは霊媒の結果</div>
	 * 
	 *            <div lang="en">Result of divine or medium</div>
	 */
	public Judge(int day, Agent agent, Agent target, Species result) {
		super();
		this.day = day;
		this.agent = agent;
		this.target = target;
		this.result = result;
	}

	/**
	 * <div lang="ja">占いもしくは霊媒をする日を返します。</div>
	 * 
	 * <div lang="en">Get the day.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">占いもしくは霊媒をする日</div>
	 * 
	 *         <div lang="en">Day</div>
	 */
	public int getDay() {
		return day;
	}

	/**
	 * <div lang="ja">占いもしくは霊媒をするエージェントを返します。</div>
	 * 
	 * <div lang="en">Get the agent as seer or medium.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">占いもしくは霊媒をするエージェント</div>
	 * 
	 *         <div lang="en">Agent as seer or medium</div>
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * <div lang="ja">占いもしくは霊媒の対象となるエージェントを返します。</div>
	 * 
	 * <div lang="en">Get the agent of judge target.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">占いもしくは霊媒の対象となるエージェント</div>
	 * 
	 *         <div lang="en">Agent of judge target</div>
	 */
	public Agent getTarget() {
		return target;
	}

	/**
	 * <div lang="ja">占いもしくは霊媒の結果を返します。</div>
	 * 
	 * <div lang="en">Get the result of divine or medium.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">占いもしくは霊媒の結果</div>
	 * 
	 *         <div lang="en">Result of divine or medium</div>
	 */
	public Species getResult() {
		return result;
	}

	@Override
	public String toString() {
		return agent + "->" + target + "@" + day + ":" + result;
	}
}
