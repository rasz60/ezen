package dateFormatter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterEx01 {

	public static void main(String[] args) {
		ZonedDateTime zdateTime = ZonedDateTime.now();
		
		String[] patternArr = {
								"yyyy-MM-dd HH:mm:ss",
								"''yy�� MMM dd�� E����",
								"yyyy-MM-dd HH:mm:ss.SSS Z VV",
								"yyyy-MM-dd HH:mm:ss a",
								"������ �� ���� D��° ���Դϴ�.",
								"������ �� ���� d��° ���Դϴ�.",
								"������ �� ���� w��° ���Դϴ�.",
								"������ �� ���� W��° ���Դϴ�.",
								"������ �� ���� W��° E�����Դϴ�.",
							  };
		
		for (String p : patternArr ) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(formatter));
		}
	}
	
}
