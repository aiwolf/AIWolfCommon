package org.aiwolf.common.data;

import org.aiwolf.common.net.GameInfo;
import org.aiwolf.common.net.GameSetting;






/**
 * Player for AI Wolf<br>
 * Implements Player to create Agent for AI Wolf
 * @author tori
 *
 */
public interface Player {
	
	/**
	 * get player name
	 * @return
	 */
	String getName(); 
	
	/**
	 * Called when the game information updated
	 */
	void update(GameInfo gameInfo);
	
	/**
	 * Called when the game started
	 * @param gameInfo information about current game status
	 * @param gameSetting Game settings
	 */
	void initialize(GameInfo gameInfo, GameSetting gameSetting);
	
	/**
	 * Called when the day started
	 */
	void dayStart();
	
	/**
	 * Each player can talk thier opinions throw this method<br>
	 * Return texts must be written in aiwolf protocol.
	 * When you return null, it will be ｃｏｎｓｉｄｅｒｅｄ as SKIP
	 * @return 
	 */
	String talk();
	
	/**
	 * Each wolves can talk thier opinions throw this method<br>
	 * 
	 * @return aiwolf protocol based whisper
	 */
	String whisper();
	
	/**
	 * ExecuteVote agent to execute
	 * @return
	 */
	Agent vote();
	
	/**
	 * Decide agent who to be attacked by wolves
	 * @return
	 */
	Agent attack();
	
	
	/**
	 * Decide agent to divine by Seer
	 * @return
	 */
	Agent divine();
	
	/**
	 * Decide agent to guard by BodyGuard
	 * @return
	 */
	Agent guard();

	/**
	 * Called when the game finished.<br>
	 * Before this method is called, gameinfo is updated with all information.
	 */
	void finish();
	
	
}
