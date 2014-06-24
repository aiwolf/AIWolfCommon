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
	bodyguard(Team.villager, Species.Human),
	/**
	 * freemason<br>
	 * ver0.1.xでは使用されません
	 * @deprecated
	 */
	freemason(Team.villager, Species.Human),
	/**
	 * medium
	 */
	medium(Team.villager, Species.Human),
	/**
	 * Possessed
	 */
	possessed(Team.werewolf, Species.Human),
	/**
	 * Seer
	 */
	seer(Team.villager, Species.Human),
	
	/**
	 * Villager
	 */
	villager(Team.villager, Species.Human),
	
	/**
	 * WereWolf
	 */
	werewolf(Team.werewolf, Species.Werewolf);
	
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
