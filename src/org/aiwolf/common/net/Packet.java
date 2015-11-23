package org.aiwolf.common.net;

import java.util.List;

import org.aiwolf.common.data.Request;

/**
 * Packet to send data to client
 * @author tori
 */
public class Packet {

	Request request;
	GameInfoToSend gameInfo;
	GameSetting gameSetting;
	List<TalkToSend> talkHistoryList;  
	List<TalkToSend> whisperHistoryList;
	
	public Packet(){
		
	}
	
	public Packet(Request request){
		this.request = request;
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
	public Packet(Request request, GameInfoToSend gameInfoToSend, GameSetting gameSetting) {
		this.request = request;
		this.gameInfo = gameInfoToSend;
		this.gameSetting = gameSetting;
	}
	
	/**
	 * Create Packet with GameInforamtion and Game Setting
	 * @param request
	 * @param gameInfoToSend
	 */
	public Packet(Request request, List<TalkToSend> talkHitoryList, List<TalkToSend> whisperHitoryList) {
		this.request = request;
		this.talkHistoryList = talkHitoryList;
		this.whisperHistoryList = whisperHitoryList;
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

	/**
	 * @return talkHistoryList
	 */
	public List<TalkToSend> getTalkHistoryList() {
		return talkHistoryList;
	}

	/**
	 * @param talkHistoryList セットする talkHistoryList
	 */
	public void setTalkHistoryList(List<TalkToSend> talkHistoryList) {
		this.talkHistoryList = talkHistoryList;
	}

	/**
	 * @return whisperHistoryList
	 */
	public List<TalkToSend> getWhisperHistoryList() {
		return whisperHistoryList;
	}

	/**
	 * @param whisperHistoryList セットする whisperHistoryList
	 */
	public void setWhisperHistoryList(List<TalkToSend> whisperHistoryList) {
		this.whisperHistoryList = whisperHistoryList;
	}

	
//	/**
//	 * 
//	 * @return
//	 */
//	public GameInfo getGameInfo(){
//		return gameInfo;
//	}
	
}
