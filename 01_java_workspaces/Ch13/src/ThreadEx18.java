
public class ThreadEx18 {
	static long startTime;
	
	public static void main(String[] args) {
		ThreadEx18_01 th1 = new ThreadEx18_01("#1");
		ThreadEx18_01 th2 = new ThreadEx18_01("#2");
		ThreadEx18_01 th3 = new ThreadEx18_01("#3");
		th1.start();
		th2.start();
		th3.start();
		startTime = System.currentTimeMillis();
		
		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch(InterruptedException e) {}
		
		System.out.println("main의 작업 소요시간 : " + (System.currentTimeMillis() - ThreadEx18.startTime));
	}

}

class ThreadEx18_01 implements Runnable {
	boolean suspended = false;
	boolean stopped = false;
	
	Thread th;
	
	ThreadEx18_01(String name) {
		th = new Thread(this, name);
	}
	
	@Override
	public void run() {
		String name = th.getName();
		
		while(!stopped) {
			if(!suspended) {
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					System.out.println(name + " - interrupted.");
				}
			} else {
				Thread.yield();
			}
		}
		System.out.println(name + " - stopped.");
		System.out.println(th.getName() + "의 작업 소요시간 : " + (System.currentTimeMillis() - ThreadEx18.startTime));
	}
	
	public void suspend() {
		suspended = true;
		th.interrupt();
		System.out.println(th.getName() + " - interrupt() by suspend().");
	}
	
	public void stop() {
		stopped = true;
		th.interrupt();
		System.out.println(th.getName() + " - interrupt() by stop().");
	}
	
	public void resume() {
		suspended = false;
		System.out.println(th.getName() + " - resume().");
	}
	
	public void start() {
		th.start();
	}

}