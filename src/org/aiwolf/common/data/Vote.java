package org.aiwolf.common.data;

/**
 * 投票情報
 * @author tori
 *
 */
public class Vote{
	
	/**
	 * 
	 */
	int day;
	
	/**
	 * 
	 */
	Agent agent;
	
	/**
	 * 
	 */
	Agent target;
	
	/**
	 * 
	 * @param day
	 * @param agent
	 * @param target
	 */
	public Vote(int day, Agent agent, Agent target) {
		super();
		this.day = day;
		this.agent = agent;
		this.target = target;
	}


	public int getDay() {
		return day;
	}


	public Agent getAgent() {
		return agent;
	}


	public Agent getTarget() {
		return target;
	}
	
	public String toString(){
		return agent+" voted "+target+"@"+day;
	}

}
