package org.aiwolf.common.data;

/**
 * Divine
 * @author tori
 *
 */
public class Guard {

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
	public Guard(int day, Agent agent, Agent target) {
		super();
		this.day = day;
		this.agent = agent;
		this.target = target;
		
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

	public String toString(){
		return agent+" guarded "+target+"@"+day;
	}
	
}
