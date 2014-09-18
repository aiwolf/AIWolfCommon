package org.aiwolf.common.data;

/**
 * Roles of Player
 * @author tori
 *
 */
public enum Role {
	/**
	 * bodyguard
	 */
	BODYGUARD(Team.VILLAGER, Species.HUMAN),
	/**
	 * freemason<br>
	 * ver0.1.xでは使用されません
	 * @deprecated
	 */
	FREEMASON(Team.VILLAGER, Species.HUMAN),
	/**
	 * medium
	 */
	MEDIUM(Team.VILLAGER, Species.HUMAN),
	/**
	 * Possessed
	 */
	POSSESSED(Team.WEREWOLF, Species.HUMAN),
	/**
	 * Seer
	 */
	SEER(Team.VILLAGER, Species.HUMAN),
	
	/**
	 * Villager
	 */
	VILLAGER(Team.VILLAGER, Species.HUMAN),
	
	/**
	 * WereWolf
	 */
	WEREWOLF(Team.WEREWOLF, Species.WEREWOLF);
	
	private Team teamType;
	private Species species;
	
	private Role(Team teamType, Species species){
		this.teamType = teamType;
		this.species = species;
	}
	/**
	 * @return teamType
	 */
	public Team getTeam() {
		return teamType;
	}
	
	/**
	 * 
	 * @return species
	 */
	public Species getSpecies() {
		return species;
	}
	
	
}
