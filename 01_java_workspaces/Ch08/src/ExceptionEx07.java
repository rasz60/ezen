
public class ExceptionEx07 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);


		try {																// try�� ���� �� exception�� �߻��ϸ�, �ش�Ǵ� exception ó������ �ִ� catch������ �̵��Ͽ� ����.
			System.out.println(3);											// IndexOutofBoundException�� ����Ŭ������ Exception catch������ �̵�
			System.out.println(args[0]);
			System.out.println(0/0);										// �ش�Ǵ� ArithmeticException catch������ �̵�
			System.out.println(4);
		}
		
		catch ( ArithmeticException | ArrayIndexOutOfBoundsException e ) {
			if ( e instanceof ArithmeticException ) {
				System.out.println("�������");
			}
			else {
				System.out.println("�ٽ� �ۼ��ϼ���.");
			}
		}
		
		catch ( Exception e ) {
			System.out.println("Exception!(need to check.)");
			e.printStackTrace();
		}
		
		System.out.println(5);
	}
}
