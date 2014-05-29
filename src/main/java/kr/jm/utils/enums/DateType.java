package kr.jm.utils.enums;

public enum DateType {

	WEEK, DAY, HOUR, MINUTE, SECOND;

	public long getMilliseconds() {
		switch (this) {
		case WEEK:
			return Milliseconds.WEEK.getValue();
		case DAY:
			return Milliseconds.DAY.getValue();
		case HOUR:
			return Milliseconds.HOUR.getValue();
		case MINUTE:
			return Milliseconds.MINUTE.getValue();
		case SECOND:
			return Milliseconds.SECOND.getValue();
		default:
			return 0;
		}
	}

	public int getSeconds() {
		switch (this) {
		case WEEK:
			return Seconds.WEEK.getValue();
		case DAY:
			return Seconds.DAY.getValue();
		case HOUR:
			return Seconds.HOUR.getValue();
		case MINUTE:
			return Seconds.MINUTE.getValue();
		case SECOND:
			return Seconds.SECOND.getValue();
		default:
			return 0;
		}

	}
}
