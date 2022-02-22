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
			System.out.println(++i + "��° ��Ī : " + m.start() + "~" + m.end());			// find()�� true�� ������ �ε���(start()), ������ �ε��� (end())
			m.appendReplacement(sb, "drunken");											// StringBuffer(�Ű�����1)�� ��ü ������ �����鼭, pattern�� ��ġ�ϴ� �κ��� "drunken"(�Ű�����2) ������ �ٲ㼭 �־��ش�. 
		}
		
		m.appendTail(sb);																// find()�� true�� �κб����� ����� sb�� ���� ���ڿ��� �߰����ش�.
		System.out.println("Repalcement count : " + i);
		System.out.println("result : " + sb.toString());
	}

}
