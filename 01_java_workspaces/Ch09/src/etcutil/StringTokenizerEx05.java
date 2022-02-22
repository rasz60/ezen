package etcutil;

import java.util.StringTokenizer;

public class StringTokenizerEx05 {

	public static void main(String[] args) {
		String data = "100,,,200,300";
		
		String[] result = data.split(",");								// split() �޼���� �����ڷ� ��ü�� �ϰ� null�̴��� �迭�� �����Ѵ�.
		StringTokenizer st = new StringTokenizer(data, ",");			// StringTokenizer�� �����ڷ� ��ü�� ��ū�� null�� �� �����Ѵ�.
		
		for ( int i = 0; i < result.length; i++ ) {
			System.out.print(result[i] + "|");
		}
		
		System.out.println("���� : " + result.length);
		
		int i;
		for ( i = 0; st.hasMoreTokens(); i++ ) {
			System.out.print(st.nextToken()+"|");
		}
		System.out.println("���� : " + i);

	}
}
