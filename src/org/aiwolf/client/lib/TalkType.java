/**
 * TalkTypr.java
 * 
 * Copyright (c) 2016 人狼知能プロジェクト
 */
package org.aiwolf.client.lib;

/**
 * @author otsuki
 *
 */
public enum TalkType {
	TALK, WHISPER;

	public static TalkType parseTalkType(String input) {
		if (input.equalsIgnoreCase("talk")) {
			return TALK;
		} else if (input.equalsIgnoreCase("whisper")) {
			return WHISPER;
		} else {
			return null;
		}
	}
}
