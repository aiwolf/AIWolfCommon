package org.aiwolf.common.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Status;
import org.aiwolf.common.data.Talk;
import org.aiwolf.common.data.Vote;


/**
 * Game information which send to each player
 * @author tori
 */
public class GameInfoToSend{
	
	int day;
	int agent;
//	String role;
	
	JudgeToSend mediumResult;
	JudgeToSend divineResult;
	int executedAgent = -1;
	int attackedAgent = -1;
	int guardedAgent = -1;
	List<VoteToSend> voteList;
	List<VoteToSend> attackVoteList;
	
	List<TalkToSend> talkList;
	List<TalkToSend> whisperList;

	LinkedHashMap<Integer, String> statusMap;
	LinkedHashMap<Integer, String> roleMap;
//	List<Integer> agentList;

	List<Integer> lastDeadAgentList; // The list of agents died last night.

	public GameInfoToSend() {
		voteList = new ArrayList<VoteToSend>();
		attackVoteList = new ArrayList<VoteToSend>();
		statusMap = new LinkedHashMap<Integer, String>();
		roleMap = new LinkedHashMap<Integer, String>();
		talkList = new ArrayList<TalkToSend>();
		whisperList = new ArrayList<TalkToSend>();
		lastDeadAgentList = new ArrayList<>();
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

//	/**
//	 * @return role
//	 */
//	public String getRole() {
//		return role;
//	}
//
//	/**
//	 * @param role セットする role
//	 */
//	public void setRole(String role) {
//		this.role = role;
//	}

	/**
	 * @return mediumResult
	 */
	public JudgeToSend getMediumResult() {
		return mediumResult;
	}

	/**
	 * @param mediumResult セットする mediumResult
	 */
	public void setMediumResult(JudgeToSend mediumResult) {
		this.mediumResult = mediumResult;
	}

	/**
	 * @return divineResult
	 */
	public JudgeToSend getDivineResult() {
		return divineResult;
	}

	/**
	 * @param divineResult セットする divineResult
	 */
	public void setDivineResult(JudgeToSend divineResult) {
		this.divineResult = divineResult;
	}

	/**
	 * @return executedAgent
	 */
	public int getExecutedAgent() {
		return executedAgent;
	}

	/**
	 * @param executedAgent セットする executedAgent
	 */
	public void setExecutedAgent(int executedAgent) {
		this.executedAgent = executedAgent;
	}

	/**
	 * @return attackedAgent
	 */
	public int getAttackedAgent() {
		return attackedAgent;
	}

	/**
	 * @param attackedAgent セットする attackedAgent
	 */
	public void setAttackedAgent(int attackedAgent) {
		this.attackedAgent = attackedAgent;
	}

	
	
	/**
	 * @return guardedAgent
	 */
	public int getGuardedAgent() {
		return guardedAgent;
	}

	/**
	 * @param guardedAgent セットする guardedAgent
	 */
	public void setGuardedAgent(int guardedAgent) {
		this.guardedAgent = guardedAgent;
	}

	/**
	 * @return voteList
	 */
	public List<VoteToSend> getVoteList() {
		return voteList;
	}

	/**
	 * @param voteList セットする voteList
	 */
	public void setVoteList(List<VoteToSend> voteList) {
		this.voteList = voteList;
	}

	/**
	 * @return attackVoteList
	 */
	public List<VoteToSend> getAttackVoteList() {
		return attackVoteList;
	}

	/**
	 * @param attackVoteList セットする attackVoteList
	 */
	public void setAttackVoteList(List<VoteToSend> attackVoteList) {
		this.attackVoteList = attackVoteList;
	}

	/**
	 * @return talkList
	 */
	public List<TalkToSend> getTalkList() {
		return talkList;
	}

	/**
	 * @param talkList セットする talkList
	 */
	public void setTalkList(List<TalkToSend> talkList) {
		this.talkList = talkList;
	}

	/**
	 * @return whisperList
	 */
	public List<TalkToSend> getWhisperList() {
		return whisperList;
	}

	/**
	 * @param whisperList セットする whisperList
	 */
	public void setWhisperList(List<TalkToSend> whisperList) {
		this.whisperList = whisperList;
	}

	/**
	 * @return statusMap
	 */
	public Map<Integer, String> getStatusMap() {
		return statusMap;
	}

	/**
	 * @param statusMap セットする statusMap
	 */
	public void setStatusMap(LinkedHashMap<Integer, String> statusMap) {
		this.statusMap = statusMap;
	}

	/**
	 * @return roleMap
	 */
	public Map<Integer, String> getRoleMap() {
		return roleMap;
	}

	/**
	 * @param roleMap セットする roleMap
	 */
	public void setRoleMap(LinkedHashMap<Integer, String> roleMap) {
		this.roleMap = roleMap;
	}

	/**
	 * @return the lastDeadAgentList
	 */
	public List<Integer> getLastDeadAgentList() {
		return lastDeadAgentList;
	}

	/**
	 * @param lastDeadAgentList - the lastDeadAgentList to set
	 */
	public void setLastDeadAgentList(List<Integer> lastDeadAgentList) {
		this.lastDeadAgentList = lastDeadAgentList;
	}

	public GameInfo toGameInfo() {
		GameInfo gi = new GameInfo();
		gi.day = this.getDay();
		gi.agent = Agent.getAgent(this.getAgent());
		
		if(this.getMediumResult() != null){
			gi.mediumResult = this.getMediumResult().toJudge();
		}
		if(this.getDivineResult() != null){
			gi.divineResult = this.getDivineResult().toJudge();
		}
		gi.executedAgent = Agent.getAgent(this.getExecutedAgent());
		gi.attackedAgent = Agent.getAgent(this.getAttackedAgent());
		gi.guardedAgent = Agent.getAgent(this.getGuardedAgent());

		gi.voteList = new ArrayList<Vote>();
		for(VoteToSend vote:this.getVoteList()){
			gi.voteList.add(vote.toVote());
		}
		gi.attackVoteList = new ArrayList<Vote>();
		for(VoteToSend vote:this.getAttackVoteList()){
			gi.attackVoteList.add(vote.toVote());
		}
		
		gi.talkList = new ArrayList<Talk>();
		for(TalkToSend talk:this.getTalkList()){
			gi.talkList.add(talk.toTalk());
		}
		gi.whisperList = new ArrayList<Talk>();
		for(TalkToSend whisper:this.getWhisperList()){
			gi.whisperList.add(whisper.toTalk());
		}

		gi.lastDeadAgentList = new ArrayList<>();
		for (int agent : lastDeadAgentList) {
			gi.lastDeadAgentList.add(Agent.getAgent(agent));
		}

		gi.statusMap = new HashMap<Agent, Status>();
		for(int agent:this.getStatusMap().keySet()){
			gi.statusMap.put(Agent.getAgent(agent), Status.valueOf(getStatusMap().get(agent)));
		}
		gi.roleMap = new HashMap<Agent, Role>();
		for(int agent:this.getRoleMap().keySet()){
			gi.roleMap.put(Agent.getAgent(agent), Role.valueOf(getRoleMap().get(agent)));
		}
		
		return gi;
	}
	
}
