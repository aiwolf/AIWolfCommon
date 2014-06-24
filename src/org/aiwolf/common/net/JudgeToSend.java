package org.aiwolf.common.net;

import org.aiwolf.common.AIWolfRuntimeException;
import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Judge;
import org.aiwolf.common.data.Species;


/**
 * 投票情報
 * @author tori
 *
 */
public class JudgeToSend{
	
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

	
	String result;
	
	public JudgeToSend(){
		
	}

	public JudgeToSend(Judge judge) {
		this.day = judge.getDay();
		this.agent = judge.getAgent().getAgentIdx();
		this.target = judge.getTarget().getAgentIdx();
		this.result = judge.getResult().toString();
		if(this.result == null){
			throw new AIWolfRuntimeException("judge result = null");
		}
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
	 * @return result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result セットする result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 
	 * @return
	 */
	public Judge toJudge() {
		Judge judge = new Judge(day, Agent.getAgent(getAgent()), Agent.getAgent(getTarget()), Species.valueOf(result));
		return judge;
	}
	
	
	
}
