
public class ExceptionEx03 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for ( int i = 0; i < 10; i++ ) {
			try {
				result = number / (int)(Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException e) {						// ArithmeticException : ������ 0���� ������ �Ͼ�� ���� ó��
				System.out.println("0");
			}
		}

// �� ���� if�� �ٲ۰�	
/*		for ( int i = 0; i < 10; i++ ) {
			int random = (int)(Math.random() * 10);
			if ( random == 0 ) {
				result = 0;
			}
			else {
				result = number / random; 
			}
			System.out.println(result);
		}
*/		
	}

}
