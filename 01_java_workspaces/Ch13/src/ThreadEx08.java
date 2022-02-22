
public class ThreadEx08 {

	public static void main(String[] args) {
		ThreadEx08_01 th1 = new ThreadEx08_01();
		ThreadEx08_02 th2 = new ThreadEx08_02();
		
		th2.setPriority(10);
		
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(|) : " + th2.getPriority());
		th1.start();
		th2.start();
	}

}

class ThreadEx08_01 extends Thread {
	public void run() {
		for( int i = 0; i < 300; i++ ) {
			System.out.print("-");
			for( int x = 0; x < 10000000; x++ );
		}
	}
}

class ThreadEx08_02 extends Thread {
	public void run() {
		for( int i = 0; i < 300; i++ ) {
			System.out.print("|");
			for( int x = 0; x < 10000000; x++ );
		}
	}
}