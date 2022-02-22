package com.wvwv.ch02ex01;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("main ¸Þ¼­µå");
		Calculation calc = new Calculation();
		int result = 0;
		int count = 0;
		int limit = (int)((Math.random() * 10000) + 1);
		while ( result != limit ) {
			calc.setFirstNum((int)((Math.random() * 10000)+1));
			calc.setSecondNum((int)((Math.random() * 10000)+1));
			result = calc.addition();
			
			if ( result == limit ) {
				System.out.println("firstNum : " + calc.getFirstNum() + " & secondNum : " + calc.getSecondNum());
			} else {
				count++;
				continue;
			}
		}
		System.out.println("END FUNCTION (limit : " + limit + " / try : " + count + ")");
	}
}