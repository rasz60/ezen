
public class Time {

	private int hour;
	private int minute;
	private int second;

	Time(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (isNotValidHour(hour)) {
			System.out.println("시간(hour)이 범위에 맞지 않습니다.");
			return;
		}
		else {
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (isNotValidMinute(minute)) {
			System.out.println("시간(minute)이 범위에 맞지 않습니다.");
			return;
		}
		else {
			this.minute = minute;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if (isNotValidSecond(second)) {
			System.out.println("시간(second)이 범위에 맞지 않습니다.");
			return;
		}
		else {
			this.second = second;
		}
	}

	private boolean isNotValidHour(int hour) {
		return hour < 0 || hour > 23;
	}

	private boolean isNotValidMinute(int minute) {
		return minute < 0 || minute > 59;
	}

	private boolean isNotValidSecond(int second) {
		return second < 0 || second > 59;
	}

	public String toString() {
		return hour + ":" + minute + ":" + second;
	}

}
