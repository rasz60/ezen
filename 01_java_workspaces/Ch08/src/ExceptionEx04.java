
public class ExceptionEx04 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(4);
		}
		//Exception�� �߻����� �ʾ����Ƿ� catch���� �����ϰ� ����������.
		catch (Exception e) {
			System.out.println(5);
		}		
		System.out.println(6);
	}

}
