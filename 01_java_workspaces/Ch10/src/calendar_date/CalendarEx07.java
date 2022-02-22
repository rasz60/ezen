package calendar_date;

import java.util.Calendar;

public class CalendarEx07 {

	public static void main(String[] args) {
		if ( args.length != 2) {
			System.out.println("Usage : java CalendarEx7 2015 11");
			return;
		}
		
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();		
		
		sDay.set(year, month-1, 1);																	
		eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE));								// sDay 년/월의 마지막 날짜를 DATE로 세팅한다.

		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);								// sDay 년/월의 1일이 무슨 요일인지 숫자로 가져와서 음수로 바꾸고 1을 더해준 날짜를 sDay 날짜로 세팅.
		eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));								// eDay 년/월의 마지막날이 무슨 요일인지 숫자로 가져와서 7에서 빼준 날짜를 eDay 날짜로 세팅.
		
		System.out.println("      " + year + "년 " + month + "월");
		System.out.println(" SU MO TU WE TH FR SA");
		 
		for ( int n = 1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE,  1)) {		// sDay가 eDay보다 작거나 같을 때까지 반복, n이 7의 배수가 되면 줄바꿈(->일주일이되면 줄바꿈)
			int day = sDay.get(Calendar.DATE);
			System.out.print((day < 10)? "  " + day : " " + day );
			if(n++%7==0) {
				System.out.println();
			}
		}
	}

}
