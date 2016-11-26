package org.aiwolf.common.data;

/**
 * 
 * <div lang="ja">プレイヤーの役職の列挙です。</div>
 * 
 * <div lang="en">Roles of Player.</div>
 * 
 * @author tori
 */
public enum Role {

	/**
	 * <div lang="ja">狩人を表します。</div>
	 * 
	 * <div lang="en">The role Bodyguard.</div>
	 */
	BODYGUARD(Team.VILLAGER, Species.HUMAN),

	/**
	 * 
	 * <div lang="ja">共有者を表します。<br>
	 * </div>
	 * 
	 * <div lang="en">The role Freemason.<br>
	 * </div>
	 * 
	 */
	FREEMASON(Team.VILLAGER, Species.HUMAN),

	/**
	 * <div lang="ja">霊能者です。</div>
	 * 
	 * <div lang="en">The role Medium.</div>
	 */
	MEDIUM(Team.VILLAGER, Species.HUMAN),

	/**
	 * <div lang="ja">狂人です。</div>
	 * 
	 * <div lang="en">The role Possessed.</div>
	 */
	POSSESSED(Team.WEREWOLF, Species.HUMAN),

	/**
	 * <div lang="ja">占い師です。</div>
	 * 
	 * <div lang="en">The role Seer.</div>
	 */
	SEER(Team.VILLAGER, Species.HUMAN),

	/**
	 * <div lang="ja">村人です。</div>
	 * 
	 * <div lang="en">The role Villager.</div>
	 */
	VILLAGER(Team.VILLAGER, Species.HUMAN),

	/**
	 * <div lang="ja">人狼です。</div>
	 * 
	 * <div lang="en">The role WereWolf.</div>
	 */
	WEREWOLF(Team.WEREWOLF, Species.WEREWOLF),

	/**
	 * <div lang="ja">妖狐です。</div>
	 * 
	 * <div lang="en">The role FOX.</div>
	 */
	FOX(Team.OTHERS, Species.WEREWOLF);

	private Team teamType;
	private Species species;

	private Role(Team teamType, Species species) {
		this.teamType = teamType;
		this.species = species;
	}

	/**
	 * <div lang="ja">役職の属している陣営を返します。</div>
	 * 
	 * <div lang="en"><!--Insert English Document--></div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">役職の属している陣営</div>
	 * 
	 *         <div lang="en">Team type</div>
	 */
	public Team getTeam() {
		return teamType;
	}

	/**
	 * <div lang="ja">役職の属している種族を返します。</div>
	 * 
	 * <div lang="en"><!--Insert English Document--></div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">役職の属している種族</div>
	 * 
	 *         <div lang="en">Species</div>
	 */
	public Species getSpecies() {
		return species;
	}
}
