package org.aiwolf.common.data;

import org.aiwolf.common.net.GameInfo;






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
	 * @return
	 */
	void initialize(GameInfo gameInfo);
	
	/**
	 * Called when the day started
	 */
	void dayStart();
	
	/**
	 * Each player can talk thier opinions throw this method
	 * @return
	 */
	String talk();
	
	/**
	 * Each wolves can talk thier opinions throw this method
	 * @return
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
	 * Finalize
	 */
	void finish();
	
	
}
