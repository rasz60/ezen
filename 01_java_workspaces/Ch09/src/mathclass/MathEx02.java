package mathclass;

import static java.lang.Math.*;

public class MathEx02 {

	public static void main(String[] args) {
		int i = Integer.MIN_VALUE;
		System.out.println(" i = " +    i  );
		System.out.println("-i = " +  (-i) );
				
		try {
			System.out.printf("negateExact(%11d) = %11d%n",  10, negateExact(10) );					// negateExact() : 매개변수를 음수일 때 양수로, 양수일 때 음수로 부호만 변경해준다.
			System.out.printf("negateExact(%11d) = %11d%n", -10, negateExact(-10));				
			System.out.printf("negateExact(%11d) = %11d%n",   i, negateExact(i)	 );					// int로 표현할 수 있는 숫자의 범위를 초과하여 ArithmeticException 발생

		} catch (ArithmeticException ae) {
			System.out.println("ArithmeticException 발생!!!");
			System.out.printf("negateExact(%11d) = %11d%n", (long)i, negateExact((long)i));			// long으로 형변환하여 표현
		}
		
	}
}
