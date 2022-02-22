import javax.swing.JOptionPane;

public class ThreadEx14 {

	public static void main(String[] args) throws Exception {
		ThreadEx14_01 th1 = new ThreadEx14_01();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		th1.interrupt();
		System.out.println("isInterrupted() : " + th1.isInterrupted());
	}

}

class ThreadEx14_01 extends Thread {
	public void run() {
		int i = 10;
		
		while ( i != 0 && !isInterrupted() ) {
			System.out.println(i--);
			try {
				Thread.sleep(1000);							// 1초에 한 번씩 sleep()을 진행한 후에 Interrupted 값을 false로 초기화되기 때문에 중지되지 않고 계속 진행.
			} catch(InterruptedException e) {
				//interrupt();								// catch문에서 Interrupt가 발생하면 어떻게 처리할지 넣어주면 중지할 수 있다.
			}												
		}													
		System.out.println("카운트 종료.");
	}
}