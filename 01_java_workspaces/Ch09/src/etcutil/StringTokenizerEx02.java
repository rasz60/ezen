package etcutil;

import java.util.StringTokenizer;

public class StringTokenizerEx02 {

	public static void main(String[] args) {
		String source = "x=100*(200+300)/2";
		StringTokenizer st = new StringTokenizer(source, "+-*/=()", false);		// source�� delimeter�� �����ؼ� �迭�� ����, delimeter�� ���� ���� (true�϶�) - false�̸� delimeter�� ���� ���� 
		
		while ( st.hasMoreTokens() ) {
			System.out.println(st.nextToken());
		}
		
	}
}
