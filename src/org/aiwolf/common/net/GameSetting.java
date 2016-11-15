package org.aiwolf.common.net;

import java.util.HashMap;
import java.util.Map;

import org.aiwolf.common.data.Role;

/**
 * <div lang="ja">ゲームの設定です。</div>
 *
 * <div lang="en">Settings of game.</div>
 *
 * @author tori
 *
 */
public class GameSetting implements Cloneable {

	//TODO 最大得票プレイヤーが同数だった場合の挙動

	//TODO 最大襲撃得票プレイヤーが同数だった場合の挙動
	//TODO 再襲撃投票の回数(Defaultは0)
	//TODO 最大襲撃得票数が同じだったときの処理(ランダム or 襲撃無し)
	//TODO 襲撃再投票時のWhisperの有無
	
	//TODO 人狼知能プロトコル違反チェックを行うかどうか
	
	
	/**
	 * <div lang="ja">
	 *
	 * 各役職の人数です。
	 *
	 * 狩人、共有者、霊能者、狂人、占い師、
	 *
	 * 村人、人狼の順になっています。
	 *
	 * <div>
	 *
	 * <div lang="en">
	 *
	 * Num of each roles.
	 *
	 * Bodyguard, FreeMason, Medium, Possessed, Seer,
	 *
	 * Villager, Werewolf.
	 *
	 * </div>
	 */
	static final private int[][] roleNumArray = {
			// {狩, 共, 霊, 狂, 占, 村, 狼}
			{}, // 0
			{}, // 1
			{}, // 2
			{}, // 3
			{ 0, 0, 0, 0, 1, 2, 1 }, // 4
			{ 0, 0, 0, 1, 1, 2, 1 }, // 5
			{ 0, 0, 0, 1, 1, 3, 1 }, // 6
			{ 0, 0, 0, 0, 1, 4, 2 }, // 7
			{ 0, 0, 1, 0, 1, 4, 2 }, // 8
			{ 0, 0, 1, 0, 1, 5, 2 }, // 9
			{ 1, 0, 1, 1, 1, 4, 2 }, // 10
			{ 1, 0, 1, 1, 1, 5, 2 }, // 11
			{ 1, 0, 1, 1, 1, 5, 3 }, // 12
			{ 1, 0, 1, 1, 1, 6, 3 }, // 13
			{ 1, 0, 1, 1, 1, 7, 3 }, // 14
			{ 1, 0, 1, 1, 1, 8, 3 }, // 15
			{ 1, 0, 1, 1, 1, 9, 3 }, // 16
			{ 1, 0, 1, 1, 1, 10, 3 }, // 17
			{ 1, 0, 1, 1, 1, 11, 3 }, // 18
	};

	/**
	 * <div lang="ja">
	 *
	 * セミナー用のセットです。<br>
	 * 村人8、人狼3、占い1、狩人1の合計13人で構成されています。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Num of each roles for seminar.
	 *
	 * </div>
	 */
	static final private int[] seminarArray = {
			// {狩, 共, 霊, 狂, 占, 村, 狼}
			1, 0, 0, 0, 1, 8, 3 // 13
	};

	/**
	 * <div lang="ja">通常のゲーム設定を返します。</div>
	 *
	 * <div lang="en">Get the default game setting.</div>
	 *
	 * @param agentNum
	 *
	 *            <div lang="ja">ゲームに参加するエージェントの数</div>
	 *
	 *            <div lang="en">Number of agents</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">通常のゲーム設定</div>
	 *
	 *         <div lang="en">Default game setting</div>
	 */
	static public GameSetting getDefaultGame(int agentNum) {
		if (agentNum < 4) {
			throw new IllegalArgumentException("agentNum must be bigger than 4 but " + agentNum);
		}
		if (agentNum > roleNumArray.length) {
			throw new IllegalArgumentException("agentNum must be smaller than "+roleNumArray.length+" but " + agentNum);
		}

		GameSetting setting = new GameSetting();
		setting.maxTalk = 10;
		setting.isEnableNoAttack = false;
		setting.isVoteVisible = true;
		setting.isVotableInFirstDay = false;
		// already initialized
		// setting.maxRevote = 0;
		// setting.timeLimit = 1000;
		// setting.isEnableNoBanish = false;
		// setting.isTalkOnFirstDay = false;

		Role[] roles = Role.values();
		for (int i = 0; i < roles.length; i++) {
			setting.roleNumMap.put(roles[i], roleNumArray[agentNum][i]);
		}
		return setting;
	}

