
public class ThreadEx09 {

	public static void main(String[] args) {
		ThreadGroup main = Thread.currentThread().getThreadGroup();					// 현재 Thread의 ThreadGroup을 main에 대입.
		ThreadGroup grp1 = new ThreadGroup("Group1");								// Group1이라는 이름의 ThreadGroup의 참조변수 'grp1' 생성.
		ThreadGroup grp2 = new ThreadGroup("Group2");
		
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");					// grp1이 가르키는 Group1 ThreadGroup안에 SubGroup1이라는 이름의 ThreadGroup을 생성.
		
		grp1.setMaxPriority(3);														// 
		
		Runnable r = new Runnable() {												// 익명 클래스로 Runnable의 run() 구현
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		};
		
		new Thread(grp1, r, "th1").start();											// grp1이 가르키는 ThreadGroup에 th1 Thread 생성.
		new Thread(subGrp1, r, "th2").start();
		new Thread(grp2, r, "th3").start();
		
		System.out.println(">>List of ThreadGroup : " + main.getName()
						 + " , Active ThreadGroup : " + main.activeGroupCount()
						 + " , Active Thread : " + main.activeCount()
						  );
		main.list();																// main 의 모든 Thread정보
		
	}

}

