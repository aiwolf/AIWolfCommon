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
	 * 
	 */
	int turn;
	/**
	 * agent
	 */
	int agent;
	
	/**
	 * 
	 */
	String text;
	
	public TalkToSend(){
		
	}
	
	public TalkToSend(Talk talk){
		this.idx = talk.getIdx();
		this.day = talk.getDay();
		this.turn = talk.getTurn();
		this.agent = talk.getAgent().getAgentIdx();
		this.text = talk.getText();
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
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            セットする text
	 */
	public void setText(String text) {
		this.text = text;
	}

	public Talk toTalk() {
		return new Talk(idx, day, turn, Agent.getAgent(agent), text);
	}

	/**
	 * @return time
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * @param time セットする time
	 */
	public void setTurn(int time) {
		this.turn = time;
	}
	
}
