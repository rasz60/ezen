
public class ExceptionEx09 {

	public static void main(String[] args) {
		try {
			Exception e = new Exception ("ExceptionTester");
			throw e;
		}
		catch (Exception e) {
			System.out.println("error : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("정상 종료.");
	}

}
