package kr.jm.utils;

import org.junit.Test;

public class FomatedTimeStringTest {

	private final long timestamp = 1395394283524l;

	@Test
	public void testFomatedTimeString() {

		FormatedTimeString fts = new FormatedTimeString();
		System.out.println(fts.getTime(timestamp,
				fts.LONG_FORMAT_WITH_PLUS_TIMEZONE, "Asia/Seoul"));
		System.out.println(fts.getTime(timestamp,
				fts.LONG_FORMAT_WITH_TIMEZONE, "Asia/Seoul"));
		System.out.println(fts.getTime(timestamp,
				fts.LONG_FORMAT_WITHOUT_TIMEZONE, "Asia/Seoul"));
		System.out.println(fts.getTime(timestamp,
				fts.SHORT_FORMAT_WITH_PLUS_TIMEZONE, "Asia/Seoul"));
		System.out.println(fts.getTime(timestamp,
				fts.SHORT_FORMAT_WITH_TIMEZONE, "Asia/Seoul"));
		System.out.println(fts.getTime(timestamp,
				fts.SHORT_FORMAT_WITHOUT_TIMEZONE, "Asia/Seoul"));
	}

}
