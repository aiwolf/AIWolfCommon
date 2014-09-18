package org.aiwolf.common.net;

import org.aiwolf.common.data.Request;

/**
 * Packet to send data to client
 * @author tori
 */
public class Packet {

	Request request;
	GameInfoToSend gameInfo;
	GameSettingEntity gameSetting;
	
	public Packet(){
		
	}
	
//	private Packet(Request request, GameInfo gameInfo) {
//		super();
//		this.request = request;
//		this.gameInfo = new GameInfoToSend(gameInfo);
//	}

	/**
	 * Create Packet with GameInformation
	 * @param request
	 * @param gameInfoToSend
	 */
	public Packet(Request request, GameInfoToSend gameInfoToSend) {
		this.request = request;
		this.gameInfo = gameInfoToSend;
	}

	/**
	 * Create Packet with GameInforamtion and Game Setting
	 * @param request
	 * @param gameInfoToSend
	 */
	public Packet(Request request, GameInfoToSend gameInfoToSend, GameSettingEntity gameSetting) {
		this.request = request;
		this.gameInfo = gameInfoToSend;
		this.gameSetting = gameSetting;
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

	public GameSetting getGameSetting() {
		return gameSetting;
	}

//	/**
//	 * 
//	 * @return
//	 */
//	public GameInfo getGameInfo(){
//		return gameInfo;
//	}
	
}
