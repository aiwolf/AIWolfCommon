package org.aiwolf.common.data;

import org.aiwolf.common.net.GameInfo;
import org.aiwolf.common.net.GameSetting;

/**
 * <div lang="ja">
 * 
 * 人狼知能のプレイヤーです。<br>
 * 人狼知能のエージェントを作成するには、このPlayerインタフェースを実装してください。
 * 
 * </div>
 * 
 * <div lang="en">
 * 
 * Player for AI Wolf<br>
 * Implements player to create Agent for AI Wolf
 * 
 * </div>
 * 
 * @author tori
 *
 */
public interface Player {

	/**
	 * <div lang="ja">プレイヤーの名前を返します。</div>
	 * 
	 * <div lang="en">Get the player name.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">プレイヤーの名前</div>
	 * 
	 *         <div lang="en">Player name</div>
	 */
	String getName();

	/**
	 * <div lang="ja">ゲームの情報が更新されたときに呼び出されます。</div>
	 * 
	 * <div lang="en">Called when the game information updated.</div>
	 * 
	 * @param gameInfo
	 *            <div lang="ja">ゲームの情報</div>
	 * 
	 *            <div lang="en">Information of game</div>
	 */
	void update(GameInfo gameInfo);

	/**
	 * <div lang="ja">ゲーム開始時に呼び出されます。</div>
	 * 
	 * <div lang="en">Called when the game started.</div>
	 * 
	 * @param gameInfo
	 * 
	 *            <div lang="ja">ゲームの情報</div>
	 * 
	 *            <div lang="en">Game informations</div>
	 * @param gameSetting
	 * 
	 *            <div lang="ja">ゲームの設定</div>
	 * 
	 *            <div lang="en">Game settings</div>
	 */
	void initialize(GameInfo gameInfo, GameSetting gameSetting);

	/**
	 * <div lang="ja">1日の始まりに呼び出されます。</div>
	 * 
	 * <div lang="en">Called when the day started.</div>
	 */
	void dayStart();

	/**
	 * <div lang="ja">
	 * 
	 * 各プレイヤーはこのメソッドに意見を返すことで会話することができます。<br>
	 * 戻り値の文字列は人狼知能プロトコルに沿ったものにする必要があります。 nullを返した場合は、SKIPとみなされます。
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Each player can talk their opinions throw this method.<br>
	 * Return texts must be written in aiwolf protocol. When you return null, it
	 * will be considered as SKIP.
	 * 
	 * </div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">人狼知能プロトコルをもとにした発言</div>
	 * 
	 *         <div lang="en">Aiwolf protocol based talk</div>
	 */
	String talk();

	/**
	 * <div lang="ja">
	 * 
	 * 各人狼はこのメソッドに意見を返すことで人狼同士での会話ができます。
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Each wolves can talk thier opinions throw this method.
	 * 
	 * </div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">人狼知能プロトコルをもとにしたささやき</div>
	 * 
	 *         <div lang="en">Aiwolf protocol based whisper</div>
	 */
	String whisper();

	/**
	 * <div lang="ja">追放したいエージェントに投票します。</div>
	 * 
	 * <div lang="en">Vote agent to execute.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">投票したいエージェント</div>
	 * 
	 *         <div lang="en">Agent of vote target</div>
	 */
	Agent vote();

	/**
	 * <div lang="ja">人狼によって、襲撃したいエージェントを決めます。</div>
	 * 
	 * <div lang="en">Decide agent who to be attacked by wolves.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">襲撃したいエージェント</div>
	 * 
	 *         <div lang="en">Agent of attack target.</div>
	 */
	Agent attack();

	/**
	 * <div lang="ja">占い師によって、占うエージェントを決めます。</div>
	 * 
	 * <div lang="en">Dicide agent to divine by Seer.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">占うエージェント</div>
	 * 
	 *         <div lang="en">Agent of divine target</div>
	 */
	Agent divine();

	/**
	 * <div lang="ja">狩人によって、護衛するエージェントを決めます。</div>
	 * 
	 * <div lang="en">Dicide agent to guard by BodyGuard.</div>
	 * 
	 * @return
	 * 
	 * 		<div lang="ja">護衛するエージェント</div>
	 * 
	 *         <div lang="en">Agent of guard target</div>
	 */
	Agent guard();

	/**
	 * <div lang="ja">
	 * 
	 * ゲーム終了時に呼び出されます。<br>
	 * このメソッドが呼び出される前に、ゲームの情報のすべての情報は更新されます。
	 * 
	 * </div>
	 * 
	 * <div lang="en">
	 * 
	 * Called when the game finished.<br>
	 * Before this method is called, gameinfo is updated with all information.
	 * 
	 * </div>
	 */
	void finish();
}
