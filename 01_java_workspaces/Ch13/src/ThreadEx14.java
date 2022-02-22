import javax.swing.JOptionPane;

public class ThreadEx14 {

	public static void main(String[] args) throws Exception {
		ThreadEx14_01 th1 = new ThreadEx14_01();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		
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
				Thread.sleep(1000);							// 1�ʿ� �� ���� sleep()�� ������ �Ŀ� Interrupted ���� false�� �ʱ�ȭ�Ǳ� ������ �������� �ʰ� ��� ����.
			} catch(InterruptedException e) {
				//interrupt();								// catch������ Interrupt�� �߻��ϸ� ��� ó������ �־��ָ� ������ �� �ִ�.
			}												
		}													
		System.out.println("ī��Ʈ ����.");
	}
}