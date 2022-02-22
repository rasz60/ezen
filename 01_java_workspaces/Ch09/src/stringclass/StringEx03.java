package stringclass;

public class StringEx03 {

	public static void main(String[] args) {
		char[] chArr = new char[0];
		String s = new String(chArr);
		
		System.out.println("chArr.length = " + chArr.length);
		System.out.println("@@@" + s + "@@@");
		
	}
}
