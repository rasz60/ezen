
public class FinallyTest3 {

	public static void main(String[] args) {
		method1();
		System.out.println("method1()�� ������ ��ġ�� main�޼���� ���ƿԽ��ϴ�.");
	}

	static void method1() {
		try {
			System.out.println("method1()�� ȣ��Ǿ����ϴ�.");
			return;															//finally �� ���� return���� ������ finally�� ������ �����Ѵ�.
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			System.out.println("method1()�� finally���� ����Ǿ����ϴ�.");
		}
	}
	
}
