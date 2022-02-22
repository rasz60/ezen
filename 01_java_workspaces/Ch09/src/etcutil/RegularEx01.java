package etcutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx01 {

	public static void main(String[] args) {
		String[] data = { "bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc" };
		
		Pattern p = Pattern.compile("c[a-z]*");				// c로 시작하는 소문자 영어 단어인지 확인 (조건값은 x-y 식으로 추가 가능)
//				  = Patetrn.compile("c[a-z]");				// c로 시작하는 2글자 소문자 영어 단어
//				  = Patetrn.compile("c.");					// c로 시작하는 2글자 단어
//		  		  = Patetrn.compile("c.*");					// c로 시작하는 모든 문자열
//		  		  = Patetrn.compile("c\\w");				// c로 시작하고, 영문/숫자가 조합된 2글자 
//				  = Patetrn.compile("c\.");					// c. 과 일치하는 문자열	
//		 		  = Patetrn.compile("c\d");					// c와 숫자로 구성된 2자리 문자열
//				  = Patetrn.compile("c.");					// c로 시작하는		
//				  = Patetrn.compile("c.");					// c로 시작하는
//				  = Patetrn.compile("c.");					// c로 시작하는
		
		for ( int i = 0; i < data.length; i++ ) {
			Matcher m = p.matcher(data[i]);					// p(c로 시작하는 소문자 단어)조건에 data[i]가 일치할 때, m을 생성하여 값을 저장
			if ( m.matches() ) {							
				System.out.print(data[i] + " ,");
			}
		}
	}

}
