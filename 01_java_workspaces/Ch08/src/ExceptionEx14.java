
public class ExceptionEx14 {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("���� ó�� �Ϸ�.");
		}
		
	}

	static void method1() throws Exception {
		throw new Exception();
	}
	
}
