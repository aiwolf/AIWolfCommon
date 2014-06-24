package org.aiwolf.common.net;

import org.aiwolf.common.data.Request;

/**
 * Packet to send data to client
 * @author tori
 */
public class Packet {

	Request request;
	GameInfoToSend gameInfo;
	
	public Packet(){
		
	}
	
//	private Packet(Request request, GameInfo gameInfo) {
//		super();
//		this.request = request;
//		this.gameInfo = new GameInfoToSend(gameInfo);
//	}

	public Packet(Request request, GameInfoToSend gameInfoToSend) {
		this.request = request;
		this.gameInfo = gameInfoToSend;
	}

	/**
	 * @return request
	 */
	public Request getRequest() {
		return request;
	}
	/**
	 * @param request セットする request
	 */
	public void setRequest(Request request) {
		this.request = request;
	}
	/**
	 * @return value
	 */
	public GameInfoToSend getGameInfo() {
		return gameInfo;
	}
	
	/**
	 * @param gameInfo セットする value
	 */
	public void setGameInfo(GameInfoToSend gameInfo) {
		this.gameInfo = gameInfo;
	}

//	/**
//	 * 
//	 * @return
//	 */
//	public GameInfo getGameInfo(){
//		return gameInfo;
//	}
	
}