	/**
	 * <div lang="ja">セミナー用のゲーム設定を返します。</div>
	 *
	 * <div lang="en">Get the game setting for seminar.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">セミナー用のゲーム設定</div>
	 *
	 *         <div lang="en">Game setting for seminar</div>
	 */
	static public GameSetting getSeminarGame() {
		GameSetting setting = new GameSetting();
		setting.maxTalk = 10;
		setting.isEnableNoAttack = false;
		setting.isVoteVisible = true;

		Role[] roles = Role.values();
		for (int i = 0; i < roles.length; i++) {
			setting.roleNumMap.put(roles[i], seminarArray[i]);
		}
		return setting;
	}

	/**
	 * <div lang="ja">各役職が何人かを関連付けたマップ</div>
	 *
	 * <div lang="en">Number of each charactors</div>
	 */
	Map<Role, Integer> roleNumMap;

	/**
	 * <div lang="ja">1日あたりの発言の最大数</div>
	 *
	 * <div lang="en">Max number of talk</div>
	 */
	int maxTalk;

	/**
	 * <div lang="ja">誰も襲撃しないのを許すかどうか</div>
	 *
	 * <div lang="en">Is the game permit to attack no one?</div>
	 */
	boolean isEnableNoAttack;

	/**
	 * <div lang="ja">誰が誰に投票したかをエージェントが確認できるかどうか</div>
	 *
	 * <div lang="en">Can agents see who vote to who?</div>
	 */
	boolean isVoteVisible;

	/**
	 * <div lang="ja">初日の投票をできるようにするかどうか</div>
	 *
	 * <div lang="en">Are there vote in first day?</div>
	 */
	private boolean isVotableInFirstDay;

	/**
	 * <div lang="ja">得票数同数で決まらなかった場合「追放なし」とするかどうか。falseの場合はランダム</div>
	 * 
	 * <div lang="en">Whether or not no banish is allowed when the vote ends in a tie.</div>
	 */
	private boolean isEnableNoBanish = false;

	/**
	 * <div lang="ja">Day 0にtalkがあるかどうか</div>
	 * 
	 * <div lang="en">Whether of not there are talks on day 0
	 */
	private boolean isTalkOnFirstDay = false;

	/**
	 * <div lang="ja">ランダムシード(乱数種)</div>
	 *
	 * <div lang="en">Random Seed</div>
	 */
	long randomSeed = System.currentTimeMillis();

	/**
	 * <div lang="ja">リクエスト応答時間の上限</div>
	 * 
	 * <div lang="en">Time limit for the response to the request</div>
	 */
	private int timeLimit = 1000;

	/**
	 * <div lang="ja">最大再投票回数</div>
	 * 
	 * <div lang="en">Maximum number of revotes</div>
	 */
	private int maxRevote = 0;

	/**
	 * <div lang="ja">
	 *
	 * 新しいゲーム設定を構築します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Create new game setting.
	 *
	 * </div>
	 */
	public GameSetting() {
		roleNumMap = new HashMap<>();
	}

	/**
	 * <div lang="ja">
	 *
	 * 指定された役職の人数を返します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Get the number of roles.
	 *
	 * </div>
	 *
	 * @param role
	 *
	 *            <div lang="ja">役職</div>
	 *
	 *            <div lang="en">Role</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">指定された役職の人数</div>
	 *
	 *         <div lang="en">Number of roles</div>
	 */
	public int getRoleNum(Role role) {
		if (roleNumMap.containsKey(role)) {
			return roleNumMap.get(role);
		} else {
			return 0;
		}
	}

	/**
	 * <div lang="ja">1日あたりの発言の最大数を返します。</div>
	 *
	 * <div lang="en">Get the max number of talks.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">1日あたりの発言の最大数</div>
	 *
	 *         <div lang="en">Max number of talk</div>
	 */
	public int getMaxTalk() {
		return maxTalk;
	}

	/**
	 * <div lang="ja">
	 *
	 * 誰も襲撃しないのを許されているかどうかを返します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Is the game permit to attack no one?
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">
	 *
	 *         誰も襲撃しないのを許されているかどうか
	 *
	 *         </div>
	 *
	 *         <div lang="en">
	 *
	 *         Permission for werewolfs attack no one.
	 *
	 *         </div>
	 */
	public boolean isEnableNoAttack() {
		return isEnableNoAttack;
	}

