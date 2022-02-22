package stringbuffer;

public class StringBufferEx01 {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");

		System.out.println("sb1 == sb2 ? " + (sb1 == sb2));
		System.out.println("sb1.equals(s2) ? " + (sb1.equals(sb2)));
		
		String s1 = sb1.toString();
		String s2 = sb2.toString();
		
		System.out.println("s1.equals(s2) ? " + (s1.equals(s2)));
		
	}

}
