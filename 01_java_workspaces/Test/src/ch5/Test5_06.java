package ch5;

public class Test5_06 {

	public static void main(String[] args) {

		int[] coinUnit = { 500, 100, 50, 10 };
		
		int money = 2680;
		System.out.println("money = " + money);

		int left = 0;
		for( int i = 0; i < coinUnit.length; i++ ) {
			int count = 0;
			money -= left;
			if ( money % coinUnit[i] != 0 ) {
				count = money / coinUnit[i];
				left = money % coinUnit[i];
			}
			System.out.printf("%d¿ø : %d°³", coinUnit[i], count);
		}
	}

}
