package org.aiwolf.common.data;

import java.util.HashMap;
import java.util.Map;

/**
 * <div lang="ja">
 * 
 * プレイヤーのエージェントです。 各プレイヤーは、エージェントとして他のプレイヤーを識別することができます。
 * 各エージェントは、一意のインデックスを持っています。
 * 
 * </div>
 * 
 * <div lang="en">
 * 
 * Player Agent. Each players can identify other players as Agent. Each agent
 * has unique index.
 * 
 * </div>
 * 
 * @author tori
 *
 */
final public class Agent implements Comparable<Agent> {

	private static Map<Integer, Agent> agentIndexMap = new HashMap<>();

	/**
	 * <div lang="ja">指定されたインデックスのエージェントを取得します。</div>
	 * 
	 * <div lang="en">Get agent of idx</div>
	 * 
	 * @param idx
	 *            <div lang="ja">エージェントのインデックス</div>
	 * 
	 *            <div lang="en">agent's idx</div>
	 * @return
	 * 
	 * 		<div lang="ja">エージェント</div>
	 *
	 *         <div lang="en">Agent</div>
	 */
	static public Agent getAgent(int idx) {
		if (idx < 0) {
			return null;
		}
		if (!agentIndexMap.containsKey(idx)) {
			Agent agent = new Agent(idx);
			agentIndexMap.put(idx, agent);
		}
		return agentIndexMap.get(idx);
	}

	int agentIdx;

	// TODO コメントアウトされたコンストラクター
	/**
	 * 
	 * @param agentIdx
	 */
	// public Agent(){
	// }

	/**
	 * <div lang="ja">新しいエージェントを構築します。</div>
	 * 
	 * <div lang="en">Create new agent.</div>
	 * 
	 * @param idx
	 *            <div lang="ja">エージェントのインデックス</div>
	 * 
	 *            <div lang="en">Agent's index</div>
	 */
	private Agent(int idx) {
		this.agentIdx = idx;
	}

	/**
	 * <div lang="ja">エージェントのインデックスを返します。</div>
	 * 
	 * <div lang="en">Get agent's index.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">エージェントのインデックス</div>
	 * 
	 *         <div lang="en">Agent's index</div>
	 */
	public int getAgentIdx() {
		return agentIdx;
	}

	@Override
	public String toString() {
		// TODO コメントアウトされた行
		// return String.format("{\"agentIdx\":%02d}", agentIdx);
		return String.format("Agent[%02d]", agentIdx);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agentIdx;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		if (agentIdx != other.agentIdx)
			return false;
		return true;
	}

	@Override
	public int compareTo(Agent target) {
		if (target == null) {
			return 1;
		}
		return getAgentIdx() - target.getAgentIdx();
	}

}
