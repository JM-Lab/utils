package kr.jm.utils.enums;

public enum Milliseconds {

	SECOND(1000l), MINUTE(SECOND.getValue() * 60), HOUR(MINUTE.getValue() * 60), DAY(
			HOUR.getValue() * 24), WEEK(DAY.getValue() * 7);

	private long milliseconds;

	private Milliseconds(long milliseconds) {
		this.milliseconds = milliseconds;
	}

	public long getValue() {
		return milliseconds;
	}

}