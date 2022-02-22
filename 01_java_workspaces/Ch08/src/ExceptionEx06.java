
public class ExceptionEx06 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			//ArithmeticException이 발생하면 다음 문장도 생략하고 catch문으로 이동하여 수행 후 빠져나감
			System.out.println(0/0);
			System.out.println(4);
		} catch (ArithmeticException ae) {
			System.out.println(5);
		}
		System.out.println(6);
		
	}

}
