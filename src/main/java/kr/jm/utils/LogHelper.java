package kr.jm.utils;

import org.slf4j.Logger;

public class LogHelper {
	static public void logMethodStartInfo(Logger log, String methodName) {
		log.info(methodName + "()");
	}

	static public void logMethodStartInfo(Logger log, String methodName,
			Object... params) {
		log.info(buildMethodLogString(methodName, params));
	}

	static public void logExeption(Logger log, Exception exeption,
			String methodName, Object... params) {
		log.error(buildMethodLogString(methodName, params), exeption);
	}

	private static String buildMethodLogString(String methodName,
			Object... params) {
		AutoStringBuilder logASB = new AutoStringBuilder(", ");
		logASB.getStringBuilder().append(methodName).append("(");
		for (Object param : params) {
			if (param == null)
				logASB.append("null");
			else
				logASB.append(param.toString());
		}
		String finalLogString = logASB.removeLastAutoAppendingString()
				.getStringBuilder().append(")").toString();
		return finalLogString;
	}
}
