package kr.jm.utils.time;

import java.text.SimpleDateFormat;

public class JMTime {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;

	public JMTime(long timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String[] timeStrings = sdf.format(timestamp).split("-");
		init(timeStrings[0], timeStrings[1], timeStrings[2], timeStrings[3],
				timeStrings[4], timeStrings[5]);
	}

	public JMTime(String year, String month, String day, String hour,
			String minute, String second) {
		super();
		init(year, month, day, hour, minute, second);
	}

	private void init(String year, String month, String day, String hour,
			String minute, String second) {
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
