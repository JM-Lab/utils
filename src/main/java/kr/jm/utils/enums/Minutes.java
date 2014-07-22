package kr.jm.utils.enums;

public enum Minutes {

	MINUTE(1), HOUR(MINUTE.getValue() * 60), DAY(HOUR.getValue() * 24), WEEK(
			DAY.getValue() * 7);

	private int minutes;

	private Minutes(int minutes) {
		this.minutes = minutes;
	}

	public int getValue() {
		return minutes;
	}

}