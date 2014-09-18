package org.aiwolf.common.net;

import java.util.Map;

import org.aiwolf.common.data.Role;

public interface GameSetting {

	/**
	 * get number of roles
	 * @param role
	 * @return
	 */
	public abstract int getRoleNum(Role role);

	/**
	 * 
	 * @return
	 */
	public abstract int getMaxTalk();

	/**
	 * Is enable no attack
	 * @return
	 */
	public abstract boolean isEnableNoAttack();

	/**
	 * is vote visible
	 * @return
	 */
	public abstract boolean isVoteVisible();

	/**
	 * get total numbers of players
	 * @return
	 */
	public abstract int getPlayerNum();

	/**
	 * @return roleNumMap
	 */
	public abstract Map<Role, Integer> getRoleNumMap();

}