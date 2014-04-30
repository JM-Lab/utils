package kr.jm.utils;

public class JMTime {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;

	public JMTime(String year, String month, String day, String hour,
			String minute, String second) {
		super();
		this.year = new Integer(year).intValue();
		this.month = new Integer(month).intValue();
		this.day = new Integer(day).intValue();
		this.hour = new Integer(hour).intValue();
		this.minute = new Integer(minute).intValue();
		this.second = new Integer(second).intValue();
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

}
