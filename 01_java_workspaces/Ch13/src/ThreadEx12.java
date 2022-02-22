
public class ThreadEx12 {
	public static void main(String[] args) {
		ThreadEx12_01 th1 = new ThreadEx12_01();
		ThreadEx12_02 th2 = new ThreadEx12_02();
		th1.start();
		th2.start();
		
//		try {
//			th1.sleep(2000);						// �ٸ� Thread�� �����Ͽ� sleep()�� �����ų �� ����.(�ٸ� Thread�� �����ص� ���ο��� ����)
//		} catch(InterruptedException e) {}
		
		delay(2000);
		
		System.out.println("<<main ����>>");
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
		System.out.println("<<th1 ����>>");
	}

}


class ThreadEx12_02 extends Thread {
	public void run() {
		for( int i = 0; i< 300; i++ ) {
			System.out.print("X");
		}
		System.out.println("<<th2 ����>>");
	}	

}