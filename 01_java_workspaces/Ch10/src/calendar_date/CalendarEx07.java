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
		eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE));								// sDay ��/���� ������ ��¥�� DATE�� �����Ѵ�.

		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);								// sDay ��/���� 1���� ���� �������� ���ڷ� �����ͼ� ������ �ٲٰ� 1�� ������ ��¥�� sDay ��¥�� ����.
		eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));								// eDay ��/���� ���������� ���� �������� ���ڷ� �����ͼ� 7���� ���� ��¥�� eDay ��¥�� ����.
		
		System.out.println("      " + year + "�� " + month + "��");
		System.out.println(" SU MO TU WE TH FR SA");
		 
		for ( int n = 1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE,  1)) {		// sDay�� eDay���� �۰ų� ���� ������ �ݺ�, n�� 7�� ����� �Ǹ� �ٹٲ�(->�������̵Ǹ� �ٹٲ�)
			int day = sDay.get(Calendar.DATE);
			System.out.print((day < 10)? "  " + day : " " + day );
			if(n++%7==0) {
				System.out.println();
			}
		}
	}

}
