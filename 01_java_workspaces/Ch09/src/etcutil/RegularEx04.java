package etcutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx04 {

	public static void main(String[] args) {
		String source = "A broken hand works, but not a broken heart.";
		String pattern = "broken";
		StringBuffer sb = new StringBuffer();
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("source : " + source);
		
		int i = 0;
		while( m.find() ) {
			System.out.println(++i + "번째 매칭 : " + m.start() + "~" + m.end());			// find()가 true인 시작점 인덱스(start()), 마지막 인덱스 (end())
			m.appendReplacement(sb, "drunken");											// StringBuffer(매개변수1)에 전체 문장을 넣으면서, pattern과 일치하는 부분을 "drunken"(매개변수2) 값으로 바꿔서 넣어준다. 
		}
		
		m.appendTail(sb);																// find()가 true인 부분까지만 저장된 sb에 남은 문자열을 추가해준다.
		System.out.println("Repalcement count : " + i);
		System.out.println("result : " + sb.toString());
	}

}
