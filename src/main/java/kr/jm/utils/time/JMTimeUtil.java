package kr.jm.utils.time;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;

public class JMTimeUtil {
	private static final String UTC = "UTC";
	public static final String LONG_FORMAT_WITH_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"; // 2014-03-21T18:31:23.000Z
	public static final String LONG_FORMAT_WITH_PLUS_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"; // 2014-03-21T18:31:23.000+0900
	public static final String LONG_FORMAT_WITH_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSz"; // 2014-03-21T18:31:23.000KST
	public static final String LONG_FORMAT_WITHOUT_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSS"; // 2014-03-21T18:31:23.000
	public static final String SHORT_FORMAT_WITH_PLUS_TIMEZONE = "yyyyMMddHHmmss.SSSZ"; // 20140321183123.000+0900
	public static final String SHORT_FORMAT_WITH_TIMEZONE = "yyyyMMddHHmmss.SSSz"; // 20140321183123.000KST
	public static final String SHORT_FORMAT_WITHOUT_TIMEZONE = "yyyyMMddHHmmss.SSS"; // 20140321183123.000

	public static String getTime(long epochTimestamp) {
		return getTimeAsLongFormatWithTimezone(epochTimestamp);
	}

	public static String getCurrentTimestampInUtc() {
		return getTimeAsDefaultUtcFormat(System.currentTimeMillis());
	}

	public static String getCurrentTimestamp() {
		return getTime(System.currentTimeMillis());
	}

	public static String getCurrentTimestamp(String timeFormat) {
		return getTimeInUTC(System.currentTimeMillis(), timeFormat);
	}

	public static String getCurrentTimestamp(String timeFormat,
			String timeZoneId) {
		return getTime(System.currentTimeMillis(), timeFormat, timeZoneId);
	}

	public static String getTimeAsDefaultUtcFormat(long epochTimestamp) {
		return getTimeInUTC(epochTimestamp, LONG_FORMAT_WITH_Z);
	}

	public static String getTimeAsLongFormatWithPlusTimezone(long epochTimestamp) {
		return getTime(epochTimestamp, LONG_FORMAT_WITH_PLUS_TIMEZONE);
	}

	public static String getTimeAsLongFormatWithTimezone(long epochTimestamp) {
		return getTime(epochTimestamp, LONG_FORMAT_WITH_TIMEZONE);
	}

	public static String getTimeAsLongFormatWithoutTimezone(long epochTimestamp) {
		return getTime(epochTimestamp, LONG_FORMAT_WITHOUT_TIMEZONE);
	}

	public static String getTimeAsShortFormatWithPlusTimezone(
			long epochTimestamp) {
		return getTime(epochTimestamp, SHORT_FORMAT_WITH_PLUS_TIMEZONE);
	}

	public static String getTimeAsShortFormatWithTimezone(long epochTimestamp) {
		return getTime(epochTimestamp, SHORT_FORMAT_WITH_TIMEZONE);
	}

	public static String getTimeAsShortFormatWithoutTimezone(long epochTimestamp) {
		return getTime(epochTimestamp, SHORT_FORMAT_WITHOUT_TIMEZONE);
	}

	public static String getTimeInUTC(long epochTimestamp, String timeFormat) {
		return getTime(epochTimestamp, timeFormat, UTC);
	}

	public static String getTime(long epochTimestamp, String timeFormat) {
		return new SimpleDateFormat(timeFormat).format(epochTimestamp);
	}

	public static String getTime(long epochTimestamp, String timeFormat,
			String timeZoneId) {
		return new DateTime(epochTimestamp, DateTimeZone.forID(timeZoneId))
				.toString(timeFormat);
	}

	public static String changeFormatAndTimeZone(String isoTimestampString,
			String dateFormatString, String timeZoneId) {
		return getTime(changeTimestampStringToLong(isoTimestampString),
				dateFormatString, timeZoneId);
	}

	public static long changeTimestampStringToLong(String isoTimestampString) {
		return ISODateTimeFormat.dateTime().parseDateTime(isoTimestampString)
				.getMillis();
	}

	public static String getYearyyyy(long epochTimestamp) {
		return new SimpleDateFormat("yyyy").format(epochTimestamp);
	}

	public static String getMonthM(long epochTimestamp) {
		return new SimpleDateFormat("M").format(epochTimestamp);
	}

