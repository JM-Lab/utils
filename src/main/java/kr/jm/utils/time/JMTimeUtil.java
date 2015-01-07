package kr.jm.utils.time;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.joda.time.format.ISODateTimeFormat;

public class JMTimeUtil {
	public static final String LONG_FORMAT_WITH_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"; // 2014-03-21T18:31:23.000Z
	public static final String LONG_FORMAT_WITH_PLUS_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"; // 2014-03-21T18:31:23.000+0900
	public static final String LONG_FORMAT_WITH_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSz"; // 2014-03-21T18:31:23.000KST
	public static final String LONG_FORMAT_WITHOUT_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSS"; // 2014-03-21T18:31:23.000
	public static final String SHORT_FORMAT_WITH_PLUS_TIMEZONE = "yyyyMMddHHmmss.SSSZ"; // 20140321183123.000+0900
	public static final String SHORT_FORMAT_WITH_TIMEZONE = "yyyyMMddHHmmss.SSSz"; // 20140321183123.000KST
	public static final String SHORT_FORMAT_WITHOUT_TIMEZONE = "yyyyMMddHHmm.SSS"; // 201403211831.000

	public static String getTime(long timestampInUtc) {
		return getTimeAsLongFormatWithTimezone(timestampInUtc);
	}

	public static String getTimeAsDefaultUtcFormat(long timestampInUtc) {
		return getTimeInUTC(timestampInUtc, LONG_FORMAT_WITH_Z);
	}

	public static String getTimeAsLongFormatWithPlusTimezone(long timestampInUtc) {
		return getTime(timestampInUtc, LONG_FORMAT_WITH_PLUS_TIMEZONE);
	}

	public static String getTimeAsLongFormatWithTimezone(long timestampInUtc) {
		return getTime(timestampInUtc, LONG_FORMAT_WITH_TIMEZONE);
	}

	public static String getTimeAsLongFormatWithoutTimezone(long timestampInUtc) {
		return getTime(timestampInUtc, LONG_FORMAT_WITHOUT_TIMEZONE);
	}

	public static String getTimeAsShortFormatWithPlusTimezone(
			long timestampInUtc) {
		return getTime(timestampInUtc, SHORT_FORMAT_WITH_PLUS_TIMEZONE);
	}

	public static String getTimeAsShortFormatWithTimezone(long timestampInUtc) {
		return getTime(timestampInUtc, SHORT_FORMAT_WITH_TIMEZONE);
	}

	public static String getTimeAsShortFormatWithoutTimezone(long timestampInUtc) {
		return getTime(timestampInUtc, SHORT_FORMAT_WITHOUT_TIMEZONE);
	}

	public static String getTimeInUTC(long timestampInUtc, String timeFormat) {
		return getTime(timestampInUtc, timeFormat, "UTC");
	}

	public static String getTime(long timestampInUtc, String timeFormat) {
		return new SimpleDateFormat(timeFormat).format(timestampInUtc);
	}

	public static String getTime(long timestampInUtc, String timeFormat,
			String idOfTimeZone) {
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		sdf.setTimeZone(TimeZone.getTimeZone(idOfTimeZone));
		return sdf.format(timestampInUtc);
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

	public static String getYearyyyy(long timestamp) {
		return new SimpleDateFormat("yyyy").format(timestamp);
	}

	public static String getMonthM(long timestamp) {
		return new SimpleDateFormat("M").format(timestamp);
	}

	public static String getMonthMM(long timestamp) {
		return new SimpleDateFormat("MM").format(timestamp);
	}

	public static String getMonthMMM(long timestamp) {
		return new SimpleDateFormat("MMM").format(timestamp);
	}

	public static String getDayd(long timestamp) {
		return new SimpleDateFormat("d").format(timestamp);
	}

	public static String getDaydd(long timestamp) {
		return new SimpleDateFormat("dd").format(timestamp);
	}

	public static String getDayE(long timestamp) {
		return new SimpleDateFormat("E").format(timestamp);
	}

	public static String getDayEEE(long timestamp) {
		return new SimpleDateFormat("EEE").format(timestamp);
	}

	public static String getHourH(long timestamp) {
		return new SimpleDateFormat("H").format(timestamp);
	}

	public static String getHourHH(long timestamp) {
		return new SimpleDateFormat("HH").format(timestamp);
	}

	public static String getHourah(long timestamp) {
		return new SimpleDateFormat("a h").format(timestamp);
	}

	public static String getHourahh(long timestamp) {
		return new SimpleDateFormat("a hh").format(timestamp);
	}

	public static String getHourMinuteHHmm(long timestamp) {
		return new SimpleDateFormat("HH:mm").format(timestamp);
	}

	public static String getHourMinuteSecondHHmmss(long timestamp) {
		return new SimpleDateFormat("HH:mm:ss").format(timestamp);
	}

	public static String getHourMinutehhmma(long timestamp) {
		return new SimpleDateFormat("hh:mm a").format(timestamp);
	}

	public static String getHourMinuteSecondhhmmssa(long timestamp) {
		return new SimpleDateFormat("hh:mm:ss a").format(timestamp);
	}

	public static String getMinutem(long timestamp) {
		return new SimpleDateFormat("m").format(timestamp);
	}

	public static String getMinutemm(long timestamp) {
		return new SimpleDateFormat("mm").format(timestamp);
	}

	public static String getSeconds(long timestamp) {
		return new SimpleDateFormat("s").format(timestamp);
	}

	public static String getSecondss(long timestamp) {
		return new SimpleDateFormat("ss").format(timestamp);
	}

	public static String getTimeZonez(long timestamp) {
		return new SimpleDateFormat("z").format(timestamp);
	}

	public static String getTimeZonezzzz(long timestamp) {
		return new SimpleDateFormat("zzzz").format(timestamp);
	}

	public static String getTimeZoneZ(long timestamp) {
		return new SimpleDateFormat("Z").format(timestamp);
	}
}