	/**
	 * <div lang="ja">
	 *
	 * 誰が誰に投票したかをエージェントが確認できるかを返します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Can agents see who vote to who?
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">
	 *
	 *         誰が誰に投票したかをエージェントが確認できるかどうか
	 *
	 *         </div>
	 *
	 *         <div lang="en">
	 *
	 *         Permission for agents see who vote to who
	 *
	 *         </div>
	 */
	public boolean isVoteVisible() {
		return isVoteVisible;
	}

	/**
	 * <div lang="ja">
	 *
	 * 初日の投票ができるかどうかを返します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Are there vote in first day?
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">
	 *
	 *         初日の投票ができるかどうか
	 *
	 *         </div>
	 *
	 *         <div lang="en">
	 *
	 *         Permission for there vote in first day
	 *
	 *         </div>
	 */
	public boolean isVotableInFirstDay() {
		return isVotableInFirstDay;
	}

	/**
	 * <div lang="ja">同票数の場合に追放なしとするかどうかを返します。</div>
	 * 
	 * <div lang="en">Returns whether or not no banish is allowed.</div>
	 * 
	 * @return <div lang="ja">同票数の場合に追放なしとするかどうか </div><div lang="en">whether or not no banish is allowed</div>
	 */
	public boolean isEnableNoBanish() {
		return isEnableNoBanish;
	}

	/**
	 * <div lang="ja">Day 0にtalkがあるかどうかを返します。</div>
	 * 
	 * <div lang="en">Returns whether or not there are talks on day 0.</div>
	 * 
	 * @return <div lang="ja">Day 0にtalkがあるかどうか</div> <div lang="en">whether or not there are talks on day 0</div>
	 */
	public boolean isTalkOnFirstDay() {
		return isTalkOnFirstDay;
	}

	/**
	 * <div lang="ja">
	 *
	 * プレイヤーの人数を返します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Get the number of players.
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">プレイヤーの人数</div>
	 *
	 *         <div lang="en">Number of players</div>
	 */
	public int getPlayerNum() {
		int num = 0;
		for (int value : roleNumMap.values()) {
			num += value;
		}
		return num;
	}

	/**
	 * <div lang="ja">
	 *
	 * 役職に対する人数を関連付けたマップを返します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Get number of each charactors.
	 *
	 * </div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">
	 *
	 *         役職に対する人数を関連付けたマップ
	 *
	 *         </div>
	 *
	 *         <div lang="en">
	 *
	 *         Number of each charactors
	 *
	 *         </div>
	 */
	public Map<Role, Integer> getRoleNumMap() {
		return roleNumMap;
	}

	/**
	 * <div lang="ja">
	 *
	 * 役職に対する人数を関連付けたマップを設定します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Set number of each charactors.
	 *
	 * </div>
	 *
	 * @param roleNumMap
	 *
	 *            <div lang="ja">役職に対する人数を関連付けたマップ</div>
	 *
	 *            <div lang="en">Number of each charactors</div>
	 */
	public void setRoleNumMap(Map<Role, Integer> roleNumMap) {
		this.roleNumMap = roleNumMap;
	}

	/**
	 * <div lang="ja">
	 *
	 * 1日あたりの発言の最大数を設定します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Set max number of talks.
	 *
	 * </div>
	 *
	 * @param maxTalk
	 *
	 *            <div lang="ja">1日あたりの発言の最大数</div>
	 *
	 *            <div lang="en">Max number of talks</div>
	 */
	public void setMaxTalk(int maxTalk) {
		this.maxTalk = maxTalk;
	}

	/**
	 * <div lang="ja">
	 *
	 * 誰も襲撃しないのを許すかどうかを設定します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Set permission for werewolfs attack no one.
	 *
	 * </div>
	 *
	 * @param isEnableNoAttack
	 *
	 *            <div lang="ja">誰も襲撃しないのを許すかどうか</div>
	 *
	 *            <div lang="en">Permission for werewolfs attack no one</div>
	 */
	public void setEnableNoAttack(boolean isEnableNoAttack) {
		this.isEnableNoAttack = isEnableNoAttack;
	}

	/**
	 * <div lang="ja">
	 *
	 * 誰が誰に投票したかをエージェントが確認できるかどうかを設定します。
	 *
	 * </div>
	 *
	 * <div lang="en">
	 *
	 * Set permission for agents see who vote to who.
	 *
	 * </div>
	 *
	 * @param isVoteVisible
	 *
	 *            <div lang="ja">
	 *
	 *            誰が誰に投票したかをエージェントが確認できるかどうか
	 *
	 *            </div>
	 *
	 *            <div lang="en">
	 *
	 *            Permission for agents see who vote to who
	 *
	 *            </div>
	 */
	public void setVoteVisible(boolean isVoteVisible) {
		this.isVoteVisible = isVoteVisible;
	}

