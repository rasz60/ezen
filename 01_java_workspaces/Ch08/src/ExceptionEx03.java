
public class ExceptionEx03 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for ( int i = 0; i < 10; i++ ) {
			try {
				result = number / (int)(Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException e) {						// ArithmeticException : 정수를 0으로 나누면 일어나는 오류 처리
				System.out.println("0");
			}
		}

// 위 예제 if로 바꾼거	
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
