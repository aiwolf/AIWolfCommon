package org.aiwolf.common.net;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Judge;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Status;
import org.aiwolf.common.data.Talk;
import org.aiwolf.common.data.Vote;



/**
 * Game information which send to each player
 * 
 * @author tori
 */
public class GameInfo {

	int day;
	Agent agent;
	// Role role;

	Judge mediumResult;
	Judge divineResult;
	Agent executedAgent;
	Agent attackedAgent;
	List<Vote> voteList;
	List<Vote> attackVoteList;

	List<Talk> talkList;
	List<Talk> whisperList;

	// List<Agent> wolfList;
	// List<Agent> humanList;
	// List<Agent> aliveAgentList;

	Map<Agent, Status> statusMap;
	Map<Agent, Role> roleMap;

	// List<Agent> agentList;

	public GameInfo() {
		voteList = new ArrayList<Vote>();
		attackVoteList = new ArrayList<Vote>();
		talkList = new ArrayList<Talk>();
		whisperList = new ArrayList<Talk>();
		statusMap = new HashMap<Agent, Status>();
		roleMap = new HashMap<Agent, Role>();
		// agentList = new ArrayList<>();

	}


	/**
	 * get the day
	 * @return
	 */
	public int getDay() {
		return day;
	}

	/**
	 * get player's role
	 * @return
	 */
	public Role getRole() {
		return roleMap.get(getAgent());
	}

	/**
	 * get yourself
	 * @return
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * get agents
	 * @return
	 */
	public List<Agent> getAgentList() {
		return new ArrayList<Agent>(statusMap.keySet());
	}

	/**
	 * Result of medium. medium only
	 * @return
	 */
	public Judge getMediumResult() {
		return mediumResult;
	}

	/**
	 * Result of the dvine. seer only
	 * @return
	 */
	public Judge getDivineResult() {
		return divineResult;
	}

	/**
	 * agent who executed last night
	 * @return
	 */
	public Agent getExecutedAgent() {
		return executedAgent;
	}

	/**
	 * agent who attacked last night
	 * @return
	 */
	public Agent getAttackedAgent() {
		return attackedAgent;
	}

	/**
	 * Vote list. You can find who vote to who
	 * @return
	 */
	public List<Vote> getVoteList() {
		return voteList;
	}

	/**
	 * Attack vote list. werewolf only
	 * @return
	 */
	public List<Vote> getAttackVoteList() {
		return attackVoteList;
	}

	/**
	 * Today's talks
	 * @return
	 */
	public List<Talk> getTalkList() {
		return talkList;
	}

	/**
	 * today's whispers. werewolf only
	 * @return
	 */
	public List<Talk> getWhisperList() {
		return whisperList;
	}

	/**
	 * Human agents. werewolf only.<br>
	 * returns all agents if you are human
	 * @return
	 */
//	public List<Agent> getHumanList() {
//		List<Agent> humanList = new ArrayList<Agent>(getAgentList());
//		humanList.removeAll(getWolfList());
//		return humanList;
//	}

	/**
	 * Werewolves. werewolf only.<br>
	 * returns empty list if you are human
	 * @return
	 */
//	public List<Agent> getWolfList() {
//		List<Agent> wolfList = new ArrayList<Agent>();
//		for (Agent agent : roleMap.keySet()) {
//			if (roleMap.get(agent) == Role.werewolf) {
//				wolfList.add(agent);
//			}
//		}
//		return wolfList;
//	}

	/**
	 * Agents who are aliving now
	 * @return
	 */
	public List<Agent> getAliveAgentList() {
		List<Agent> aliveAgentList = new ArrayList<Agent>();
		if (getAgentList() != null) {
			for (Agent target : getAgentList()) {
				if (statusMap.get(target) == Status.ALIVE) {
					aliveAgentList.add(target);
				}
			}
		}
		return aliveAgentList;
	}

	/**
	 * statuses of all agents
	 * @return
	 */
	public Map<Agent, Status> getStatusMap() {
		return statusMap;
	}

	/**
	 * Known roles of agents.<br>
	 * if you are human, you know only yourself.<br>
	 * if you are werewolf, you know other werewolves.
	 * @return
	 */
	public Map<Agent, Role> getRoleMap() {
		return roleMap;
	}

}
