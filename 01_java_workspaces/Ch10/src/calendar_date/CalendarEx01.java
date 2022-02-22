package calendar_date;

import java.util.Calendar;
import java.util.Date;

public class CalendarEx01 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();

		System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
		System.out.println("월 (0~11, 0:1월) : " + today.get(Calendar.MONTH));						// 0~11까지 나오므로 1을 더해야 정확한 월이 출력
		System.out.println("이 해의 몇번째 주 : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇번째 주 : " + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println();
		System.out.println("이 달의 몇 일1 : " + today.get(Calendar.DATE));
		System.out.println("이 달의 몇 일2 : " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 해의 몇 일 : " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(1~7, 1:일요일) : " + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("이 달의 몇번째 요일 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println();
		System.out.println("오전_오후(0:오전, 1:오후) : " + today.get(Calendar.AM_PM));
		System.out.println("시간(0~11) : " + today.get(Calendar.HOUR));
		System.out.println("시간(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : " + today.get(Calendar.MINUTE));
		System.out.println("초(0~59) : " + today.get(Calendar.SECOND));
		System.out.println("1000분의 1초(0~999) : " + today.get(Calendar.MILLISECOND));
		System.out.println();
		System.out.println("TimeZone(-12~+12) : " + (today.get(Calendar.ZONE_OFFSET)/(60*60*1000)) );	// 세계 표준시로부터의 시차 (MILLISECOND로 넘어오므로 연산 필요)
		System.out.println("이 달의 마지막 날 : " + today.getActualMaximum(Calendar.DATE));

//		Date now = new Date();
//		System.out.println(today);
//		System.out.println(now);
//		System.out.println(today.getTime());
//		System.out.println(todayIs(today));
	}
	
	public static String todayIs(Calendar calendar) {
		Calendar today = Calendar.getInstance();
		String todayIs = 
				today.get(Calendar.YEAR) + "년 " + today.get(Calendar.MONTH) + "월 " + today.get(Calendar.DATE) + "일 // "
			   +today.get(Calendar.HOUR) + "시 " + today.get(Calendar.MINUTE) + "분 " + today.get(Calendar.SECOND) + "." + today.get(Calendar.MILLISECOND) + "초";
		return todayIs;
	}

}
