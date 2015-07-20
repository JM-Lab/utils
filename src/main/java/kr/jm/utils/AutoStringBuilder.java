package kr.jm.utils;

public class AutoStringBuilder {

	private String autoAppendingString;

	private StringBuilder sb;

	public AutoStringBuilder(String autoAppendingString) {
		this.autoAppendingString = autoAppendingString;
		sb = new StringBuilder();
	}

	public AutoStringBuilder appendOnlyNotNullAndEmpty(
			Object... appendingObjects) {
		for (Object object : appendingObjects)
			if (object != null && !"".equals(object))
				this.append(object.toString());
		return this;
	}

	public AutoStringBuilder append(String string) {
		sb.append(string).append(autoAppendingString);
		return this;
	}

	public AutoStringBuilder append(String... strings) {
		for (String s : strings)
			append(s);
		return this;
	}

	public AutoStringBuilder append(Object object) {
		sb.append(object.toString()).append(autoAppendingString);
		return this;
	}

	public AutoStringBuilder append(Object... objects) {
		for (Object o : objects)
			append(o);
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
