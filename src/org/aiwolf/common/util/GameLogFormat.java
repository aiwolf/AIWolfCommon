package org.aiwolf.common.util;

import java.util.logging.Formatter;

import java.util.logging.LogRecord;

public class GameLogFormat extends Formatter {
	public GameLogFormat() {
	}
	
	@Override
	public String format(LogRecord record) {
		final StringBuffer buf = new StringBuffer();
		buf.append(record.getMessage());
		buf.append("\n");

		return buf.toString();
	}

}
