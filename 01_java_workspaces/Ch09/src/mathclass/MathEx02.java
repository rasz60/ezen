package mathclass;

import static java.lang.Math.*;

public class MathEx02 {

	public static void main(String[] args) {
		int i = Integer.MIN_VALUE;
		System.out.println(" i = " +    i  );
		System.out.println("-i = " +  (-i) );
				
		try {
			System.out.printf("negateExact(%11d) = %11d%n",  10, negateExact(10) );					// negateExact() : �Ű������� ������ �� �����, ����� �� ������ ��ȣ�� �������ش�.
			System.out.printf("negateExact(%11d) = %11d%n", -10, negateExact(-10));				
			System.out.printf("negateExact(%11d) = %11d%n",   i, negateExact(i)	 );					// int�� ǥ���� �� �ִ� ������ ������ �ʰ��Ͽ� ArithmeticException �߻�

		} catch (ArithmeticException ae) {
			System.out.println("ArithmeticException �߻�!!!");
			System.out.printf("negateExact(%11d) = %11d%n", (long)i, negateExact((long)i));			// long���� ����ȯ�Ͽ� ǥ��
		}
		
	}
}
