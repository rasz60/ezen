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
//			return "길이 오류 (4~12자)";
//		}
//		if ( s.contains(" ") ) {
//			return "공백 포함 오류";
//		}
//		String check = "^[A-z](?=.*\\d)([a-zA-Z0-9]{3,11})";		// 영문으로 시작하고, 영문(대소문자) + 숫자 조합 문자열
//		boolean c = Pattern.matches(check, s);
//		if ( c ) {
//			ID = s;
//			return "가입 성공";
//		} else {
//			return "영문(대소문자) / 숫자 조합 오류(시작은 영문)";
//		}
//		
//	}
	
	static String checkingPWRex(String s) {
		if ( s.length() < 4 || s.length() > 12 ) {
			return "길이 오류 (4~12자)";
		}
		if ( s.contains(" ") ) {
			return "공백 포함 오류";
		}
		
		String check1 = "(?=.*\\d)(\\w{4,12})";		// 영문으로 시작하고, 영문(대소문자) + 숫자 조합 문자열
		String check2 = "^\\!$";			// 넣을 수 있는 특수문자 제한
		
		boolean c1 = Pattern.matches(check1, s);
		System.out.print(c1 + ", ");
		boolean c2 = Pattern.matches(check2, s);
		System.out.println(c2);
		if ( c1 && c2 ) {
			PW = s;
			return "가입 성공";
		} else if ( c1 == true || c2 == false ) {
			return "특수문자 2자 이상 포함 오류";
		} else {
			return "영문 / 숫자 / 특수문자 조합 오류";
		} 
		
	}
	
}
