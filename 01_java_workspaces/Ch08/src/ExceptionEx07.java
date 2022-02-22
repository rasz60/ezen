
public class ExceptionEx07 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);


		try {																// try문 수행 중 exception이 발생하면, 해당되는 exception 처리문이 있는 catch문으로 이동하여 수행.
			System.out.println(3);											// IndexOutofBoundException의 상위클래스인 Exception catch문으로 이동
			System.out.println(args[0]);
			System.out.println(0/0);										// 해당되는 ArithmeticException catch문으로 이동
			System.out.println(4);
		}
		
		catch ( ArithmeticException | ArrayIndexOutOfBoundsException e ) {
			if ( e instanceof ArithmeticException ) {
				System.out.println("제목없음");
			}
			else {
				System.out.println("다시 작성하세요.");
			}
		}
		
		catch ( Exception e ) {
			System.out.println("Exception!(need to check.)");
			e.printStackTrace();
		}
		
		System.out.println(5);
	}
}
