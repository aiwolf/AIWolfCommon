package org.aiwolf.common.net;

import java.util.HashMap;
import java.util.Map;

import org.aiwolf.common.data.Role;

/**
 * Settings of game<br>
 * 
 * @author tori
 *
 */
public class GameSetting{

	/**
	 * Num of each roles.
	 * Bodyguard, FreeMason, Medium, Possessed, seer, villager, werewolf
	 */
	static private int[][] roleNumArray = {
		{},//0
		{},//1
		{},//2
		{},//3
		{0, 0, 0, 0, 1, 2, 1},//4
		{0, 0, 0, 1, 1, 2, 1},//5
		{0, 0, 0, 1, 1, 3, 1},//6
		{0, 0, 0, 0, 1, 4, 2}, //7
		{0, 0, 1, 0, 1, 4, 2}, //8
		{0, 0, 1, 0, 1, 5, 2}, //9
		{1, 0, 1, 1, 1, 4, 2}, //10
		{1, 0, 1, 1, 1, 5, 2}, //11
		{1, 0, 1, 1, 1, 5, 3}, //12
		{1, 0, 1, 1, 1, 6, 3}, //13
		{1, 0, 1, 1, 1, 7, 3}, //14
		{1, 0, 1, 1, 1, 8, 3}, //15
		{1, 0, 1, 1, 1, 9, 3}, //16
		{1, 0, 1, 1, 1, 10, 3}, //17
		{1, 0, 1, 1, 1, 11, 3}, //18
	};
	
	/**
	 * セミナー用セット．<br>
	 * 村人8， 人狼3， 占い，狩人
	 */
	static private int[] seminarArray = {
		1, 0, 0, 0, 1, 8, 3 //13
	};
	
	static public GameSetting getDefaultGame(int agentNum){
		if(agentNum < 5){
			throw new IllegalArgumentException("agentNum must be bigger than 5 but "+agentNum);
		}
		if(agentNum > roleNumArray.length){
			throw new IllegalArgumentException("agentNum must be smaller than 16 but "+agentNum);
		}
		
		GameSetting setting = new GameSetting();
		setting.maxTalk = 10;
		setting.isEnableNoAttack = false;
		setting.isVoteVisible = true;
		setting.isVotableInFirstDay = false;
		
		Role[] roles = Role.values();
		for(int i = 0; i < roles.length; i++){
			setting.roleNumMap.put(roles[i], roleNumArray[agentNum][i]);
		}
		return setting;
	}

	static public GameSetting getSeminarGame(){
		GameSetting setting = new GameSetting();
		setting.maxTalk = 10;
		setting.isEnableNoAttack = false;
		setting.isVoteVisible = true;
		
		Role[] roles = Role.values();
		for(int i = 0; i < roles.length; i++){
			setting.roleNumMap.put(roles[i], seminarArray[i]);
		}
		return setting;
		
	}
	
	
	/**
	 * number of each charactors
	 */
	Map<Role, Integer> roleNumMap;
	
	/**
	 * max number of talk;
	 */
	int maxTalk;
	
	/**
	 * Is the game permit to attack no one 
	 */
	boolean isEnableNoAttack;

	/**
	 * Can agents see who vote to who
	 */
	boolean isVoteVisible;

	/**
	 * Are there vote in first day?
	 */
	private boolean isVotableInFirstDay;
	
	/**
	 * Random Seed
	 */
	long randomSeed = System.currentTimeMillis();

	public GameSetting(){
		roleNumMap = new HashMap<Role, Integer>();
	}
	
	/**
	 * 
	 * @param role
	 * @return
	 */
	public int getRoleNum(Role role){
		if(roleNumMap.containsKey(role)){
			return roleNumMap.get(role);
		}
		else{
			return 0;
		}
	}

	/**
	 * 
	 * @return
	 */
	public int getMaxTalk() {
		return maxTalk;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEnableNoAttack() {
		return isEnableNoAttack;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isVoteVisible(){
		return isVoteVisible;
	}

	/**
	 * 
	 */
	public boolean isVotableInFirstDay(){
		return isVotableInFirstDay;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPlayerNum(){
		int num = 0;
		for(int value:roleNumMap.values()){
			num += value;
		}
		return num;
	}

	/**
	 * 
	 * @return
	 */
	public Map<Role, Integer> getRoleNumMap() {
		return roleNumMap;
	}

	/**
	 * @param roleNumMap セットする roleNumMap
	 */
	public void setRoleNumMap(Map<Role, Integer> roleNumMap) {
		this.roleNumMap = roleNumMap;
	}

	/**
	 * @param maxTalk セットする maxTalk
	 */
	public void setMaxTalk(int maxTalk) {
		this.maxTalk = maxTalk;
	}

	/**
	 * @param isEnableNoAttack セットする isEnableNoAttack
	 */
	public void setEnableNoAttack(boolean isEnableNoAttack) {
		this.isEnableNoAttack = isEnableNoAttack;
	}

	/**
	 * @param isVoteVisible セットする isVoteVisible
	 */
	public void setVoteVisible(boolean isVoteVisible) {
		this.isVoteVisible = isVoteVisible;
	}

	/**
	 * @return randomSeed
	 */
	public long getRandomSeed() {
		return randomSeed;
	}

	/**
	 * @param randomSeed セットする randomSeed
	 */
	public void setRandomSeed(long randomSeed) {
		this.randomSeed = randomSeed;
	}
	
	
	
}
