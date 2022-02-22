package ch6;

public class Test6_22 {

	static boolean isNumber(String str) {
		char[] ch = str.toCharArray();
		boolean isNumber = false;
		for ( int i = 0; i < str.length(); i++) {
			if (ch[i] >= '0' && ch[i] <= '9') {
				isNumber = true;
			}
			else if (ch == null || ch[i] == ' ') {
				isNumber = false;
			}
			
			else {
				isNumber = false;
			}
		}
		return isNumber;
		
	}

	public static void main(String[] args) {

		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}

}
