
public class ThreadEx19 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx19_01 th1 = new ThreadEx19_01();
		ThreadEx19_02 th2 = new ThreadEx19_02();
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join();
			th2.join();
		} catch(InterruptedException e) {}
		
		System.out.println("\nmain �ҿ�ð� : " + (System.currentTimeMillis() - startTime));
		
	}

}

class ThreadEx19_01 extends Thread {

	public void run() {
		for( int i = 0; i < 300; i++ ) {
			System.out.print(new String("="));
		}
		System.out.println("\nth1 �ҿ�ð� : " + (System.currentTimeMillis() - ThreadEx19.startTime));
	}

}

class ThreadEx19_02 extends Thread {

	public void run() {
		for( int i = 0; i < 300; i++ ) {
			System.out.print(new String("|"));
		}		
		System.out.println("\nth2 �ҿ�ð� : " + (System.currentTimeMillis() - ThreadEx19.startTime));
	}
	
}
