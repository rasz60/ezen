
public class ThreadEx10 implements Runnable {
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx10());				// Runnable Interface를 implements했을 때, 인스턴스 생성은 new Thread(new 클래스명);
		t.setDaemon(true);
		t.start();
		
		for( int i = 1; i <= 10; i++ ) {
			try{
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			System.out.println(i);
			if( i == 3 ) {
				autoSave = true;
			}
		}
		System.out.println("프로그램을 종료합니다.");
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000);
			} catch(InterruptedException e) {}
			
			if(autoSave) {
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("작업 파일이 자동저장되었습니다.");
	}
}
