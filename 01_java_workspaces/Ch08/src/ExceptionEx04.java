
public class ExceptionEx04 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(4);
		}
		//Exception이 발생하지 않았으므로 catch문을 생략하고 빠져나간다.
		catch (Exception e) {
			System.out.println(5);
		}		
		System.out.println(6);
	}

}
