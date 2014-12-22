package kr.jm.utils.time;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class JMTimeUtilTest {

	private static final String TIMESTAME1 = "2014-09-26T06:36:09.327Z";
	private static final String TIMESTAME2 = "2014-09-26T15:36:09.327Z";
	private static final String TIMESTAME3 = "2014-09-26T23:59:59.999Z";
	private static final String TIMESTAME4 = "2014-09-26T15:00:00.000Z";
	private static final String TIMESTAME5 = "2014-09-26T14:59:59.999Z";
	private static final String TIME_ZONE_ID = "Asia/Seoul"; // GMT, UTC
	private static final String INDEX_FORMAT = "yyyy.MM.dd";

	private final long timestamp = 1395394283524l;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testChangeFormatAndTimeZone() {
		System.out.println(JMTimeUtil.changeFormatAndTimeZone(TIMESTAME1,
				INDEX_FORMAT, TIME_ZONE_ID));
		assertTrue("2014.09.26".equals(JMTimeUtil.changeFormatAndTimeZone(
				TIMESTAME1, INDEX_FORMAT, TIME_ZONE_ID)));
		System.out.println(JMTimeUtil.changeFormatAndTimeZone(TIMESTAME2,
				INDEX_FORMAT, TIME_ZONE_ID));
		assertTrue("2014.09.27".equals(JMTimeUtil.changeFormatAndTimeZone(
				TIMESTAME2, INDEX_FORMAT, TIME_ZONE_ID)));
		System.out.println(JMTimeUtil.changeFormatAndTimeZone(TIMESTAME3,
				INDEX_FORMAT, TIME_ZONE_ID));
		assertTrue("2014.09.27".equals(JMTimeUtil.changeFormatAndTimeZone(
				TIMESTAME3, INDEX_FORMAT, TIME_ZONE_ID)));
		System.out.println(JMTimeUtil.changeFormatAndTimeZone(TIMESTAME4,
				INDEX_FORMAT, TIME_ZONE_ID));
		assertTrue("2014.09.27".equals(JMTimeUtil.changeFormatAndTimeZone(
				TIMESTAME4, INDEX_FORMAT, TIME_ZONE_ID)));
		System.out.println(JMTimeUtil.changeFormatAndTimeZone(TIMESTAME5,
				INDEX_FORMAT, TIME_ZONE_ID));
		assertTrue("2014.09.26".equals(JMTimeUtil.changeFormatAndTimeZone(
				TIMESTAME5, INDEX_FORMAT, TIME_ZONE_ID)));

		System.out.println(JMTimeUtil.getTime(timestamp,
				JMTimeUtil.LONG_FORMAT_WITH_PLUS_TIMEZONE, "Asia/Seoul"));
		System.out.println(JMTimeUtil.getTime(timestamp,
				JMTimeUtil.LONG_FORMAT_WITH_TIMEZONE, "Asia/Seoul"));
		System.out.println(JMTimeUtil.getTime(timestamp,
				JMTimeUtil.LONG_FORMAT_WITHOUT_TIMEZONE, "Asia/Seoul"));
		System.out.println(JMTimeUtil.getTime(timestamp,
				JMTimeUtil.SHORT_FORMAT_WITH_PLUS_TIMEZONE, "Asia/Seoul"));
		System.out.println(JMTimeUtil.getTime(timestamp,
				JMTimeUtil.SHORT_FORMAT_WITH_TIMEZONE, "Asia/Seoul"));
		System.out.println(JMTimeUtil.getTime(timestamp,
				JMTimeUtil.SHORT_FORMAT_WITHOUT_TIMEZONE, "Asia/Seoul"));

	}

}