	/**
	 * <div lang="ja">同票数の場合に追放なしとするかどうかをセットします。</div>
	 * 
	 * <div lang="en">Sets whether or not no banish is allowed.</div>
	 * 
	 * @param isEnableNoBanish
	 *            - <div lang="ja">同票数の場合に追放なしとするかどうか </div><div lang="en">whether or not no banish is allowed</div>
	 */
	public void setEnableNoBanish(boolean isEnableNoBanish) {
		this.isEnableNoBanish = isEnableNoBanish;
	}

	/**
	 * <div lang="ja">Day 0にtalkがあるかどうかをセットします。</div>
	 * 
	 * <div lang="en">Sets whether or not there are talks on day 0.</div>
	 * 
	 * @param isTalkOnFirstDay
	 *            - <div lang="ja">Day 0にtalkがあるかどうか</div> <div lang="en">whether or not there are talks on day 0</div>
	 */
	public void setTalkOnFirstDay(boolean isTalkOnFirstDay) {
		this.isTalkOnFirstDay = isTalkOnFirstDay;
	}

	/**
	 * <div lang="ja">ランダムシードを返します。</div>
	 *
	 * <div lang="en">Get the random seed.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">ランダムシード</div>
	 *
	 *         <div lang="en">Random seed</div>
	 */
	public long getRandomSeed() {
		return randomSeed;
	}

	/**
	 * <div lang="ja">ランダムシードを設定します。</div>
	 *
	 * <div lang="en">Set the random seed.</div>
	 *
	 * @param randomSeed
	 *
	 *            <div lang="ja">ランダムシード</div>
	 *
	 *            <div lang="en">Random seed</div>
	 */
	public void setRandomSeer(long randomSeed) {
		this.randomSeed = randomSeed;
	}

	/**
	 * <div lang="ja">リクエスト応答時間の上限を返します。</div>
	 * 
	 * <div lang="en">Returns the time limit for the response to the request.<div>
	 * 
	 * @return <div lang="ja">制限時間</div><div lang="en">the time limit<div>
	 */
	public int getTimeLimit() {
		return timeLimit;
	}

	/**
	 * <div lang="ja">リクエスト応答時間の上限をセットします。</div>
	 * 
	 * <div lang="en">Sets the time limit for the response to the request.</div>
	 * 
	 * @param timeLimit
	 *            - <div lang="ja">制限時間</div> <div lang="en">the timeLimit to set</div>
	 */
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	/**
	 * <div lang="ja">最大再投票回数を返します。</div>
	 * 
	 * <div lang="en">Returns the maximum number of revotes.<div>
	 * 
	 * @return <div lang="ja">最大再投票回数</div><div lang="en">the maximum number of revotes<div>
	 */
	public int getMaxRevote() {
		return maxRevote;
	}

	/**
	 * <div lang="ja">最大再投票回数をセットします。</div>
	 * 
	 * <div lang="en">Sets the maximum number of revotes.</div>
	 * 
	 * @param maxRevote
	 *            - <div lang="ja">最大再投票回数</div> <div lang="en">the maximum number of revotes</div>
	 */
	public void setMaxRevote(int maxRevote) {
		this.maxRevote = maxRevote;
	}

	/**
	 * <div lang="ja">ゲーム設定の複製を作成し、返します。</div>
	 *
	 * <div lang="en">Create copy.</div>
	 *
	 * @return
	 *
	 * 		<div lang="ja">ゲーム設定の複製</div>
	 *
	 *         <div lang="en">Copy of this object</div>
	 */
	@Override
	public GameSetting clone() {
		GameSetting gameSetting = new GameSetting();
		gameSetting.isEnableNoAttack = isEnableNoAttack;
		gameSetting.isVotableInFirstDay = isVotableInFirstDay;
		gameSetting.isVoteVisible = isVoteVisible;
		gameSetting.isEnableNoBanish = isEnableNoBanish;
		gameSetting.isTalkOnFirstDay = isTalkOnFirstDay;
		gameSetting.maxTalk = maxTalk;
		gameSetting.randomSeed = randomSeed;
		gameSetting.timeLimit = timeLimit;
		gameSetting.maxRevote = maxRevote;
		gameSetting.roleNumMap.putAll(roleNumMap);
		return gameSetting;
	}
}
