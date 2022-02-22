package etcutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx01 {

	public static void main(String[] args) {
		String[] data = { "bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc" };
		
		Pattern p = Pattern.compile("c[a-z]*");				// c�� �����ϴ� �ҹ��� ���� �ܾ����� Ȯ�� (���ǰ��� x-y ������ �߰� ����)
//				  = Patetrn.compile("c[a-z]");				// c�� �����ϴ� 2���� �ҹ��� ���� �ܾ�
//				  = Patetrn.compile("c.");					// c�� �����ϴ� 2���� �ܾ�
//		  		  = Patetrn.compile("c.*");					// c�� �����ϴ� ��� ���ڿ�
//		  		  = Patetrn.compile("c\\w");				// c�� �����ϰ�, ����/���ڰ� ���յ� 2���� 
//				  = Patetrn.compile("c\.");					// c. �� ��ġ�ϴ� ���ڿ�	
//		 		  = Patetrn.compile("c\d");					// c�� ���ڷ� ������ 2�ڸ� ���ڿ�
//				  = Patetrn.compile("c.");					// c�� �����ϴ�		
//				  = Patetrn.compile("c.");					// c�� �����ϴ�
//				  = Patetrn.compile("c.");					// c�� �����ϴ�
		
		for ( int i = 0; i < data.length; i++ ) {
			Matcher m = p.matcher(data[i]);					// p(c�� �����ϴ� �ҹ��� �ܾ�)���ǿ� data[i]�� ��ġ�� ��, m�� �����Ͽ� ���� ����
			if ( m.matches() ) {							
				System.out.print(data[i] + " ,");
			}
		}
	}

}
