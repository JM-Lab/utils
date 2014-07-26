package kr.jm.utils.enums;

import java.io.File;

import org.junit.Test;

public class OSTest {

	private static final String FILE_PATH = "";

	@Test
	public void test() {
		OS.getOs().open(new File(FILE_PATH));
	}

}
