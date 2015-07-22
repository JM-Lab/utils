package kr.jm.utils.helper;

import java.util.List;
import java.util.regex.Pattern;

import kr.jm.utils.AutoStringBuilder;

public class JMString {

	public static final String COMMA = ",";

	public static final Pattern NUMBER_PATTERN = Pattern
			.compile("[+-]?\\d*(\\.\\d+)?");

	public static final String lineSeperator = System
			.getProperty("line.separator");

	public static boolean isNumber(String numberString) {
		return NUMBER_PATTERN.matcher(numberString).matches();
	}

	public static List<String> splitLineByLine(String stringByLine) {
		return JMCollections
				.buildListWithDelimeter(stringByLine, lineSeperator);
	}

	public static String buildCsvString(List<String> stringList) {
		return buildCsvString(stringList.toArray(new String[stringList.size()]));
	}

	public static String buildCsvString(String... strings) {
		return new AutoStringBuilder(COMMA).append(strings).autoToString();
	}

	public static boolean isNullOrEmpty(String keyTypeExpression) {
		return keyTypeExpression == null || "".equals(keyTypeExpression); 
	}
}
