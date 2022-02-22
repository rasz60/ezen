package stringclass;

import java.util.Date;
import java.util.StringJoiner;

public class StringEx08 {

	public static void main(String[] args) {
		String s = new String("Hello.");									// #01. String(String s) ������ ���

		char[] ch = { 'H', 'e', 'l', 'l', 'o' };							// #02. String(char[] ch) ������ ���
		String s1 = new String(ch);
	
		StringBuffer sb = new StringBuffer("Hello");						// #03. StringBuffer �ν��Ͻ��� ���� �ִ� ���ڿ��� ���� ������ String ����
		String s2 = new String(sb);

		
		
		
		
		
		System.out.println(s.concat(" World."));							// #06. concat(String s) �޼��� : String Ÿ�� �ν��Ͻ��� ���ڿ��� �߰��� �� �ִ�.
		System.out.println(s.contains("lo"));								// #07. contains(String s) �޼��� : String Ÿ�� �ν��Ͻ��� �Ű������� �־��� String�� ���ԵǾ� �ִ��� Ȯ��
		
		String file = "Hello.txt";
		System.out.println(file.endsWith(".txt"));							// #08. endsWith(String s) : ������ ���ڿ��� �Ű������� �־��� String�� �´��� Ȯ��
		
		System.out.println(file.indexOf("txt"));							// #11. int indexOf(int ch or char ch of String str)
		System.out.println(file.indexOf('k'));								//    : �Ű����� char Ȥ�� String�� �� ��°�� �ִ��� int�� index �˷���, ������ -1
		
		System.out.println(file.lastIndexOf("txt"));						// #12. int lastIndexOf(int ch or char ch of String str)
		System.out.println(file.lastIndexOf('k'));							//    : �Ű����� char Ȥ�� String�� �� ��°�� �ִ��� �ڿ������� ã�Ƽ� int�� index �˷���, ������ -1		

		String s3 = s.intern();												// #13. intern() : �ش� ���ڿ��� ���Ǯ�� ����ϰ�, �̹� ������ ���� String�� �ּҸ� ����Ų��.
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
