import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rex {
	static String ID = null;
	static String PW = null;	
	
	public static void main(String[] args) {
		String[] ID = { "ar", "a r", "dddd", "dd12", "1ddd1", "d1d1d", "dddd1!", "rassayzsixt6", "rasz60", "!sdxt", "DD201", "rassayzsixt60", "ddddd" };
		String[] PW = { "ar", "a r", "ddd!@S2", "dd123122", "1ddd1", "d1d1d", "dddd1!!", "rassayzsixt6", "rasz60", "!sdxt", "DD201", "rassayzsixt60", "ddddd" };		
		
//		for ( String i : ID ) {
//			String msg = checkingIDRex(i);
//			System.out.println(i + " : " + msg);
//		}
		
		for ( String i : PW ) {
			String msg = checkingPWRex(i);
			System.out.println(i + " : " + msg);
		}
		
	}

//	static String checkingIDRex(String s) {
//		if ( s.length() < 4 || s.length() > 12 ) {
//			return "���� ���� (4~12��)";
//		}
//		if ( s.contains(" ") ) {
//			return "���� ���� ����";
//		}
//		String check = "^[A-z](?=.*\\d)([a-zA-Z0-9]{3,11})";		// �������� �����ϰ�, ����(��ҹ���) + ���� ���� ���ڿ�
//		boolean c = Pattern.matches(check, s);
//		if ( c ) {
//			ID = s;
//			return "���� ����";
//		} else {
//			return "����(��ҹ���) / ���� ���� ����(������ ����)";
//		}
//		
//	}
	
	static String checkingPWRex(String s) {
		if ( s.length() < 4 || s.length() > 12 ) {
			return "���� ���� (4~12��)";
		}
		if ( s.contains(" ") ) {
			return "���� ���� ����";
		}
		
		String check1 = "(?=.*\\d)(\\w{4,12})";		// �������� �����ϰ�, ����(��ҹ���) + ���� ���� ���ڿ�
		String check2 = "^\\!$";			// ���� �� �ִ� Ư������ ����
		
		boolean c1 = Pattern.matches(check1, s);
		System.out.print(c1 + ", ");
		boolean c2 = Pattern.matches(check2, s);
		System.out.println(c2);
		if ( c1 && c2 ) {
			PW = s;
			return "���� ����";
		} else if ( c1 == true || c2 == false ) {
			return "Ư������ 2�� �̻� ���� ����";
		} else {
			return "���� / ���� / Ư������ ���� ����";
		} 
		
	}
	
}