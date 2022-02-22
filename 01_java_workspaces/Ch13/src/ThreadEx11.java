import java.util.Iterator;
import java.util.Map;

public class ThreadEx11 {
	public static void main(String[] args) throws Exception {
		ThreadEx11_01 t1 = new ThreadEx11_01("Thread1");
		ThreadEx11_02 t2 = new ThreadEx11_02("Thread2");
		t1.start();
		t2.start();
	}

}

class ThreadEx11_01 extends Thread {
	ThreadEx11_01(String name) {
		super(name);
	}

	public void run() {
		try{
			sleep(5 * 1000);
		} catch(InterruptedException e) {}
	}

}

class ThreadEx11_02 extends Thread {
	ThreadEx11_02(String name) {
		super(name);
	}

	public void run() {
		Map map = getAllStackTraces();
		Iterator it = map.keySet().iterator();
		
		int x = 0;
		while ( it.hasNext() ) {
			Object obj = it.next();
			Thread t = (Thread)obj;
			StackTraceElement[] ste = (StackTraceElement[])(map.get(obj));
			
			System.out.println("[" + ++x + "] name " + t.getName()
							 + ", group : " + t.getThreadGroup().getName()
							 + ", daemon : " + t.isDaemon()
							);
			
			for( int i = 0; i < ste.length; i++ ) {
				System.out.println(ste[i]);
			}
			
			System.out.println();
		}
	}

}
