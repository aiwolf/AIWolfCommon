package org.aiwolf.common.net;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Vote;


/**
 * 投票情報
 * @author tori
 *
 */
public class VoteToSend{
	
	/**
	 * 
	 */
	int day;
	
	/**
	 * 
	 */
	int agent;
	
	/**
	 * 
	 */
	int target;

	public VoteToSend(){
		
	}

	public VoteToSend(Vote vote) {
		this.day = vote.getDay();
		this.agent = vote.getAgent().getAgentIdx();
		this.target = vote.getTarget().getAgentIdx();
	}

	/**
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day セットする day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return agent
	 */
	public int getAgent() {
		return agent;
	}

	/**
	 * @param agent セットする agent
	 */
	public void setAgent(int agent) {
		this.agent = agent;
	}

	/**
	 * @return target
	 */
	public int getTarget() {
		return target;
	}

	/**
	 * @param target セットする target
	 */
	public void setTarget(int target) {
		this.target = target;
	}

	/**
	 * 
	 * @return
	 */
	public Vote toVote() {
		Vote vote = new Vote(day, Agent.getAgent(getAgent()), Agent.getAgent(getTarget()));
		return vote;
	}
	
	
	
}
