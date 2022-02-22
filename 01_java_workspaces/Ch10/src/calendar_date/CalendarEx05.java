package calendar_date;

import java.util.Calendar;

public class CalendarEx05 {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		
		date.set(2015, 0, 31);
		System.out.println(toString(date));
		date.roll(Calendar.MONTH, 1);
		System.out.println(toString(date));
	}

	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "³â " + (date.get(Calendar.MONTH)+1) + "¿ù " + date.get(Calendar.DATE) + "ÀÏ";
	}
}
