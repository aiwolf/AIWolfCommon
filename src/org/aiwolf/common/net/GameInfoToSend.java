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
	int attackedDead = -1;
	int cursedFox = -1;
	int guardedAgent = -1;
	List<VoteToSend> voteList;
	List<VoteToSend> attackVoteList;
	
	List<TalkToSend> talkList;
	List<TalkToSend> whisperList;

	LinkedHashMap<Integer, String> statusMap;
	LinkedHashMap<Integer, String> roleMap;
	LinkedHashMap<Integer, Integer> remainTalkMap;
	LinkedHashMap<Integer, Integer> remainWhisperMap;
//	List<Integer> agentList;

	List<Integer> lastDeadAgentList; // The list of agents died last night.
	List<String> existingRoleList;
	
	public GameInfoToSend() {
		voteList = new ArrayList<VoteToSend>();
		attackVoteList = new ArrayList<VoteToSend>();
		statusMap = new LinkedHashMap<Integer, String>();
		roleMap = new LinkedHashMap<Integer, String>();
		remainTalkMap = new LinkedHashMap<>();
		remainWhisperMap = new LinkedHashMap<>();
		talkList = new ArrayList<TalkToSend>();
		whisperList = new ArrayList<TalkToSend>();
		lastDeadAgentList = new ArrayList<>();
		existingRoleList = new ArrayList<>();
		
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
	 * <div lang="ja">昨夜追放されたエージェントを返す</div> <div lant="en">Returns the agent
	 * executed last night.</div>
	 * 
	 * @return <div lang="ja">昨夜追放されたエージェント</div> <div lant="en">the agent
	 *         executed last night.</div>
	 */
	public int getExecutedAgent() {
		return executedAgent;
	}

	/**
	 * <div lang="ja">昨夜追放されたエージェントをセットする</div>
	 * 
	 * <div lant="en">Sets the agent executed last night.</div>
	 * 
	 * @param executedAgent
	 *            - <div lang="ja">セットするエージェント</div>
	 * 
	 *            <div lang="en">the agent to set"</div>
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
	 * @return remainTalkMap
	 */
	public Map<Integer, Integer> getRemainTalkMap() {
		return remainTalkMap;
	}


	/**
	 * @param remainTalkMap セットする remainTalkMap
	 */
	public void setRemainTalkMap(LinkedHashMap<Integer, Integer> remainTalkMap) {
		this.remainTalkMap = remainTalkMap;
	}


	/**
	 * @return remainWhisperMap
	 */
	public LinkedHashMap<Integer, Integer> getRemainWhisperMap() {
		return remainWhisperMap;
	}

	/**
	 * @param remainWhisperMap セットする remainWhisperMap
	 */
	public void setRemainWhisperMap(LinkedHashMap<Integer, Integer> remainWhisperMap) {
		this.remainWhisperMap = remainWhisperMap;
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


	/**
	 * @return existingRoleList
	 */
	public List<String> getExistingRoleList() {
		return existingRoleList;
	}

	/**
	 * @param existingRoleList セットする existingRoleList
	 */
	public void setExistingRoleList(List<String> existingRoleList) {
		this.existingRoleList = existingRoleList;
	}
	

	/**
	 * <div lang="ja">昨夜人狼に襲われ死亡したエージェントを返す．</div>
	 * 
	 * <div lang="en">Returns the agent who died last night because of the attack by werewolf.</div>
	 * 
	 * @return the attackedDead
	 */
	public int getAttackedDead() {
		return attackedDead;
	}

	/**
	 * <div lang="ja">昨夜人狼に襲われ死亡したエージェントをセットする．</div>
	 * 
	 * <div lang="en">Sets the agent who died last night because of the attack by werewolf.</div>
	 * 
	 * @param attackedDead
	 *            the attackedDead to set
	 */
	public void setAttackedDead(int attackedDead) {
		this.attackedDead = attackedDead;
	}

	/**
	 * <div lang="ja">呪殺された妖狐を返す．</div>
	 * 
	 * <div lang="en">Returns the fox killed by curse.</div>
	 * 
	 * @return <div lang="ja">呪殺された妖狐</div>
	 * 
	 *         <div lang="en">the fox killed by curse</div>
	 */
	public int getCursedFox() {
		return cursedFox;
	}

	/**
	 * <div lang="ja">呪殺された妖狐をセットする．</div>
	 * 
	 * <div lang="en">Sets the fox killed by curse.</div>
	 * 
	 * @param cursedFox
	 *            <div lang="ja">呪殺された妖狐</div>
	 * 
	 *            <div lang="en">the fox killed by curse</div>
	 */
	public void setCursedFox(int cursedFox) {
		this.cursedFox = cursedFox;
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
		gi.attackedDead = Agent.getAgent(this.getAttackedDead());
		gi.cursedFox = Agent.getAgent(this.getCursedFox());
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
		gi.remainTalkMap = new HashMap<Agent, Integer>();
		for(int agent:this.getRemainTalkMap().keySet()){
			gi.remainTalkMap.put(Agent.getAgent(agent), getRemainTalkMap().get(agent));
		}
		gi.remainWhisperMap = new HashMap<Agent, Integer>();
		for(int agent:this.getRemainWhisperMap().keySet()){
			gi.remainWhisperMap.put(Agent.getAgent(agent), getRemainWhisperMap().get(agent));
		}
		
		gi.existingRoleList = new ArrayList<>();
		for(String roleText:this.getExistingRoleList()){
			gi.existingRoleList.add(Role.valueOf(roleText));
		}
		
		return gi;
	}

	
}