	public static String getMonthMM(long epochTimestamp) {
		return new SimpleDateFormat("MM").format(epochTimestamp);
	}

	public static String getMonthMMM(long epochTimestamp) {
		return new SimpleDateFormat("MMM").format(epochTimestamp);
	}

	public static String getDayd(long epochTimestamp) {
		return new SimpleDateFormat("d").format(epochTimestamp);
	}

	public static String getDaydd(long epochTimestamp) {
		return new SimpleDateFormat("dd").format(epochTimestamp);
	}

	public static String getDayE(long epochTimestamp) {
		return new SimpleDateFormat("E").format(epochTimestamp);
	}

	public static String getDayEEE(long epochTimestamp) {
		return new SimpleDateFormat("EEE").format(epochTimestamp);
	}

	public static String getHourH(long epochTimestamp) {
		return new SimpleDateFormat("H").format(epochTimestamp);
	}

	public static String getHourHH(long epochTimestamp) {
		return new SimpleDateFormat("HH").format(epochTimestamp);
	}

	public static String getHourah(long epochTimestamp) {
		return new SimpleDateFormat("a h").format(epochTimestamp);
	}

	public static String getHourahh(long epochTimestamp) {
		return new SimpleDateFormat("a hh").format(epochTimestamp);
	}

	public static String getHourMinuteHHmm(long epochTimestamp) {
		return new SimpleDateFormat("HH:mm").format(epochTimestamp);
	}

	public static String getHourMinuteSecondHHmmss(long epochTimestamp) {
		return new SimpleDateFormat("HH:mm:ss").format(epochTimestamp);
	}

	public static String getHourMinutehhmma(long epochTimestamp) {
		return new SimpleDateFormat("hh:mm a").format(epochTimestamp);
	}

	public static String getHourMinuteSecondhhmmssa(long epochTimestamp) {
		return new SimpleDateFormat("hh:mm:ss a").format(epochTimestamp);
	}

	public static String getMinutem(long epochTimestamp) {
		return new SimpleDateFormat("m").format(epochTimestamp);
	}

	public static String getMinutemm(long epochTimestamp) {
		return new SimpleDateFormat("mm").format(epochTimestamp);
	}

	public static String getSeconds(long epochTimestamp) {
		return new SimpleDateFormat("s").format(epochTimestamp);
	}

	public static String getSecondss(long epochTimestamp) {
		return new SimpleDateFormat("ss").format(epochTimestamp);
	}

	public static String getTimeZonez(long epochTimestamp) {
		return new SimpleDateFormat("z").format(epochTimestamp);
	}

	public static String getTimeZonezzzz(long epochTimestamp) {
		return new SimpleDateFormat("zzzz").format(epochTimestamp);
	}

	public static String getTimeZoneZ(long epochTimestamp) {
		return new SimpleDateFormat("Z").format(epochTimestamp);
	}

	public static long getTimeMillis(int year, int month, int date,
			int hourOfDay, int minute, int second, int mills, String timeZoneId) {
		return new DateTime(year, month, date, hourOfDay, minute, second,
				mills, DateTimeZone.forID(timeZoneId)).getMillis();
	}

	public static long getTimeMillis(int year, int month, int date,
			int hourOfDay, int minute, int second, String timeZoneId) {
		return getTimeMillis(year, month, date, hourOfDay, minute, second, 0,
				timeZoneId);
	}

	public static long getTimeMillis(int year, int month, int date,
			int hourOfDay, int minute, String timeZoneId) {
		return getTimeMillis(year, month, date, hourOfDay, minute, 0, 0,
				timeZoneId);
	}

	public static long getTimeMillis(int year, int month, int date,
			int hourOfDay, String timeZoneId) {
		return getTimeMillis(year, month, date, hourOfDay, 0, 0, 0, timeZoneId);
	}

	public static long getTimeMillis(int year, int month, int date,
			String timeZoneId) {
		return getTimeMillis(year, month, date, 0, 0, 0, 0, timeZoneId);
	}

	public static long getTimeMillis(int year, int month, String timeZoneId) {
		return getTimeMillis(year, month, 0, 0, 0, 0, 0, timeZoneId);
	}

	public static long getTimeMillis(int year, String timeZoneId) {
		return getTimeMillis(year, 0, 0, 0, 0, 0, 0, timeZoneId);
	}
}
