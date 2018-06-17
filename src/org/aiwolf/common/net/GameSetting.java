/**
 * GameSetting.java
 *
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.common.net;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

	/**
	 * <div lang="ja">
	 *
	 * 各役職の人数です。
	 *
	 * 狩人、共有者、霊媒師、狂人、占い師、
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
			// {BODYGUARD, FREEMASON, MEDIUM, POSSESSED, SEER, VILLAGER, WEREWOLF, FOX}
			{}, // 0
			{}, // 1
			{}, // 2
			{ 0, 0, 0, 0, 1, 1, 1, 0 }, // 3
			{ 0, 0, 0, 0, 1, 2, 1, 0 }, // 4
			{ 0, 0, 0, 1, 1, 2, 1, 0 }, // 5
			{ 0, 0, 0, 1, 1, 3, 1, 0 }, // 6
			{ 0, 0, 0, 0, 1, 4, 2, 0 }, // 7
			{ 0, 0, 1, 0, 1, 4, 2, 0 }, // 8
			{ 0, 0, 1, 0, 1, 5, 2, 0 }, // 9
			{ 1, 0, 1, 1, 1, 4, 2, 0 }, // 10
			{ 1, 0, 1, 1, 1, 5, 2, 0 }, // 11
			{ 1, 0, 1, 1, 1, 5, 3, 0 }, // 12
			{ 1, 0, 1, 1, 1, 6, 3, 0 }, // 13
			{ 1, 0, 1, 1, 1, 7, 3, 0 }, // 14
			{ 1, 0, 1, 1, 1, 8, 3, 0 }, // 15
			{ 1, 0, 1, 1, 1, 9, 3, 0 }, // 16
			{ 1, 0, 1, 1, 1, 10, 3, 0 }, // 17
			{ 1, 0, 1, 1, 1, 11, 3, 0 }, // 18
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
	 *
	 * @deprecated
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
		if (agentNum < 3) {
			throw new IllegalArgumentException("agentNum must be bigger than 3 but " + agentNum);
		}
		if (agentNum > roleNumArray.length) {
			throw new IllegalArgumentException("agentNum must be smaller than " + roleNumArray.length + " but " + agentNum);
		}

		GameSetting setting = new GameSetting();
		setting.maxTalk = 10;
		setting.maxTalkTurn = 20;
		setting.maxWhisper = 10;
		setting.maxWhisperTurn = 20;
		setting.maxSkip = 2;
		setting.isEnableNoAttack = false;
		setting.isVoteVisible = true;
		setting.isVotableInFirstDay = false;
		setting.isEnableNoExecution = false;
		setting.isTalkOnFirstDay = false;
		setting.isValidateUtterance = true;
		setting.isWhisperBeforeRevote = false;
		setting.timeLimit = -1; // -1: is not set yet
		setting.maxRevote = 1;
		setting.maxAttackRevote = 1;
		setting.isEnableRoleRequest = true;

		Role[] roles = Role.values();
		for (int i = 0; i < roles.length; i++) {
			setting.roleNumMap.put(roles[i], roleNumArray[agentNum][i]);
		}
		return setting;
	}

	/**
	 * <div lang="ja">ファイルから設定を読み込んで返します</div>
	 *
	 * <div lang="en">Returns game setting read from configuration file.</div>
	 *
	 * @param fileName
	 *            <div lang="ja">設定ファイルのファイル名</div>
	 *
	 *            <div lang="en">configuration file's name</div>
	 *
	 * @return <div lang="ja">読み込んだGameSetting</div>
	 *
	 *         <div lang="en">GameSetting read from file</div>
	 *
	 * @throws IOException
	 */
	static public GameSetting getCustomGame(String fileName, int agentNum) throws IOException {
		GameSetting setting = new GameSetting();

		Path src = new File(fileName).toPath();
		for (String line : Files.readAllLines(src, Charset.forName("UTF8"))) {
			if (line.startsWith("#")) {
				continue;
			} else if (line.contains("=")) {
				String[] data = line.split("=");
				if (data.length < 2) {
					continue;
				}
				if (data[0].trim().equalsIgnoreCase("maxtalk")) {
					setting.maxTalk = Integer.parseInt(data[1].trim());
				} else if (data[0].trim().equalsIgnoreCase("maxtalkturn")) {
					setting.maxTalkTurn = Integer.parseInt(data[1].trim());
				} else if (data[0].trim().equalsIgnoreCase("maxwhisper")) {
					setting.maxWhisper = Integer.parseInt(data[1].trim());
				} else if (data[0].trim().equalsIgnoreCase("maxwhisperturn")) {
					setting.maxWhisperTurn = Integer.parseInt(data[1].trim());
				} else if (data[0].trim().equalsIgnoreCase("maxskip")) {
					setting.maxSkip = Integer.parseInt(data[1].trim());
				} else if (data[0].trim().equalsIgnoreCase("randomseed")) {
					setting.randomSeed = Integer.parseInt(data[1].trim());
				} else if (data[0].trim().equalsIgnoreCase("timelimit")) {
					setting.timeLimit = Integer.parseInt(data[1].trim());
				} else if (data[0].trim().equalsIgnoreCase("maxrevote")) {
					setting.maxRevote = Integer.parseInt(data[1].trim());
				} else if (data[0].trim().equalsIgnoreCase("maxattackrevote")) {
					setting.maxAttackRevote = Integer.parseInt(data[1].trim());
				} else if (data[0].trim().equalsIgnoreCase("isenablenoattack")) {
					if (data[1].trim().matches("^[YyTt].*")) {
						setting.isEnableNoAttack = true;
					}
				} else if (data[0].trim().equalsIgnoreCase("isvotevisible")) {
					if (data[1].trim().matches("^[YyTt].*")) {
						setting.isVoteVisible = true;
					}
				} else if (data[0].trim().equalsIgnoreCase("isvotableinfirstday")) {
					if (data[1].trim().matches("^[YyTt].*")) {
						setting.isVotableInFirstDay = true;
					}
				} else if (data[0].trim().equalsIgnoreCase("isenablenoexecution")) {
					if (data[1].trim().matches("^[YyTt].*")) {
						setting.isEnableNoExecution = true;
					}
				} else if (data[0].trim().equalsIgnoreCase("istalkonfirstday")) {
					if (data[1].trim().matches("^[YyTt].*")) {
						setting.isTalkOnFirstDay = true;
					}
				} else if (data[0].trim().equalsIgnoreCase("isvalidateutterance")) {
					if (data[1].trim().matches("^[YyTt].*")) {
						setting.isValidateUtterance = true;
					}
				} else if (data[0].trim().equalsIgnoreCase("iswhisperbeforerevote")) {
					if (data[1].trim().matches("^[YyTt].*")) {
						setting.isWhisperBeforeRevote = true;
					}
				} else if (data[0].trim().equalsIgnoreCase("isenablerolerequest")) {
					if (data[1].trim().matches("^[YyTt].*")) {
						setting.isEnableRoleRequest = true;
					}
				}
			}
		}

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
	 * @return <div lang="ja">セミナー用のゲーム設定</div>
	 *
	 *         <div lang="en">Game setting for seminar</div>
	 *
	 * @deprecated
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
	 * <div lang="ja">1日あたりの発言時間の最大数</div>
	 *
	 * <div lang="en">Max number of talk time</div>
	 */
	int maxTalkTurn;

	/**
	 * <div lang="ja">1日あたりの発言の最大数</div>
	 *
	 * <div lang="en">Max number of talk</div>
	 */
	int maxWhisper;

	/**
	 * <div lang="ja">1日あたりの発言時間の最大数</div>
	 *
	 * <div lang="en">Max number of talk time</div>
	 */
	int maxWhisperTurn;

	/**
	 * <div lang="ja">連続Skipの最大数</div>
	 *
	 * <div lang="en">Max number of contunious skip</div>
	 */

	int maxSkip;

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
	 * <div lang="en">Whether or not executing nobody is allowed when the vote ends in a tie.</div>
	 */
	private boolean isEnableNoExecution;

	/**
	 * <div lang="ja">Day 0にtalkがあるかどうか</div>
	 *
	 * <div lang="en">Whether of not there are talks on day 0
	 */
	private boolean isTalkOnFirstDay;

	/**
	 * <div lang="ja">発話文字列の違反チェックを行うかどうか</div>
	 *
	 * <div lang="en">Whether or not the text in talk/whisper is validated
	 */
	private boolean isValidateUtterance;

	/**
	 * <div lang="ja">再襲撃投票前にwhisperするかどうか</div>
	 *
	 * <div lang="en">whether or not there is whisper before the revote for attack</div>
	 */
	private boolean isWhisperBeforeRevote;

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
	int timeLimit;

	/**
	 * <div lang="ja">最大再投票回数</div>
	 *
	 * <div lang="en">Maximum number of revotes</div>
	 */
	int maxRevote;

	/**
	 * <div lang="ja">最大再襲撃投票回数</div>
	 *
	 * <div lang="en">Maximum number of revotes for attack</div>
	 */
	int maxAttackRevote;

	/**
	 * <div lang="ja">役職要求の可否</div>
	 *
	 * <div lang="en">Can request role</div>
	 */

	boolean isEnableRoleRequest;

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
		randomSeed = new Random().nextLong();
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
	 *            <div lang="ja">役職</div>
	 *
	 *            <div lang="en">Role</div>
	 *
	 * @return <div lang="ja">指定された役職の人数</div>
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
	 * @return <div lang="ja">1日あたりの発言の最大数</div>
	 *
	 *         <div lang="en">Max number of talk</div>
	 */
	public int getMaxTalk() {
		return maxTalk;
	}

	/**
	 * <div lang="ja"> 1日あたりの発言の最大数を設定します。 </div>
	 *
	 * <div lang="en"> Set max number of talks. </div>
	 *
	 * @param maxTalk
	 *            <div lang="ja">1日あたりの発言の最大数</div>
	 *
	 *            <div lang="en">Max number of talks</div>
	 */
	public void setMaxTalk(int maxTalk) {
		this.maxTalk = maxTalk;
	}

	/**
	 * <div lang="ja">1日あたりの発言ターンの最大数を返します。</div>
	 *
	 * <div lang="en">Get the max turn of talks.</div>
	 *
	 * @return <div lang="ja">1日あたりの発言ターン最大数</div>
	 *
	 *         <div lang="en">Max turn of talk</div>
	 */
	public int getMaxTalkTurn() {
		return this.maxTalkTurn;
	}

	/**
	 * <div lang="ja">1日あたりの発言ターンの最大数をセットする</div>
	 *
	 * <div lang="en">Sets the maximum number of turns of talk.</div>
	 *
	 * @param maxTalkTurn
	 *            <div lang="ja">1日あたりの発言ターン最大数を表す{@code int}</div>
	 *
	 *            <div lang="en">{@code int} representing the maximum number of turns of talk</div>
	 */
	public void setMaxTalkTurn(int maxTalkTurn) {
		this.maxTalkTurn = maxTalkTurn;
	}

	/**
	 * <div lang="ja">1日あたりの囁きの最大数を返します。</div>
	 *
	 * <div lang="en">Get the max number of Whispers.</div>
	 *
	 * @return <div lang="ja">1日あたりの囁きの最大数</div>
	 *
	 *         <div lang="en">Max number of Whisper</div>
	 */
	public int getMaxWhisper() {
		return maxWhisper;
	}

	/**
	 * <div lang="ja"> 1日あたりの囁きの最大数を設定します。 </div>
	 *
	 * <div lang="en"> Sets the maximum number of whispers a day. </div>
	 *
	 * @param maxWhisper
	 *            <div lang="ja">1日あたりの囁きの最大数を表す{@code int}</div>
	 *
	 *            <div lang="en">{@code int} representing the maximum number of whispers a day.</div>
	 */
	public void setMaxWhisper(int maxWhisper) {
		this.maxWhisper = maxWhisper;
	}

	/**
	 * <div lang="ja">1日あたりの囁きターンの最大数を返します。</div>
	 *
	 * <div lang="en">Get the max turn of Whispers.</div>
	 *
	 * @return <div lang="ja">1日あたりの囁きターン最大数</div>
	 *
	 *         <div lang="en">Max turn of Whisper</div>
	 */
	public int getMaxWhisperTurn() {
		return this.maxWhisperTurn;
	}

	/**
	 * <div lang="ja">1日あたりの囁きターンの最大数をセットする</div>
	 *
	 * <div lang="en">Sets the maximum number of turns of whisper.</div>
	 *
	 * @param maxWhisperTurn
	 *            <div lang="ja">1日あたりの囁きターン最大数を表す{@code int}</div>
	 *
	 *            <div lang="en">{@code int} representing the maximum number of turns of whisper.</div>
	 */
	public void setMaxWhisperTurn(int maxWhisperTurn) {
		this.maxWhisperTurn = maxWhisperTurn;
	}

	/**
	 * <div lang="ja">連続Skipの最大許容長。これを超える数のSKIPの連続はOVERに変換される</div>
	 *
	 * <div lang="en">The maximum permissible length of the succession of Skips. The returned Skip is converted to Over
	 * if the succession is longer than this.</div>
	 *
	 * @return <div lang="ja">最大許容長を表す{@code int}</div>
	 *
	 *         <div lang="en">{@code int} representing the maximum permissible length.</div>
	 */
	public int getMaxSkip() {
		return maxSkip;
	}

	/**
	 * <div lang="ja">連続Skipの最大許容長をセットする</div>
	 *
	 * <div lang="en">Sets the maximum permissible length of the succession of Skips.</div>
	 *
	 * @param maxSkip
	 *            <div lang="ja">最大許容長を表す{@code int}</div>
	 *
	 *            <div lang="en">{@code int} representing the maximum permissible length.</div>
	 */
	public void setMaxSkip(int maxSkip) {
		this.maxSkip = maxSkip;
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
	 * @return <div lang="ja">
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
	 * @return <div lang="ja">
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
	 * @return <div lang="ja">
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
	 * <div lang="ja"> 初日の投票ができるかどうかをセットする </div>
	 *
	 * <div lang="en"> Sets whether or not there is vote on first day. </div>
	 *
	 * @param isVotableInFirstDay
	 *            <div lang="ja">初日の投票ができるかどうかを表す{@code boolean} </div>
	 *
	 *            <div lang="en"> {@code boolean} representing whether or not there is vote on first day. </div>
	 */
	public void setVotableInFirstDay(boolean isVotableInFirstDay) {
		this.isVotableInFirstDay = isVotableInFirstDay;
	}

	/**
	 * <div lang="ja">同票数の場合に追放なしとするかどうかを返します。</div>
	 *
	 * <div lang="en">Returns whether or not executing nobody is allowed.</div>
	 *
	 * @return <div lang="ja">同票数の場合に追放なしとするかどうか </div>
	 *
	 *         <div lang="en">whether or not executing nobody is allowed</div>
	 */
	public boolean isEnableNoExecution() {
		return isEnableNoExecution;
	}

	/**
	 * <div lang="ja">同票数の場合に追放なしとするかどうかをセットします。</div>
	 *
	 * <div lang="en">Sets whether or not executing nobody is allowed.</div>
	 *
	 * @param isEnableNoExecution
	 *            <div lang="ja">同票数の場合に追放なしとするかどうか </div>
	 *
	 *            <div lang="en">whether or not executing nobody is allowed</div>
	 */
	public void setEnableNoExecution(boolean isEnableNoExecution) {
		this.isEnableNoExecution = isEnableNoExecution;
	}

	/**
	 * <div lang="ja">Day 0にtalkがあるかどうかを返します。</div>
	 *
	 * <div lang="en">Returns whether or not there are talks on day 0.</div>
	 *
	 * @return <div lang="ja">Day 0にtalkがあるかどうか</div>
	 *
	 *         <div lang="en">whether or not there are talks on day 0</div>
	 */
	public boolean isTalkOnFirstDay() {
		return isTalkOnFirstDay;
	}

	/**
	 *
	 * @return
	 */
	public boolean isEnableRoleRequest() {
		return isEnableRoleRequest;
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
	 * <div lang="ja">発話文字列の違反チェックを行うかどうかを返します。</div>
	 *
	 * <div lang="en">Returns whether or not the text in talk/whisper is validated.</div>
	 *
	 * @return <div lang="ja">発話文字列の違反チェックを行うかどうか</div> <div lang="en">whether or not the text in talk/whisper is
	 *         validated</div>
	 */
	public boolean isValidateUtterance() {
		return isValidateUtterance;
	}

	/**
	 * <div lang="ja">発話文字列の違反チェックを行うかどうかをセットします。</div>
	 *
	 * <div lang="en">Sets whether or not the text in talk/whisper is validated.</div>
	 *
	 * @param isValidateUtterance
	 *            <div lang="ja">発話文字列の違反チェックを行うかどうか</div>
	 *
	 *            <div lang="en">whether or not the text in talk/whisper is validated</div>
	 */
	public void setValidateUtterance(boolean isValidateUtterance) {
		this.isValidateUtterance = isValidateUtterance;
	}

	/**
	 * <div lang="ja">再襲撃投票前にwhisperするかどうかを返します。</div>
	 *
	 * <div lang="en">Returns whether or not there is whisper before the revote for attack.</div> *
	 *
	 * @return <div lang="ja">再襲撃投票前にwhisperするかどうか</div>
	 *
	 *         <div lang="en">whether or not there is whisper before the revote for attack</div>
	 */
	public boolean isWhisperBeforeRevote() {
		return isWhisperBeforeRevote;
	}

	/**
	 * <div lang="ja">再襲撃投票前にwhisperするかどうかをセットします。</div>
	 *
	 * <div lang="en">Sets whether or not there is whisper before the revote for attack.</div> *
	 *
	 * @param isWhisperBeforeRevote
	 *            <div lang="ja">再襲撃投票前にwhisperするかどうか</div>
	 *
	 *            <div lang="en">whether or not there is whisper before the revote for attack</div>
	 */
	public void setWhisperBeforeRevote(boolean isWhisperBeforeRevote) {
		this.isWhisperBeforeRevote = isWhisperBeforeRevote;
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
	 * <div lang="ja">リクエスト応答時間の上限を返す．</div>
	 *
	 * <div lang="en">Returns the time limit for the response to the request.<div>
	 *
	 * @return <div lang="ja">制限時間(ms)あるいは未設定の場合-1</div>
	 *
	 *         <div lang="en">the time limit in millisecond or -1 if this is not set yet<div>
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
	 *            <div lang="ja">制限時間</div>
	 *
	 *            <div lang="en">the timeLimit to set</div>
	 */
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	/**
	 * <div lang="ja">最大再投票回数を返します。</div>
	 *
	 * <div lang="en">Returns the maximum number of revotes.<div>
	 *
	 * @return <div lang="ja">最大再投票回数</div>
	 *
	 *         <div lang="en">the maximum number of revotes<div>
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
	 *            <div lang="ja">最大再投票回数</div>
	 *
	 *            <div lang="en">the maximum number of revotes</div>
	 */
	public void setMaxRevote(int maxRevote) {
		this.maxRevote = maxRevote;
	}

	/**
	 * <div lang="ja">最大再襲撃投票回数を返します。</div>
	 *
	 * <div lang="en">Returns the maximum number of revotes for attack.<div>
	 *
	 * @return <div lang="ja">最大再襲撃投票回数</div>
	 *
	 *         <div lang="en">the maximum number of revotes for attack<div>
	 */
	public int getMaxAttackRevote() {
		return maxAttackRevote;
	}

	/**
	 * <div lang="ja">最大再襲撃投票回数をセットします。</div>
	 *
	 * <div lang="en">Sets the maximum number of revotes for attack.</div>
	 *
	 * @param maxRevote
	 *            <div lang="ja">最大再襲撃投票回数</div>
	 *
	 *            <div lang="en">the maximum number of revotes for attack</div>
	 */
	public void setMaxAttackRevote(int maxAttackRevote) {
		this.maxAttackRevote = maxAttackRevote;
	}

	/**
	 *
	 * @param isEnable
	 */
	public void setEnableRoleRequest(boolean isEnable) {
		isEnableRoleRequest = isEnable;
	}

	/**
	 * <div lang="ja">ゲーム設定の複製を作成し、返します。</div>
	 *
	 * <div lang="en">Create copy.</div>
	 *
	 * @return <div lang="ja">ゲーム設定の複製</div>
	 *
	 *         <div lang="en">Copy of this object</div>
	 */
	@Override
	public GameSetting clone() {
		GameSetting gameSetting = new GameSetting();
		gameSetting.isEnableNoAttack = isEnableNoAttack;
		gameSetting.isVotableInFirstDay = isVotableInFirstDay;
		gameSetting.isVoteVisible = isVoteVisible;
		gameSetting.isEnableNoExecution = isEnableNoExecution;
		gameSetting.isTalkOnFirstDay = isTalkOnFirstDay;
		gameSetting.isValidateUtterance = isValidateUtterance;
		gameSetting.isWhisperBeforeRevote = isWhisperBeforeRevote;
		gameSetting.maxTalk = maxTalk;
		gameSetting.maxWhisper = maxWhisper;
		gameSetting.maxWhisperTurn = maxWhisperTurn;
		gameSetting.maxTalkTurn = maxTalkTurn;
		gameSetting.maxSkip = maxSkip;
		gameSetting.randomSeed = randomSeed;
		gameSetting.timeLimit = timeLimit;
		gameSetting.maxRevote = maxRevote;
		gameSetting.maxAttackRevote = maxAttackRevote;
		gameSetting.roleNumMap.putAll(roleNumMap);
		gameSetting.isEnableRoleRequest = isEnableRoleRequest;
		return gameSetting;
	}

}
