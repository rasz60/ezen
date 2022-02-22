package ch2;

public class Test4_01 {

	public static void main(String[] args) {

		int x = 30;
		
		if (x > 10 && x < 20) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		
		
		char ch = 'A';
		
		if (ch != ' ' && ch != '	') {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		
		char ch1 = 'x';
				
		if ( ch1 >= 'A' && ch1 <= 'z') {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		
		
		int year = 400;
		
		if (year % 400 != 0 && year % 4 != 0 && year % 100 != 0) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		
		int sum = 0;
		for ( int i = 1; i <= 20; i++) {
			if ( i % 2 == 0 || i % 3 == 0) {
				continue;
			}
			sum += i;
		}
		
		System.out.println(sum);
		
		int sum1 = 0;
		int sum2 = 0;
		for ( int i = 1; i <= 10; i++) {
			sum1 += i;
			sum2 += sum1;
		}
		System.out.println(sum2);
		
		
		
		int sum3 = 0;
		int i = 1;
			for (i = 1; sum3 >= 100; i++) {
				if (i % 2 == 0) {
					i = i*-1;
				}
				else {
					i = i*1;
				}
				sum3 += i;
							}
		System.out.println(i);
		
	}
}
