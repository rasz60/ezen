
public class ExceptionEx17 {

	public static void main(String[] args) {
		try {
			method1();
		} catch ( Exception e ) {
			System.out.println("main에서 예외가 처리되었습니다.");
		}
	}
	
	static int method1 () throws Exception {
		try {
			throw new Exception();
		} catch ( Exception e ) {
			System.out.println("method1에서 예외가 처리되었습니다.");
			throw e;												//메서드 내부에서 예외처리 완료한 후에 다시 예외를 발생시켜 호출한 곳으로 throws한다.
		} finally {
			System.out.println("throw Exception e");
		}
	}
	
}
