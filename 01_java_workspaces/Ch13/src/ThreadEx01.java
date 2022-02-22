
public class ThreadEx01 {

	public static void main(String[] args) {
		ThreadEx01_01 t1 = new ThreadEx01_01();

		Runnable r = new ThreadEx01_02();
		Thread t2 = new Thread(r);						// Thread ������ : new Thread(Runnable target)
		
		t1.start();
		t2.start();
		System.out.println("main() ����.");				// Thread�� �۾� �����Ű�� main�� ����ȴ�. ������ ���� �������� ó���Ѵ�.
	}

}

class ThreadEx01_01 extends Thread {
	public void run() {
		for( int i = 0; i < 50; i++ ) {
			System.out.print(getName() + " ");
		}
	}
}

class ThreadEx01_02 implements Runnable {				// �ߺ� ����� ���� �����Ƿ�, Runnable implements ������ ���� ����.
	public void run() {
		for( int i = 0; i < 50; i++ ) {
			System.out.println(Thread.currentThread().getName() + " ");
		}
	}
}