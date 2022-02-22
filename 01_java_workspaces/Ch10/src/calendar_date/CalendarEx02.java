package calendar_date;

import java.util.Calendar;

public class CalendarEx02 {

	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = { "", "일", "월", "화", "수", "목", "금", "토" };
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(1991, 02, 07);

		
		System.out.print
		("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고, ");
		
		System.out.println
		("오늘은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");

		
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("date1부터 오늘까지 " + difference + "초가 지났습니다.");
		System.out.println("일(day)로 계산하면 " + setDayToYear(difference) + "입니다.");
		
	}

	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
	}
	
	public static String setDayToYear (long milliSeconds){
		long msToDate = milliSeconds / (24*60*60);
		long year = msToDate / 365;
		long month = (msToDate % 365) / 30;
		long date = (msToDate % 365) % 30;
		return msToDate + "일(" + year + "년 " + month + "개월 " + date + "일)";
	}
}
