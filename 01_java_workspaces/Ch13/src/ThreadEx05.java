
public class ThreadEx05 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx05_01 th1 = new ThreadEx05_01();
		th1.start();
		startTime = System.currentTimeMillis();
		
		for( int i = 0; i < 300; i++ ) {
			System.out.print("-");
		}
		
		System.out.println("소요시간 1 : " + (System.currentTimeMillis() - startTime));
	}

}

class ThreadEx05_01 extends Thread {

	@Override
	public void run() {
		for( int i = 0; i < 300; i++ ) {
			System.out.print("|");
		}
		
		System.out.println("소요시간 2 : " + (System.currentTimeMillis() - ThreadEx05.startTime));
	}
	
	
}