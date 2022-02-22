import java.util.concurrent.*;

public class ForkJoinEx01 {
	static final ForkJoinPool pool = new ForkJoinPool();

	public static void main(String[] args) {
		long from = 1L, to = 100_000_000L;
		
		SumTask task = new SumTask(from, to);
		
		Long start = System.currentTimeMillis();
		Long result = pool.invoke(task);
		System.out.println("Elaspsed time(4 core) : " + (System.currentTimeMillis() - start));
		
		System.out.printf("sum of %d ~ %d = %d%n", from, to, result);
		System.out.println();
		
		result = 0L;
		start = System.currentTimeMillis();
		for( long i = 0; i <= to; i++ ) {
			result += i;
		}
		
		System.out.println("Elaspsed time(1 core) : " + (System.currentTimeMillis() - start));
		System.out.printf("sum of %d ~ %d = %d%n", from, to, result);
 	}

}

class SumTask extends RecursiveTask<Long> {
	long from, to;
	
	SumTask(long from, long to) {
		this.from = from;
		this.to = to;
	}
		
	@Override
	protected Long compute() {
		long size = to - from + 1;
		
		//System.out.printf("from : %3d, to : %3d, size : %3d%n", from, to, size);
		
		if ( size <= 5 ) {
			return sum();
		}
		
		long half = (from + to) / 2;
		
		SumTask leftSum = new SumTask(from, half);
		SumTask rightSum = new SumTask(half+1, to);
		
		leftSum.fork();
		
		return rightSum.compute() + leftSum.join();
	}
	
	long sum() {
		long tmp = 0L;
		
		for( long i = from; i <= to; i++ ) {
			tmp += i;
		}
		
		return tmp;
	}
	
}
