package calendar_date;

import java.util.Calendar;

public class CalendarEx02 {

	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = { "", "��", "��", "ȭ", "��", "��", "��", "��" };
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(1991, 02, 07);

		
		System.out.print
		("date1�� " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "�����̰�, ");
		
		System.out.println
		("������ " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "�����Դϴ�.");

		
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("date1���� ���ñ��� " + difference + "�ʰ� �������ϴ�.");
		System.out.println("��(day)�� ����ϸ� " + setDayToYear(difference) + "�Դϴ�.");
		
	}

	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "�� " + (date.get(Calendar.MONTH) + 1) + "�� " + date.get(Calendar.DATE) + "�� ";
	}
	
	public static String setDayToYear (long milliSeconds){
		long msToDate = milliSeconds / (24*60*60);
		long year = msToDate / 365;
		long month = (msToDate % 365) / 30;
		long date = (msToDate % 365) % 30;
		return msToDate + "��(" + year + "�� " + month + "���� " + date + "��)";
	}
}
