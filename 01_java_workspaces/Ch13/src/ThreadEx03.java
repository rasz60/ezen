
public class ThreadEx03 {

	public static void main(String[] args) {
		ThreadEx03_01 t1 = new ThreadEx03_01();
		t1.run();
		System.out.println("main() 종료.");
	}

}

class ThreadEx03_01 extends Thread {
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