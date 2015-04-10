package kr.jm.utils.helper;

import java.util.Collection;

import kr.jm.utils.AutoStringBuilder;

import org.slf4j.Logger;

public class JMLog {

	static public void logMethodStartInfo(Logger log, String methodName) {
		log.info(buildMethodLogString(methodName));
	}

	static public void logMethodStartInfo(Logger log, String methodName,
			Object... params) {
		log.info(buildMethodLogString(methodName, params));
	}

	static public void logMethodStartInfoAndDebug(Logger log,
			String methodName, Object... params) {
		int length = params.length;
		Object[] newParams = new Object[length];
		boolean hasCollection = false;
		for (int i = 0; i < length; i++) {
			if (params[i] instanceof Collection) {
				newParams[i] = (((Collection<?>) params[i]).size());
				hasCollection = true;
			} else
				newParams[i] = params[i];
		}
		if (hasCollection)
			log.info(buildMethodLogString(methodName, newParams));
		log.debug(buildMethodLogString(methodName, params));
	}

	static public void logException(Logger log, Exception exeption,
			String methodName) {
		log.error(buildMethodLogString(methodName), exeption);
	}

	static public void logException(Logger log, Exception exeption,
			String methodName, Object... params) {
		log.error(buildMethodLogString(methodName, params), exeption);
	}

	private static String buildMethodLogString(String methodName) {
		return methodName + "()";
	}

	private static String buildMethodLogString(String methodName,
			Object[] params) {
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

	public static void logMethodStartDebug(Logger log, String methodName,
			Object... params) {
		log.debug(buildMethodLogString(methodName, params));
	}

	public static void logMethodStartDebug(Logger log, String methodName) {
		log.debug(buildMethodLogString(methodName));
	}

	public static void logMethodStartWarn(Logger log, String methodName,
			Object... params) {
		log.warn(buildMethodLogString(methodName, params));
	}

	public static void logMethodStartWarn(Logger log, String methodName) {
		log.warn(buildMethodLogString(methodName));
	}

}
