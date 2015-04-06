package kr.jm.utils.exception;

import java.util.LinkedList;
import java.util.List;

import kr.jm.utils.helper.JMLog;

import org.slf4j.Logger;

public class JMExceptionManager {

	private static final String ERROR_HISTORY_SIZE = "error.history.size";
	static {
		if (!System.getProperties().containsKey(ERROR_HISTORY_SIZE))
			System.setProperty(ERROR_HISTORY_SIZE, "1000");
	}
	private static final int maxQueueSize = new Integer(System.getProperties()
			.get(ERROR_HISTORY_SIZE).toString());

	private static List<ErrorMessageHistory> errorMessageHistoryList = new LinkedList<ErrorMessageHistory>();

	private static long errorCount = 0;

	public static void logExption(Logger log, Exception e, String methodName,
			Object... params) {
		if (params.length > 0)
			JMLog.logExeption(log, e, methodName, params);
		else
			JMLog.logExeption(log, e, methodName);
		recordErrorMessageHistory(e);
		increaseErrorCount();
	}

	public static void logExptionAndCount(Logger log, Exception e,
			String methodName, Object... params) {
		logExption(log, e, methodName, params);
		increaseErrorCount();
	}

	private static void recordErrorMessageHistory(Exception e) {
		if (errorMessageHistoryList.size() >= maxQueueSize)
			errorMessageHistoryList.remove(0);
		errorMessageHistoryList.add(new ErrorMessageHistory(System
				.currentTimeMillis(), e.toString()));
	}

	public static List<ErrorMessageHistory> getErrorMessageHistoryList() {
		return errorMessageHistoryList;
	}

	public static void removeErrorMessgeHistoryList() {
		errorMessageHistoryList.clear();
	}

	public static long getErrorCount() {
		return errorCount;
	}

	public static void initErrorCount() {
		errorCount = 0;
	}

	public static void increaseErrorCount() {
		errorCount++;
	}

}
