package org.aiwolf.common.net;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.arnx.jsonic.JSON;

import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Request;

/**
 * AIWolfのObjectを送信形式にEncode,Decodeする．<br>
 * Singleton
 * @author tori
 *
 */
public class DataConverter {
	private static DataConverter converter;

	/**
	 * 唯一のConverterを取得するクラス
	 * @return
	 */
	static public DataConverter getInstance(){
		if(converter == null){
			converter = new DataConverter();
		}
		return converter;
	}
	
	private DataConverter() {
	}
	
	public String convert(Object obj){
//		System.out.println(obj);
		return JSON.encode(obj);
	}
	
	public Packet toPacket(String line){
    	LinkedHashMap<String, Object> map = JSON.decode(line);
    	
    	Request request = Request.valueOf((String)map.get("request"));
    	GameInfoToSend gameInfoToSend = JSON.decode(JSON.encode(map.get("gameInfo")), GameInfoToSend.class);
    	if(map.get("gameSetting") != null){
    		GameSetting gameSetting = JSON.decode(JSON.encode(map.get("gameSetting")), GameSetting.class);
        	return new Packet(request, gameInfoToSend, gameSetting);
    	}else{
        	return new Packet(request, gameInfoToSend);
    	}
	}

	@SuppressWarnings("rawtypes")
	public Agent toAgent(Object obj) {
		if(obj == null){
			return null;
		}
		if(obj instanceof String){
			Matcher m = Pattern.compile("\\{\"agentIdx\":(\\d+)\\}").matcher((String)obj);
			if(m.find()){
				return Agent.getAgent(Integer.parseInt(m.group(1)));
			}
		}
		if(obj instanceof Agent){
			return (Agent)obj;
		}
		else if(obj instanceof Map){
			return Agent.getAgent(((BigDecimal)((Map)obj).get("agentIdx")).intValue());
		}
		else{
			throw new RuntimeException("Can not convert to agent "+obj.getClass()+"\t"+obj );
//			return JSON.decode(JSON.encode(obj), Agent.class);
		}
	}
	
}
