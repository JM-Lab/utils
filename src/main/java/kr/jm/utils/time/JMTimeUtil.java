package kr.jm.utils.time;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JMTimeUtil {
	public static final String LONG_FORMAT_WITH_PLUS_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ssZ"; // 2014-03-21T18:31:23+0900
	public static final String LONG_FORMAT_WITH_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ssz"; // 2014-03-21T18:31:23KST
	public static final String LONG_FORMAT_WITHOUT_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss"; // 2014-03-21T18:31:23
	public static final String SHORT_FORMAT_WITH_PLUS_TIMEZONE = "yyyyMMddHHmmssZ"; // 20140321183123+0900
	public static final String SHORT_FORMAT_WITH_TIMEZONE = "yyyyMMddHHmmssz"; // 20140321183123KST
	public static final String SHORT_FORMAT_WITHOUT_TIMEZONE = "yyyyMMddHHmm"; // 201403211831

	public static String getTime(long timestampInUtc) {
		return getTimeAsLongFormatWithTimezone(timestampInUtc);
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
		return new SimpleDateFormat(dateFormatString).format(new DateTime(
				isoTimestampString, DateTimeZone.forTimeZone(TimeZone
						.getTimeZone(timeZoneId))).getMillis());
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
