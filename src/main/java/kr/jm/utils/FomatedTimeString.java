package kr.jm.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class FomatedTimeString {

	public static final String LONG_FORMAT_WITH_PLUS_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ssZ"; //2014-03-21T18:31:23+0900
	public static final String LONG_FORMAT_WITH_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ssz"; //2014-03-21T18:31:23KST
	public static final String LONG_FORMAT_WITHOUT_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss"; //2014-03-21T18:31:23
	public static final String SHORT_FORMAT_WITH_PLUS_TIMEZONE = "yyyyMMddHHmmssZ"; //20140321183123+0900
	public static final String SHORT_FORMAT_WITH_TIMEZONE = "yyyyMMddHHmmssz"; //20140321183123KST
	public static final String SHORT_FORMAT_WITHOUT_TIMEZONE = "yyyyMMddHHmm"; //201403211831
	 
	private static final int aSecond = 1000;
	private static final int aMinute = 60 * aSecond;
	private static final int aHour = 60 * aMinute;
	private static final int aDay = 24 * aHour;
	private static final int aWeek = 7 * aDay;

	public static String getTimeInUTC(long timestemp, String timeFormat) {
		return getTime(timestemp, timeFormat, "UTC");
	}

	public static String getTime(long timestamp, String timeFormat,
			String idOfTimeZone) {
		Timestamp ts = new Timestamp(timestamp);
		SimpleDateFormat timeformat = new SimpleDateFormat(timeFormat);
		timeformat.setTimeZone(TimeZone.getTimeZone(idOfTimeZone));
		return timeformat.format(ts);
	}

	public static long getTimestampMinusParemeters(long beforeTimestemp,
			int numOfWeeks, int numOfDays, int numOfHours, int numOfMinutes, int numOfSeconds) {
		long sumOfParemeters = numOfWeeks * aWeek + numOfDays * aDay + numOfHours * aHour
				+ numOfMinutes * aMinute + numOfSeconds * aSecond;
		return beforeTimestemp - sumOfParemeters;
	}
	
	public static long getCurrentTimestampMinusParemeters(int numOfWeeks, int numOfDays, int numOfHours,
			int numOfMinutes, int numOfSeconds) {
		return getTimestampMinusParemeters(System.currentTimeMillis(), numOfWeeks, numOfDays, numOfHours, numOfMinutes, numOfSeconds);
	}
	
	public static long getTimestampMinusSeconds(long beforeTimestemp, int numOfSeconds) {
		return beforeTimestemp - numOfSeconds * aSecond;
	}
	
	public static long getTimestampMinusMinutes(long beforeTimestemp, int numOfMinutes) {
		return beforeTimestemp - numOfMinutes * aMinute;
	}
	
	public static long getTimestampMinusHours(long beforeTimestemp, int numOfHours) {
		return beforeTimestemp - numOfHours * aHour;
	}
	
	public static long getTimestampMinusDays(long beforeTimestemp, int numOfDays) {
		return beforeTimestemp - numOfDays * aDay;
	}
	
	public static long getTimestampMinusWeeks(long beforeTimestemp, int numOfWeeks) {
		return beforeTimestemp - numOfWeeks * aWeek;
	}	

}
