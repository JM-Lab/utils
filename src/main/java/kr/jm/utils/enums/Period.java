package kr.jm.utils.enums;

public enum Period {
	WEEKLY, DAILY, HOURLY, MINUTELY, SECONDLY;

	private DateType getDateType() {
		switch (this) {
		case WEEKLY:
			return DateType.WEEK;
		case DAILY:
			return DateType.DAY;
		case HOURLY:
			return DateType.HOUR;
		case MINUTELY:
			return DateType.MINUTE;
		case SECONDLY:
			return DateType.SECOND;
		default:
			return null;
		}
	}

	public long getPeriodMilliseconds() {
		return this.getDateType().getMilliseconds();
	}

	public int getPeriodSeconds() {
		return this.getDateType().getSeconds();
	}

}
