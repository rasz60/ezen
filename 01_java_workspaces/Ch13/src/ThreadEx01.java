
public class ThreadEx01 {

	public static void main(String[] args) {
		ThreadEx01_01 t1 = new ThreadEx01_01();

		Runnable r = new ThreadEx01_02();
		Thread t2 = new Thread(r);						// Thread 생성자 : new Thread(Runnable target)
		
		t1.start();
		t2.start();
		System.out.println("main() 종료.");				// Thread에 작업 실행시키고 main은 종료된다. 각각의 값을 순서없이 처리한다.
	}

}

class ThreadEx01_01 extends Thread {
	public void run() {
		for( int i = 0; i < 50; i++ ) {
			System.out.print(getName() + " ");
		}
	}
}

class ThreadEx01_02 implements Runnable {				// 중복 상속이 되지 않으므로, Runnable implements 형식을 많이 쓴다.
	public void run() {
		for( int i = 0; i < 50; i++ ) {
			System.out.println(Thread.currentThread().getName() + " ");
		}
	}
}