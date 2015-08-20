package kr.jm.utils.helper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JMString {

	public static final String EMPTY = "";

	public static final String UNDERBAR = "_";

	public static final String SEMICOLON = ";";

	public static final String COMMA = ",";

	public static final String SPACE = " ";

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

	public static String joiningWithComma(List<String> stringList) {
		return joiningWithDelimeter(COMMA, stringList);
	}

	public static String joiningWithUnderbar(List<String> stringList) {
		return joiningWithDelimeter(UNDERBAR, stringList);
	}

	public static String joiningWithSpace(List<String> stringList) {
		return joiningWithDelimeter(SPACE, stringList);
	}

	public static String joiningWithSemicolon(List<String> stringList) {
		return joiningWithDelimeter(SEMICOLON, stringList);
	}

	public static String joiningWithComma(String... strings) {
		return joiningWithDelimeter(COMMA, strings);
	}

	public static String joiningWithUnderbar(String... strings) {
		return joiningWithDelimeter(UNDERBAR, strings);
	}

	public static String joiningWithSpace(String... strings) {
		return joiningWithDelimeter(SPACE, strings);
	}

	public static String joiningWithSemicolon(String... strings) {
		return joiningWithDelimeter(SEMICOLON, strings);
	}

	public static boolean isNotNullOrEmpty(String string) {
		return !isNullOrEmpty(string);
	}

	public static boolean isNullOrEmpty(String string) {
		return string == null || isEmpty(string);
	}

	public static boolean isEmpty(String string) {
		return EMPTY.equals(string);
	}

	public static Optional<String> getOptional(String string) {
		return Optional.ofNullable(string).filter(s -> !isEmpty(s));
	}

	public static String joining(String... strings) {
		return Arrays.stream(strings).collect(Collectors.joining());
	}

	public static String joiningWithDelimeter(CharSequence delimeter,
			String... strings) {
		return Arrays.stream(strings).collect(Collectors.joining(delimeter));
	}

	public static String joiningWithDelimeter(CharSequence delimeter,
			List<String> stringList) {
		return stringList.stream().collect(Collectors.joining(delimeter));
	}

}
