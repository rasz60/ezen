
public class ThreadEx02 {

	public static void main(String[] args) {
		ThreadEx02_01 t1 = new ThreadEx02_01();
		t1.start();
		System.out.println("main() 종료.");
	}

}

class ThreadEx02_01 extends Thread {
	public void run() {
		throwException();
	}
	
	public void throwException() {
		try {
			throw new Exception("ThreadEx02_01이 일으킨 EXCEPTION.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}