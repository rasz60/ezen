package calendar_date;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTEST {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Calendar today = Calendar.getInstance();

		while( true ) {	
			System.out.println("(1) D-day ���(���ú���) // (2) �󸶳� �ƴ��� ���(���ú���)  // (q) ����");
			System.out.print(">>");
			String dd = sc.nextLine();
			if ( dd.equals("1") ) {
				System.out.print("��¥�Է�(YYYY/MM/DD) >> ");
				String str1 = sc.nextLine();
			
				String[] findDate1 = str1.split("/");

				Calendar date1 = Calendar.getInstance();
				date1.set(Integer.parseInt(findDate1[0]), Integer.parseInt(findDate1[1]), Integer.parseInt(findDate1[2]));
				if ( date1.getTimeInMillis() > today.getTimeInMillis() ) {
					long ms = ((date1.getTimeInMillis() - today.getTimeInMillis()) / 1000) / (24 * 60 * 60);
					System.out.println(ms + "�� ���ҽ��ϴ�.\n�ٸ� �۾� >>");
				}
				else {
					System.out.print("���ú��� ���� ��¥�� �Է����ּ���.\n>>");
				}
			}
				
			else if ( dd.equals("2") ) {
				System.out.print("��¥�Է�(YYYY/MM/DD) >> ");
				String str2 = sc.nextLine();
			
				String[] findDate2 = str2.split("/");

				Calendar date2 = Calendar.getInstance();
				date2.set(Integer.parseInt(findDate2[0]), Integer.parseInt(findDate2[1]), Integer.parseInt(findDate2[2]));
			
				if ( today.getTimeInMillis() > date2.getTimeInMillis() ) {
					long ms = ((today.getTimeInMillis() - date2.getTimeInMillis()) / 1000) / (24 * 60 * 60);
					System.out.println(ms + "�� �������ϴ�.\n�ٸ� �۾� >>");
				}
				else {
					System.out.print("���ú��� ���� ��¥�� �Է����ּ���.\n>>");
				}
			}
		
			else if ( dd.equals("q") || dd.equals("Q") ) {
				System.out.println("bye..");
				return;
			}
		
			else {
				System.out.print("1~4�� �Է�%n>>");
				continue;
			}
		}
	
	}
	
}
