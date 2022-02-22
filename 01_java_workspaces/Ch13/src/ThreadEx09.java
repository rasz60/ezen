
public class ThreadEx09 {

	public static void main(String[] args) {
		ThreadGroup main = Thread.currentThread().getThreadGroup();					// ���� Thread�� ThreadGroup�� main�� ����.
		ThreadGroup grp1 = new ThreadGroup("Group1");								// Group1�̶�� �̸��� ThreadGroup�� �������� 'grp1' ����.
		ThreadGroup grp2 = new ThreadGroup("Group2");
		
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");					// grp1�� ����Ű�� Group1 ThreadGroup�ȿ� SubGroup1�̶�� �̸��� ThreadGroup�� ����.
		
		grp1.setMaxPriority(3);														// 
		
		Runnable r = new Runnable() {												// �͸� Ŭ������ Runnable�� run() ����
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		};
		
		new Thread(grp1, r, "th1").start();											// grp1�� ����Ű�� ThreadGroup�� th1 Thread ����.
		new Thread(subGrp1, r, "th2").start();
		new Thread(grp2, r, "th3").start();
		
		System.out.println(">>List of ThreadGroup : " + main.getName()
						 + " , Active ThreadGroup : " + main.activeGroupCount()
						 + " , Active Thread : " + main.activeCount()
						  );
		main.list();																// main �� ��� Thread����
		
	}

}

