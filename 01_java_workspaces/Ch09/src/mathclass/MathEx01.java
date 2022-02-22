package mathclass;

import static java.lang.Math.*;

public class MathEx01 {

	public static void main(String[] args) {
		double val = 90.7552;
		System.out.println("round(" + val + ") = " + round(val));									// round() : 소수 첫번째 자리에서 반올림한 long타입 정수 값 반환
		
		val *= 100;
		System.out.println("round(" + val + ") = " + round(val));
		
		System.out.println("round(" + val + ")/100 = "    + round(val) / 100);				
		System.out.println("round(" + val + ")/100.0 = "  + round(val) / 100.0);			
		System.out.println();			
		System.out.printf("ceil(%3.1f)   = %3.1f%n",	1.1, ceil(1.1)		);						// ceil() : 올림
		System.out.printf("floor(%3.1f)  = %3.1f%n",	1.5, floor(1.5)		);						// floor() : 버림
		System.out.printf("round(%3.1f)  = %d%n",		1.1, round(1.1)		);
		System.out.printf("round(%3.1f)  = %d%n",		1.1, round(1.1)		);
		System.out.printf("rint(%3.1f)   = %f%n",		1.5, rint(1.5)		);						// rint() : 홀수는 올림, 짝수는 버림
		System.out.printf("round(%3.1f) = %d%n",	  -1.5, round(-1.5)		);
		System.out.printf("rint(%3.1f)  = %f%n",      -1.5, rint(-1.5)		);
		System.out.printf("ceil(%3.1f)  = %f%n",      -1.5, ceil(-1.5)		);
		System.out.printf("floor(%3.1f) = %f%n",      -1.5, floor(-1.5)		);

//		double sum = 0, sum1 = 0, sum2 =0;
//		
//		for (double d = 1.5; d <= 10; d++ ) {
//			double d1 = Math.round(d);
//			double d2 = Math.rint(d);
//			System.out.printf("%4.1f  %4.1f  %4.1f%n", d, d1, d2);
//			sum += d;
//			sum1 += d1;
//			sum2 += d2;
//		}
//		System.out.println();
//		System.out.printf("%4.1f  %4.1f  %4.1f%n", sum, sum1, sum2);

	}
}
