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
public class GameSettingEntity implements GameSetting {

	static private int[][] roleNumArray = {
		{},//0
		{},//1
		{},//2
		{},//3
		{0, 0, 0, 0, 1, 2, 1},//4
		{0, 0, 0, 1, 1, 2, 1},//5
		{0, 0, 0, 0, 1, 3, 2},//6
		{0, 0, 0, 0, 1, 4, 2}, //7
		{0, 0, 1, 0, 1, 4, 2}, //8
		{0, 0, 1, 0, 1, 5, 2}, //9
		{1, 0, 1, 0, 1, 5, 2}, //10
		{1, 0, 1, 1, 1, 5, 2}, //11
		{1, 0, 1, 1, 1, 6, 2}, //12
		{1, 0, 1, 1, 1, 7, 2}, //13
		{1, 0, 1, 1, 1, 7, 3}, //14
		{1, 0, 1, 1, 1, 8, 3}, //15
		{1, 0, 1, 1, 1, 9, 3}, //16
	};
	
	/**
	 * セミナー用セット．<br>
	 * 村人8， 人狼3， 占い，狩人
	 */
	static private int[] seminarArray = {
		1, 0, 0, 0, 1, 8, 3 //13
	};
	
	static public GameSettingEntity getDefaultGame(int agentNum){
		if(agentNum < 7){
			throw new IllegalArgumentException("agentNum must be bigger than 8 but "+agentNum);
		}
		if(agentNum > 16){
			throw new IllegalArgumentException("agentNum must be smaller than 16 but "+agentNum);
		}
		
		GameSettingEntity setting = new GameSettingEntity();
		setting.maxTalk = 10;
		setting.isEnableNoAttack = false;
		setting.isVoteVisible = true;
		
		Role[] roles = Role.values();
		for(int i = 0; i < roles.length; i++){
			setting.roleNumMap.put(roles[i], roleNumArray[agentNum][i]);
		}
		return setting;
	}

	static public GameSettingEntity getSeminarGame(){
		GameSettingEntity setting = new GameSettingEntity();
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
	
	public GameSettingEntity(){
		roleNumMap = new HashMap<Role, Integer>();
	}
	
	/* (非 Javadoc)
	 * @see org.aiwolf.common.net.GameSetting#getRoleNum(org.aiwolf.common.data.Role)
	 */
	@Override
	public int getRoleNum(Role role){
		if(roleNumMap.containsKey(role)){
			return roleNumMap.get(role);
		}
		else{
			return 0;
		}
	}

	/* (非 Javadoc)
	 * @see org.aiwolf.common.net.GameSetting#getMaxTalk()
	 */
	@Override
	public int getMaxTalk() {
		return maxTalk;
	}

	/* (非 Javadoc)
	 * @see org.aiwolf.common.net.GameSetting#isEnableNoAttack()
	 */
	@Override
	public boolean isEnableNoAttack() {
		return isEnableNoAttack;
	}
	
	/* (非 Javadoc)
	 * @see org.aiwolf.common.net.GameSetting#isVoteVisible()
	 */
	@Override
	public boolean isVoteVisible(){
		return isVoteVisible;
	}
	
	/* (非 Javadoc)
	 * @see org.aiwolf.common.net.GameSetting#getPlayerNum()
	 */
	@Override
	public int getPlayerNum(){
		int num = 0;
		for(int value:roleNumMap.values()){
			num += value;
		}
		return num;
	}

	/* (非 Javadoc)
	 * @see org.aiwolf.common.net.GameSetting#getRoleNumMap()
	 */
	@Override
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
	
	
}
