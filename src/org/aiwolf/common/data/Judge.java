package org.aiwolf.common.data;

/**
 * 
 * @author tori
 *
 */
public class Judge {

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
	 */
	Species result;
	
	/**
	 * 
	 * @param day
	 * @param agent
	 * @param target
	 */
	public Judge(int day, Agent agent, Agent target, Species result) {
		super();
		this.day = day;
		this.agent = agent;
		this.target = target;
		this.result = result;
	}

	/**
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return agent
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @return target
	 */
	public Agent getTarget() {
		return target;
	}

	/**
	 * @return result
	 */
	public Species getResult() {
		return result;
	}
	
	public String toString(){
		return agent+"->"+target+"@"+day+":"+result;
	}
	
}
