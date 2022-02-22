package objectclass;

public class HashCodeEx01 {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		String str3 = "abc";															
		String str4 = "abc";
		
		System.out.println("str1 == str2 : " + str1.equals(str2));
		System.out.println("str1 == str3 : " + str1.equals(str3));
		System.out.println("str3 == str4 : " + str3.equals(str4));
		System.out.println();
		System.out.println("str1.hashCode() : " + str1.hashCode());
		System.out.println("str2.hashCode() : " + str2.hashCode());		
		System.out.println("str3.hashCode() : " + str3.hashCode());
		System.out.println("str4.hashCode() : " + str4.hashCode());
		System.out.println();
		System.out.println("str1.identityHashCode() : " + System.identityHashCode(str1));
		System.out.println("str2.identityHashCode() : " + System.identityHashCode(str2));
		System.out.println("str3.identityHashCode() : " + System.identityHashCode(str3));	// String 인스턴스 생성없이 같은 값을 바로 대입하는 경우, hashCode가 동일하다.
		System.out.println("str4.identityHashCode() : " + System.identityHashCode(str4));	//
	}

}
