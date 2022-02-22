package stringclass;

import java.util.Date;
import java.util.StringJoiner;

public class StringEx08 {

	public static void main(String[] args) {
		String s = new String("Hello.");									// #01. String(String s) 생성자 사용

		char[] ch = { 'H', 'e', 'l', 'l', 'o' };							// #02. String(char[] ch) 생성자 사용
		String s1 = new String(ch);
	
		StringBuffer sb = new StringBuffer("Hello");						// #03. StringBuffer 인스턴스가 갖고 있는 문자열과 같은 내용의 String 생성
		String s2 = new String(sb);

		
		
		
		
		
		System.out.println(s.concat(" World."));							// #06. concat(String s) 메서드 : String 타입 인스턴스에 문자열을 추가할 수 있다.
		System.out.println(s.contains("lo"));								// #07. contains(String s) 메서드 : String 타입 인스턴스에 매개변수로 주어진 String이 포함되어 있는지 확인
		
		String file = "Hello.txt";
		System.out.println(file.endsWith(".txt"));							// #08. endsWith(String s) : 마지막 문자열이 매개변수로 주어진 String이 맞는지 확인
		
		System.out.println(file.indexOf("txt"));							// #11. int indexOf(int ch or char ch of String str)
		System.out.println(file.indexOf('k'));								//    : 매개변수 char 혹은 String이 몇 번째에 있는지 int형 index 알려줌, 없으면 -1
		
		System.out.println(file.lastIndexOf("txt"));						// #12. int lastIndexOf(int ch or char ch of String str)
		System.out.println(file.lastIndexOf('k'));							//    : 매개변수 char 혹은 String이 몇 번째에 있는지 뒤에서부터 찾아서 int형 index 알려줌, 없으면 -1		

		String s3 = s.intern();												// #13. intern() : 해당 문자열을 상수풀에 등록하고, 이미 있으면 기존 String의 주소를 가르킨다.
		System.out.println(s3.hashCode());
		System.out.println(s.hashCode());
				
		Date dd = new Date();
		String date = String.valueOf(dd);
		System.out.println(date);
		
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");

		StringJoiner sj = new StringJoiner(" / ", "[", "]");
		for (String sj2 : arr) {
			sj.add(sj2.toUpperCase());
		}
		System.out.println(sj);
	}

}
