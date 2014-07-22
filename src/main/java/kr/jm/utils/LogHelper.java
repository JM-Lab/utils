package kr.jm.utils;

import org.slf4j.Logger;

public class LogHelper {
	static public void logMethodStartInfo(Logger log, String methodName) {
		log.info(methodName + "()");
	}

	static public void logMethodStartInfoWithParams(Logger log,
			String methodName, Object... params) {
		StringBuilder logStringBuilder = new StringBuilder();
		logStringBuilder.append(methodName).append("(");
		for (Object param : params) {
			logStringBuilder.append(param.toString());
			logStringBuilder.append(", ");
		}
		log.info(logStringBuilder.substring(0, logStringBuilder.length() - 2)
				+ ")");
	}
}
