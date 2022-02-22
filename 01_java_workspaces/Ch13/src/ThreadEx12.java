
public class ThreadEx12 {
	public static void main(String[] args) {
		ThreadEx12_01 th1 = new ThreadEx12_01();
		ThreadEx12_02 th2 = new ThreadEx12_02();
		th1.start();
		th2.start();
		
//		try {
//			th1.sleep(2000);						// 다른 Thread를 지정하여 sleep()을 적용시킬 수 없다.(다른 Thread를 지정해도 본인에게 적용)
//		} catch(InterruptedException e) {}
		
		delay(2000);
		
		System.out.println("<<main 종료>>");
	}

	private static void delay(long millis) {
		try {
			Thread.sleep(millis);
		} catch(InterruptedException e) {}
	}

}


class ThreadEx12_01 extends Thread {
	public void run() {
		for( int i = 0; i< 300; i++ ) {
			System.out.print("o");
		}
		System.out.println("<<th1 종료>>");
	}

}


class ThreadEx12_02 extends Thread {
	public void run() {
		for( int i = 0; i< 300; i++ ) {
			System.out.print("X");
		}
		System.out.println("<<th2 종료>>");
	}	

}