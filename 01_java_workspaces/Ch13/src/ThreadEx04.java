
public class ThreadEx04 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		for ( int i = 0; i < 500; i++ ) {
			System.out.printf("%s", new String("-"));
		}
		long endTime1 = System.currentTimeMillis() - startTime;
		System.out.println("소요시간 1 : " + endTime1);
		
		for ( int i = 0; i < 500; i++ ) {
			System.out.printf("%s", new String("|"));
		}
		long endTime2 = endTime1 - System.currentTimeMillis();
		System.out.println("소요시간 2 : " + endTime2);
		
	}

}
