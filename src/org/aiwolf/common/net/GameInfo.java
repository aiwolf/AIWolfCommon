package org.aiwolf.common.net;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Judge;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Status;
import org.aiwolf.common.data.Talk;
import org.aiwolf.common.data.Vote;

/**
 * <div lang="ja">
 * 
 * 各プレイヤーに送信されるゲーム情報です。
 * 
 * </div>
 * 
 * <div lang="en">
 * 
 * Game information which send to each player.
 * 
 * </div>
 * 
 * @author tori
 *
 */
public class GameInfo {

	int day;
	Agent agent;
	// TODO コメントアウトされたフィールド・メンバ
	// Role role;

	Judge mediumResult;
	Judge divineResult;
	Agent banishedAgent;

	// the agent werewolves attacked last night (werewolf only)
	Agent attackedAgent;
	Agent guardedAgent;
	List<Vote> voteList;
	List<Vote> attackVoteList;

	List<Talk> talkList;
	List<Talk> whisperList;

	// TODO コメントアウトされたフィールド・メンバ
	// List<Agent> wolfList;
	// List<Agent> humanList;
	// List<Agent> aliveAgentList;

	Map<Agent, Status> statusMap;
	Map<Agent, Role> roleMap;

	/**
	 * 
	 */
	List<Role> existingRoleList;
	
	// TODO コメントアウトされたフィールド・メンバ
	// List<Agent> agentList;

	List<Agent> lastDeadAgentList; // The list of agents died last night.

	/**
	 * <div lang="ja">新しいゲーム情報を構築します。</div>
	 * 
	 * <div lang="en">Create new game infomation.</div>
	 */
	public GameInfo() {
		voteList = new ArrayList<>();
		attackVoteList = new ArrayList<>();
		talkList = new ArrayList<>();
		whisperList = new ArrayList<>();
		statusMap = new HashMap<>();
		roleMap = new HashMap<>();
		// TODO コメントアウトされた初期化
		// agentList = new ArrayList<>();
		lastDeadAgentList = new ArrayList<>();
	}

	/**
	 * <div lang="ja">何日かを返します。</div>
	 * 
	 * <div lang="en">Get the day.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">このゲーム情報の日付</div>
	 * 
	 *         <div lang="en">Day</div>
	 */
	public int getDay() {
		return day;
	}

	/**
	 * <div lang="ja">プレイヤーの役職を返します。</div>
	 * 
	 * <div lang="en">Get player's role.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">プレイヤーの役職</div>
	 * 
	 *         <div lang="en">Role</div>
	 */
	public Role getRole() {
		return roleMap.get(getAgent());
	}

	/**
	 * <div lang="ja">自分自身のエージェントを返します。</div>
	 * 
	 * <div lang="en">Get yourself.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">自分自身のエージェント</div>
	 * 
	 *         <div lang="en">Agent, yourself</div>
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * <div lang="ja">
	 * 
	 * ゲームに参加しているエージェントのリストを返します。
	 * 
	 * </div>
	 * 
	 * <div lang="en">Get agents.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">エージェントのリスト</div>
	 * 
	 *         <div lang="en">Agents list</div>
	 */
	public List<Agent> getAgentList() {
		return new ArrayList<>(statusMap.keySet());
	}

	// TODO 霊能者以外はnull? 確認が取れ次第、ドキュメントに追記
	/**
	 * <div lang="ja">
	 * 
	 * 霊能結果を返します。霊能者のみが確認できます。
	 * 
	 * </div>
	 * 
	 * <div lang="en">Result of medium. Medium only.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">霊能結果</div>
	 * 
	 *         <div lang="en">Result of medium</div>
	 */
	public Judge getMediumResult() {
		return mediumResult;
	}

	// TODO 占い師以外はnull? 確認が取れ次第ドキュメントに追記
	/**
	 * <div lang="ja">
	 * 
	 * 占い結果を返します。占い師のみが確認できます。
	 * 
	 * </div>
	 * 
	 * <div lang="en">Result of the divine. Seer only.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">占い結果</div>
	 * 
	 *         <div lang="en">Result of the divine</div>
	 */
	public Judge getDivineResult() {
		return divineResult;
	}

	/**
	 * <div lang="ja">
	 * 
	 * 昨夜追放されたエージェントを返します．
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Get the agent who banished last night.
	 * 
	 * </div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">昨夜追放されたエージェント</div>
	 * 
	 *         <div lang="en">the agent who banished last night</div>
	 */
	public Agent getBanishedAgent() {
		return banishedAgent;
	}

	/**
	 * <div lang="ja">
	 * 
	 * 昨夜実際に襲撃されたエージェントを返します．人狼以外には知らされません．
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Returns the agent actually attacked last night.
	 * 
	 * </div>
	 * 
	 * @return <div lang="ja">昨夜実際に襲撃されたエージェント</div>
	 * 
	 *         <div lang="en">the agent actually attacked last night</div>
	 */
	public Agent getAttackedAgent() {
		return attackedAgent;
	}

	/**
	 * <div lang="ja">
	 * 
	 * 昨夜に護衛されたエージェントを返します。
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Get the agent who guarded last night.
	 * 
	 * </div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">昨夜に護衛されたエージェント</div>
	 * 
	 *         <div lang="en">Agent who guarded last night</div>
	 */
	public Agent getGuardedAgent() {
		return guardedAgent;
	}

	/**
	 * <div lang="ja">
	 * 
	 * 投票のリストを返します。
	 * 
	 * このリストから、誰が誰に投票したかを見ることができます。
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Get the vote list. You can find who vote to who.
	 * 
	 * </div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">投票のリスト</div>
	 * 
	 *         <div lang="en">Vote list</div>
	 */
	public List<Vote> getVoteList() {
		return voteList;
	}

