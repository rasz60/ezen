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
		
		sDay.set(year, month-1, 1);												// �Է��� ��/���� 1�Ϸ� �����Ѵ�.
		eDay.set(year, month, 1);												// �Է��� ��/���� ������ 1�Ϸ� �����Ѵ�. 
		
		eDay.add(Calendar.DATE, -1);											// �Է��� ��/���� ������ 1�Ͽ��� �Ϸ縦 ���� �Է��� ��/���� ������ ��¥�� set�Ѵ�.
		
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);						// ù��° ������ �� ��° �������� �����´�. (�Ͽ��Ϻ��� 1)

		END_DAY = eDay.get(Calendar.DATE);										// �ش� ���� ������ ���� �� ������ �����´�.
		
		System.out.println("      " + args[0] + "�� " + args[1] + "��");
		System.out.println(" SU MO TU WE TH FR SA");
		 
		for ( int i = 1; i < START_DAY_OF_WEEK; i++ ) {							// 1�Ͽ� �ش��ϴ� ���� ĭ�� ���� �� ���� ������ �߰��Ѵ�.
			System.out.print("   ");
		}
		
		for ( int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++ ) {		// 1�� ���� �����ؼ� ���ڸ� ���, n�� 7�� ����� �Ǹ� �ٹٲ�(->�������̵Ǹ� �ٹٲ�)
			System.out.print((i<10)? "  " +i : " "+i );
			if(n%7==0) {
				System.out.println();
			}
		}
		
	}

}
