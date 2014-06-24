package org.aiwolf.common.data;

/**
 * AI Wolf Talk
 * @author tori
 *
 */
public class Talk{

	/**
	 * index number of sentence
	 */
	int idx;

	/**
	 * told day
	 */
	int day;
	
	/**
	 * agent
	 */
	Agent agent;
	
	/**
	 * 
	 */
	String content;
	

	
	public Talk(int idx, int day, Agent agent, String content) {
		super();
		this.idx = idx;
		this.day = day;
		this.agent = agent;
		this.content = content;
	}
	
	public int getIdx() {
		return idx;
	}

	/**
	 * 
	 * @return
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 
	 * @return
	 */
	public Agent getAgent() {
		return agent;
	}
	
	/**
	 * Werewolf language
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 
	 */
	public String toString(){
		return String.format("Day%02d[%03d]\t%s\t%s", day, idx, agent, content);
	}

	
	final static public String OVER = "Over";

}
