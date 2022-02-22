package waitex03;

public class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {
		this.table = table;
	}
	
	@Override
	public void run() {
		while(true) {
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			System.out.println(" + " + table.dishNames[idx] + " Ãß°¡");
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {}
		}
	}
	
}