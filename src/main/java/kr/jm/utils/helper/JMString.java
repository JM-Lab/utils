package kr.jm.utils.helper;

import java.util.List;
import java.util.regex.Pattern;

public class JMString {

	public static final Pattern NUMBER_PATTERN = Pattern
			.compile("[+-]?\\d*(\\.\\d+)?");

	public static final String lineSeperator = System
			.getProperty("line.separator");

	public static boolean isNumber(String numberString) {
		return NUMBER_PATTERN.matcher(numberString).matches();
	}

	public static List<String> splitLineByaLine(String stringByLine) {
		return JMCollections
				.buildListWithDelimeter(stringByLine, lineSeperator);
	}

}
