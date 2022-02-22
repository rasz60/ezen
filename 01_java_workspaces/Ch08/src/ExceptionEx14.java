
public class ExceptionEx14 {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("예외 처리 완료.");
		}
		
	}

	static void method1() throws Exception {
		throw new Exception();
	}
	
}
