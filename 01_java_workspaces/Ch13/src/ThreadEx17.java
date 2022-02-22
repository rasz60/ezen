
public class ThreadEx17 {
	static long startTime;
	public static void main(String[] args) {
		RunImplEx17 r1 = new RunImplEx17("*");
		RunImplEx17 r2 = new RunImplEx17("**");
		RunImplEx17 r3 = new RunImplEx17("***");
		r1.start();
		r2.start();
		r3.start();
		startTime = System.currentTimeMillis();
		try {
			Thread.sleep(2000);
			r1.suspend();
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume();
			Thread.sleep(3000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
		} catch(InterruptedException e) {}
	}

}

class RunImplEx17 implements Runnable {
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	Thread th;								
	
	RunImplEx17(String name) {
		th = new Thread(this, name);
	}
	
	@Override
	public void run() {
		while (!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {}
			}
		}
		System.out.println(Thread.currentThread().getName() + " - stopped.");
		System.out.println(th.getName() + " 소요시간 : " + (System.currentTimeMillis() - ThreadEx17.startTime));
	}

	public void suspend() {
		suspended = true;
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void stop() {
		stopped = true;
	}

	public void start() {
		th.start();
	}

}