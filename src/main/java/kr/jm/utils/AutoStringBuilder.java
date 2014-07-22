package kr.jm.utils;

public class AutoStringBuilder {

	private String autoAppendingString;

	private StringBuilder sb;

	public AutoStringBuilder(String autoAppendingString) {
		this.autoAppendingString = autoAppendingString;
		sb = new StringBuilder();
	}

	public AutoStringBuilder append(String string) {
		sb.append(string).append(autoAppendingString);
		return this;
	}

	public AutoStringBuilder append(String... strings) {
		for (String s : strings) {
			sb.append(s);
		}
		sb.append(autoAppendingString);
		return this;
	}

	public StringBuilder getStringBuilder() {
		return sb;
	}

	public AutoStringBuilder removeLastAutoAppendingString() {
		sb = sb.delete(sb.length() - autoAppendingString.length(), sb.length());
		return this;
	}

	public String autoToString() {
		return removeLastAutoAppendingString().toString();
	}

	public String toString() {
		return sb.toString();
	}

}
