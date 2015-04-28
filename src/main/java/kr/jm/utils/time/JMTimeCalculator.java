package kr.jm.utils.time;

import kr.jm.utils.enums.Milliseconds;

public class JMTimeCalculator {

	private static final long aSecond = Milliseconds.SECOND.getValue();
	private static final long aMinute = Milliseconds.MINUTE.getValue();
	private static final long anHour = Milliseconds.HOUR.getValue();
	private static final long aDay = Milliseconds.DAY.getValue();
	private static final long aWeek = Milliseconds.WEEK.getValue();

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

	public static long getTimestampPlusMinutes(long targetTimestamp,
			int numOfMinutes) {
		return targetTimestamp + numOfMinutes * aMinute;
	}

	public static long getTimestampPlusHours(long targetTimestamp,
			int numOfHours) {
		return targetTimestamp + numOfHours * anHour;
	}

	public static long getTimestampPlusDays(long targetTimestamp, int numOfDays) {
		return targetTimestamp + numOfDays * aDay;
	}

	public static long getTimestampPlusWeeks(long targetTimestamp,
			int numOfWeeks) {
		return targetTimestamp + numOfWeeks * aWeek;
	}

}
