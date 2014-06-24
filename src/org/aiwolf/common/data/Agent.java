package org.aiwolf.common.data;

import java.util.HashMap;

import java.util.Map;


/**
 * Player Agent 
 * @author tori
 *
 */
public class Agent implements Comparable<Agent>{

	private static Map<Integer, Agent> agentIndexMap = new HashMap<Integer, Agent>();
	
	/**
	 * get agent of index
	 * @param idx
	 * @return
	 */
	static public Agent getAgent(int idx){
		if(idx < 0){
			return null;
		}
		if(!agentIndexMap.containsKey(idx)){
			Agent agent = new Agent(idx);
			agentIndexMap.put(idx, agent);
		}
		return agentIndexMap.get(idx);
	}
	
	
	int agentIdx;
	
	/**
	 * 
	 * @param agentIdx
	 */
//	public Agent(){
//	}

	/**
	 * 
	 * @param idx
	 */
	private Agent(int idx){
		this.agentIdx = idx;
	}

	/* (非 Javadoc)
	 * @see org.aiwolf.server.core.Agent#getIdx()
	 */
	public int getAgentIdx() {
		return agentIdx;
	}

	/* (非 Javadoc)
	 * @see org.aiwolf.server.core.Agent#toString()
	 */
	@Override
	public String toString(){
//		return String.format("{\"agentIdx\":%02d}", agentIdx);
		return String.format("Agent[%02d]", agentIdx);
	}

	/* (非 Javadoc)
	 * @see org.aiwolf.server.core.Agent#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agentIdx;
		return result;
	}

	/* (非 Javadoc)
	 * @see org.aiwolf.server.core.Agent#equals(java.lang.Object)
	 */
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

	/**
	 * @param idx セットする idx
	 */
	public void setAgentIdx(int idx) {
		this.agentIdx = idx;
	}

	@Override
	public int compareTo(Agent target) {
		if(target == null){
			return 1;
		}
		return getAgentIdx()-target.getAgentIdx();
	}
	
}
