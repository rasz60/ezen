package etcutil;

import java.util.StringTokenizer;

public class StringTokenizerEx05 {

	public static void main(String[] args) {
		String data = "100,,,200,300";
		
		String[] result = data.split(",");								// split() 메서드는 구분자로 해체만 하고 null이더라도 배열에 저장한다.
		StringTokenizer st = new StringTokenizer(data, ",");			// StringTokenizer는 구분자로 해체한 토큰이 null일 때 제외한다.
		
		for ( int i = 0; i < result.length; i++ ) {
			System.out.print(result[i] + "|");
		}
		
		System.out.println("개수 : " + result.length);
		
		int i;
		for ( i = 0; st.hasMoreTokens(); i++ ) {
			System.out.print(st.nextToken()+"|");
		}
		System.out.println("개수 : " + i);

	}
}
