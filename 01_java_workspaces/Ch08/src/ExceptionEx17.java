
public class ExceptionEx17 {

	public static void main(String[] args) {
		try {
			method1();
		} catch ( Exception e ) {
			System.out.println("main���� ���ܰ� ó���Ǿ����ϴ�.");
		}
	}
	
	static int method1 () throws Exception {
		try {
			throw new Exception();
		} catch ( Exception e ) {
			System.out.println("method1���� ���ܰ� ó���Ǿ����ϴ�.");
			throw e;												//�޼��� ���ο��� ����ó�� �Ϸ��� �Ŀ� �ٽ� ���ܸ� �߻����� ȣ���� ������ throws�Ѵ�.
		} finally {
			System.out.println("throw Exception e");
		}
	}
	
}
