package kr.jm.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class FormatedTimeString {

	public static final String LONG_FORMAT_WITH_PLUS_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ssZ"; //2014-03-21T18:31:23+0900
	public static final String LONG_FORMAT_WITH_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ssz"; //2014-03-21T18:31:23KST
	public static final String LONG_FORMAT_WITHOUT_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss"; //2014-03-21T18:31:23
	public static final String SHORT_FORMAT_WITH_PLUS_TIMEZONE = "yyyyMMddHHmmssZ"; //20140321183123+0900
	public static final String SHORT_FORMAT_WITH_TIMEZONE = "yyyyMMddHHmmssz"; //20140321183123KST
	public static final String SHORT_FORMAT_WITHOUT_TIMEZONE = "yyyyMMddHHmm"; //201403211831
	 
	public static final long aSecond = 1000;
	public static final long aMinute = 60 * aSecond;
	public static final long anHour = 60 * aMinute;
	public static final long aDay = 24 * anHour;
	public static final long aWeek = 7 * aDay;

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

	public static long getTimestampMinusParemeters(long targetTimestemp,
			int numOfWeeks, int numOfDays, int numOfHours, int numOfMinutes, int numOfSeconds) {
		long sumOfParemeters = numOfWeeks * aWeek + numOfDays * aDay + numOfHours * anHour
				+ numOfMinutes * aMinute + numOfSeconds * aSecond;
		return targetTimestemp - sumOfParemeters;
	}
	
	public static long getTimestampMinusTimes(long targetTimestemp, long times) {
		return targetTimestemp - times;
	}
	
	public static long getCurrentTimestampMinusParemeters(int numOfWeeks, int numOfDays, int numOfHours,
			int numOfMinutes, int numOfSeconds) {
		return getTimestampMinusParemeters(System.currentTimeMillis(), numOfWeeks, numOfDays, numOfHours, numOfMinutes, numOfSeconds);
	}
	
	public static long getTimestampMinusSeconds(long targetTimestemp, int numOfSeconds) {
		return targetTimestemp - numOfSeconds * aSecond;
	}
	
	public static long getTimestampMinusMinutes(long targetTimestemp, int numOfMinutes) {
		return targetTimestemp - numOfMinutes * aMinute;
	}
	
	public static long getTimestampMinusHours(long targetTimestemp, int numOfHours) {
		return targetTimestemp - numOfHours * anHour;
	}
	
	public static long getTimestampMinusDays(long targetTimestemp, int numOfDays) {
		return targetTimestemp - numOfDays * aDay;
	}
	
	public static long getTimestampMinusWeeks(long targetTimestemp, int numOfWeeks) {
		return targetTimestemp - numOfWeeks * aWeek;
	}	

}