	// TODO 人狼以外はnull? 確認が取れ次第ドキュメントに追記
	/**
	 * <div lang="ja">
	 * 
	 * 襲撃投票のリストを返します。人狼のみが確認できます。
	 * 
	 * </div>
	 * 
	 * <div lang="en">Attack vote list. Werewolf only.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">襲撃投票のリスト</div>
	 * 
	 *         <div lang="en">Attack vote list</div>
	 */
	public List<Vote> getAttackVoteList() {
		return attackVoteList;
	}

	/**
	 * <div lang="ja">今日の会話を返します。</div>
	 * 
	 * <div lang="en">Get today's talks.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">今日の会話</div>
	 * 
	 *         <div lang="en">Today's talks</div>
	 */
	public List<Talk> getTalkList() {
		return talkList;
	}

	// TODO 人狼以外はnull? 確認が取れ次第ドキュメントに追記
	/**
	 * <div lang="ja">
	 * 
	 * 今日のささやきを返します。人狼のみが確認できます。
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Get today's whispers. Werewolf only.
	 * 
	 * </div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">今日のささやき</div>
	 * 
	 *         <div lang="en">Today's whispers</div>
	 */
	public List<Talk> getWhisperList() {
		return whisperList;
	}

	// TODO コメントアウトされたメソッド
	/**
	 * <div lang="ja">
	 * 
	 * 人間エージェントを返します。<br>
	 * プレイヤーが人狼の場合は、人間であるエージェントを返します。
	 * 
	 * プレイヤーが人間の場合は、すべてのエージェントを返します。
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Get human agents. Werewolf only.<br>
	 * Returns all agents if you are human.
	 * 
	 * </div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">
	 * 
	 *         プレイヤーが人狼であれば、人間であるエージェント。
	 * 
	 *         そうでない場合は、すべてのエージェント
	 * 
	 *         </div>
	 * 
	 *         <div lang="en">
	 * 
	 *         Human agents
	 * 
	 *         </div>
	 */
	// public List<Agent> getHumanList() {
	// List<Agent> humanList = new ArrayList<>(getAgentList());
	// humanList.removeAll(getWolfList());
	// return humanList;
	// }

	// TODO コメントアウトされたメソッド
	/**
	 * <div lang="ja">
	 * 
	 * 人狼エージェントを返します。<br>
	 * プレイヤーが人狼の場合は、人狼であるエージェントを返します。
	 * 
	 * プレイヤーが人間の場合は、空のリストを返します。
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Get werewolves. Werewolf only.<br>
	 * Return empty list if you are human.
	 * 
	 * </div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">
	 * 
	 *         プレイヤーが人狼であれば、人狼であるエージェント。
	 * 
	 *         そうでない場合は、空のリスト
	 * 
	 *         </div>
	 * 
	 *         <div lang="en">
	 * 
	 *         Werewolfs
	 * 
	 *         </div>
	 */
	// public List<Agent> getWolfList() {
	// List<Agent> wolfList = new ArrayList<>();
	// for (Agent agent : roleMap.keySet()) {
	// if (roleMap.get(agent) == Role.WEREWOLF) {
	// wolfList.add(agent);
	// }
	// }
	// return wolfList;
	// }

	/**
	 * <div lang="ja">生きているエージェントを返します。</div>
	 * 
	 * <div lang="en">Get agents who are aliving now.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">生きているエージェント</div>
	 * 
	 *         <div lang="en">Alive agents</div>
	 */
	public List<Agent> getAliveAgentList() {
		List<Agent> aliveAgentList = new ArrayList<>();
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
	 * <div lang="ja">すべてのエージェントの状態を返します。</div>
	 * 
	 * <div lang="en">Get statuses of all agents.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">すべてのエージェントの状態</div>
	 * 
	 *         <div lang="en">Statuses of all agents</div>
	 */
	public Map<Agent, Status> getStatusMap() {
		return statusMap;
	}

	/**
	 * <div lang="ja">
	 * 
	 * 分かっているエージェントの役職を返します。<br>
	 * プレイヤーが人間の場合は、 自分自身のエージェントのみを返します。
	 * 
	 * プレイヤーが人狼の場合は、 自分と他の人狼のエージェントを返します。
	 * 
	 * </div>
	 * 
	 * <div lang="ja">
	 * 
	 * Get known roles of agents.<br>
	 * if you are human, you know only yourself.
	 * 
	 * if you werewolf, you know other werewolves.
	 * 
	 * </div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">
	 * 
	 *         人間ならば自分自身を、
	 * 
	 *         そうでない場合は自分と他の人狼エージェント
	 * 
	 *         </div>
	 * 
	 *         <div lang="en">
	 * 
	 *         Known roles of agents
	 * 
	 *         </div>
	 */
	public Map<Agent, Role> getRoleMap() {
		return roleMap;
	}

	/**
	 * <div lang="ja"> 昨夜死亡したエージェントのリストを返す </div> <div lang="en"> Returns the list of the agents died last night. </div>
	 * 
	 * @return <div lang="ja">昨夜死亡したエージェントのリスト</div> <div lang="en">the list of the agents died last night</div>
	 */
	public List<Agent> getLastDeadAgentList() {
		return lastDeadAgentList;
	}
	
	/**
	 * <div lang="ja"> 存在するRoleを返す </div> <div lang="en"> Returns the roles that existing in this game. </div>
	 * 
	 * @return <div lang="ja">存在するRoleのリスト</div> <div lang="en">the list of the roles</div>
	 */
	public List<Role> getExistingRoles(){
		return existingRoleList;
	}
}
