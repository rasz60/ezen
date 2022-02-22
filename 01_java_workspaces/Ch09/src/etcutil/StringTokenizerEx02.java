package etcutil;

import java.util.StringTokenizer;

public class StringTokenizerEx02 {

	public static void main(String[] args) {
		String source = "x=100*(200+300)/2";
		StringTokenizer st = new StringTokenizer(source, "+-*/=()", false);		// source를 delimeter로 분해해서 배열에 저장, delimeter도 같이 저장 (true일때) - false이면 delimeter는 빼고 저장 
		
		while ( st.hasMoreTokens() ) {
			System.out.println(st.nextToken());
		}
		
	}
}
