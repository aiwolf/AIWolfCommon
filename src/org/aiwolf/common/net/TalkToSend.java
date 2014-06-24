package org.aiwolf.common.net;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Talk;


/**
 * AI Wolf Talk
 * @author tori
 *
 */
public class TalkToSend {

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
	int agent;
	
	/**
	 * 
	 */
	String content;
	
	public TalkToSend(){
		
	}
	
	public TalkToSend(Talk talk){
		this.idx = talk.getIdx();
		this.day = talk.getDay();
		this.agent = talk.getAgent().getAgentIdx();
		this.content = talk.getContent();
	}

	/**
	 * @return idx
	 */
	public int getIdx() {
		return idx;
	}

	/**
	 * @param idx セットする idx
	 */
	public void setIdx(int idx) {
		this.idx = idx;
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
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content セットする content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public Talk toTalk() {
		return new Talk(idx, day, Agent.getAgent(agent), content);
	}
	
	
	
	
}
