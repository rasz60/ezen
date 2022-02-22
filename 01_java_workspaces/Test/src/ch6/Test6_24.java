package ch6;

import java.util.function.BinaryOperator;

public class Test6_24 {

	static int abs (int value) {
		int result = 0;
		result = value > value * -1 ? value: value * -1;
		return result;
	}
	
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value + "의 절대값 : " + abs(value));

		value = -10;
		System.out.println(value + "의 절대값 : " + abs(value));
	}

}
