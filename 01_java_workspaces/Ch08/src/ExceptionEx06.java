
public class ExceptionEx06 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			//ArithmeticException�� �߻��ϸ� ���� ���嵵 �����ϰ� catch������ �̵��Ͽ� ���� �� ��������
			System.out.println(0/0);
			System.out.println(4);
		} catch (ArithmeticException ae) {
			System.out.println(5);
		}
		System.out.println(6);
		
	}

}
