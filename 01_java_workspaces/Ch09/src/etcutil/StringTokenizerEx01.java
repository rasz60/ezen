package etcutil;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		String source = "100,200,300,400,500";
		StringTokenizer st = new StringTokenizer(source, ",");		// source를 delimeter를 기준으로 분해해서 배열에 저장
		
		while ( st.hasMoreTokens() ) {
			System.out.println(st.nextToken());
		}
	}

}
