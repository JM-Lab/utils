package kr.jm.utils;

public class TimeCalculator {

	public static final long aSecond = 1000;
	public static final long aMinute = 60 * aSecond;
	public static final long anHour = 60 * aMinute;
	public static final long aDay = 24 * anHour;
	public static final long aWeek = 7 * aDay;

	public static long getTimestampMinusTimes(long targetTimestamp, long times) {
		return targetTimestamp - times;
	}

	public static long getTimestampMinusParemeters(long targetTimestamp,
			int numOfWeeks, int numOfDays, int numOfHours, int numOfMinutes,
			int numOfSeconds) {
		long sumOfParemeters = numOfWeeks * aWeek + numOfDays * aDay
				+ numOfHours * anHour + numOfMinutes * aMinute + numOfSeconds
				* aSecond;
		return targetTimestamp - sumOfParemeters;
	}

	public static long getCurrentTimestampMinusParemeters(int numOfWeeks,
			int numOfDays, int numOfHours, int numOfMinutes, int numOfSeconds) {
		return getTimestampMinusParemeters(System.currentTimeMillis(),
				numOfWeeks, numOfDays, numOfHours, numOfMinutes, numOfSeconds);
	}

	public static long getTimestampMinusSeconds(long targetTimestamp,
			int numOfSeconds) {
		return targetTimestamp - numOfSeconds * aSecond;
	}

	public static long getTimestampMinusMinutes(long targetTimestamp,
			int numOfMinutes) {
		return targetTimestamp - numOfMinutes * aMinute;
	}

	public static long getTimestampMinusHours(long targetTimestamp,
			int numOfHours) {
		return targetTimestamp - numOfHours * anHour;
	}

	public static long getTimestampMinusDays(long targetTimestamp, int numOfDays) {
		return targetTimestamp - numOfDays * aDay;
	}

	public static long getTimestampMinusWeeks(long targetTimestamp,
			int numOfWeeks) {
		return targetTimestamp - numOfWeeks * aWeek;
	}

}
