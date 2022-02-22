package calendar_date;

import java.util.Calendar;
import java.util.Date;

public class CalendarEx01 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();

		System.out.println("�� ���� �⵵ : " + today.get(Calendar.YEAR));
		System.out.println("�� (0~11, 0:1��) : " + today.get(Calendar.MONTH));						// 0~11���� �����Ƿ� 1�� ���ؾ� ��Ȯ�� ���� ���
		System.out.println("�� ���� ���° �� : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("�� ���� ���° �� : " + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println();
		System.out.println("�� ���� �� ��1 : " + today.get(Calendar.DATE));
		System.out.println("�� ���� �� ��2 : " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("�� ���� �� �� : " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("����(1~7, 1:�Ͽ���) : " + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("�� ���� ���° ���� : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println();
		System.out.println("����_����(0:����, 1:����) : " + today.get(Calendar.AM_PM));
		System.out.println("�ð�(0~11) : " + today.get(Calendar.HOUR));
		System.out.println("�ð�(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("��(0~59) : " + today.get(Calendar.MINUTE));
		System.out.println("��(0~59) : " + today.get(Calendar.SECOND));
		System.out.println("1000���� 1��(0~999) : " + today.get(Calendar.MILLISECOND));
		System.out.println();
		System.out.println("TimeZone(-12~+12) : " + (today.get(Calendar.ZONE_OFFSET)/(60*60*1000)) );	// ���� ǥ�ؽ÷κ����� ���� (MILLISECOND�� �Ѿ���Ƿ� ���� �ʿ�)
		System.out.println("�� ���� ������ �� : " + today.getActualMaximum(Calendar.DATE));

//		Date now = new Date();
//		System.out.println(today);
//		System.out.println(now);
//		System.out.println(today.getTime());
//		System.out.println(todayIs(today));
	}
	
	public static String todayIs(Calendar calendar) {
		Calendar today = Calendar.getInstance();
		String todayIs = 
				today.get(Calendar.YEAR) + "�� " + today.get(Calendar.MONTH) + "�� " + today.get(Calendar.DATE) + "�� // "
			   +today.get(Calendar.HOUR) + "�� " + today.get(Calendar.MINUTE) + "�� " + today.get(Calendar.SECOND) + "." + today.get(Calendar.MILLISECOND) + "��";
		return todayIs;
	}

}
