package etcutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx03 {

	public static void main(String[] args) {
		String source  = "HP:011-1111-1111, HOME:02-999-9999";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		
		int i = 0;
		while( m.find() ) {														// ��ġ�ϴ� ���� ã���� true, �ƴϸ� false
			System.out.println( ++i + ": " + m.group() + "-> " + m.group(1)		// group() 	: ������ �´� ��ü String �׷�ȭ
									+ ", " + m.group(2) + ", " + m.group(3)		// group(n) : n��° ���ǿ� �´� String�� �׷�ȭ
							  );
		}
		for ( int i2 = 0; i2 < source.length(); i2++ ) {
			if ( m.matches() ) {
				System.out.println( (i2+1) + ": " + m.group() + "-> " + m.group(1)		// group() 	: ������ �´� ��ü String �׷�ȭ
										   + ", " + m.group(2) + ", " + m.group(3)		// group(n) : n��° ���ǿ� �´� String�� �׷�ȭ
							  		);
			}
		}
	}

}
