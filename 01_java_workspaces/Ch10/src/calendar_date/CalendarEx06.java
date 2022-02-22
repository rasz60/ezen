package calendar_date;

import java.util.Calendar;

public class CalendarEx06 {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage : java CalendarEx6 2015 9");
			return;
		}
		
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		sDay.set(year, month-1, 1);												// 입력한 년/월의 1일로 설정한다.
		eDay.set(year, month, 1);												// 입력한 년/월의 다음달 1일로 설정한다. 
		
		eDay.add(Calendar.DATE, -1);											// 입력한 년/월의 다음달 1일에서 하루를 빼서 입력한 년/월의 마지막 날짜로 set한다.
		
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);						// 첫번째 요일이 몇 번째 요일인지 가져온다. (일요일부터 1)

		END_DAY = eDay.get(Calendar.DATE);										// 해당 달의 마지막 일이 몇 일인지 가져온다.
		
		System.out.println("      " + args[0] + "년 " + args[1] + "월");
		System.out.println(" SU MO TU WE TH FR SA");
		 
		for ( int i = 1; i < START_DAY_OF_WEEK; i++ ) {							// 1일에 해당하는 요일 칸에 맞을 때 까지 공백을 추가한다.
			System.out.print("   ");
		}
		
		for ( int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++ ) {		// 1일 부터 시작해서 숫자를 출력, n이 7의 배수가 되면 줄바꿈(->일주일이되면 줄바꿈)
			System.out.print((i<10)? "  " +i : " "+i );
			if(n%7==0) {
				System.out.println();
			}
		}
		
	}

}
