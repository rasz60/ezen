import javax.swing.JOptionPane;

public class ThreadEx07 {

	public static void main(String[] args) {
		ThreadEx07_01 th1 = new ThreadEx07_01();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
	}
}

class ThreadEx07_01 extends Thread {
	public void run() {
		for( int i = 10; i > 0; i-- ) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (Exception e) {}
		}
	}
}