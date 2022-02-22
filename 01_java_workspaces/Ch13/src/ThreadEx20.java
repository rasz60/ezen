
public class ThreadEx20 {

	public static void main(String[] args) {
		ThreadEx20_01 gc = new ThreadEx20_01();
		gc.setDaemon(true);
		gc.start();
		
		int requiredMemory = 0;
		
		for( int i = 0; i < 20; i++ ) {
			requiredMemory = (int)(Math.random() * 10 ) * 20;
			
			if( gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4 ) {
				gc.interrupt();																		// gc를 interrupt만 하고 작업하는 시간동안 기다리지 않기 때문에, if문 조건을 충족해도 main의 작업은 계속 수행한다.
				try {																				// gc를 interrupt한 후에 100millis동안 기다리고 다시 main의 작업을 수행한다.
					gc.join();
				} catch(InterruptedException e) {}
			}
			
			gc.usedMemory += requiredMemory;
			System.out.printf("#%2d. requiredMemory : %d, usedMemory : %d%n", i+1, requiredMemory, gc.usedMemory);
		}
	}

}

class ThreadEx20_01 extends Thread {
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	boolean work = false;
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10 * 1000);
			} catch(InterruptedException e) {
				System.out.println("Awaken by interrupt() ! ! ! Time to work, gc() ! ! !");
			}
			
			gc();
			System.out.printf("Garbage Collected. Used Memory : %d, Free Memory :%d%n", usedMemory, freeMemory());
		}
	}

	public void gc() {
		while ( work ) {
			usedMemory -= 300;
			if ( freeMemory() < MAX_MEMORY * 0.4 ) {
				work = true;
			} else if ( freeMemory() < 0 ) {
				usedMemory = 0;
				work = true;
			} else {
				continue;
			}
		}		
	}

	public int totalMemory() {
		return MAX_MEMORY;
	}

	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}

}