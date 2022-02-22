
public class MyMath3_1 {

	int add ( int a, int b ) {
		System.out.println("add ( int a, int b )");
		return a + b;
	}
	
	long add ( int a, long b ) {
		System.out.println("add ( int a, long b )");
		return a + b;
	}
	
	long add ( long a, int b ) {
		System.out.println("add ( long a, int b )");
		return a + b;
	}
	
	long add ( long a, long b ) {
		System.out.println("add ( long a, long b )");
		return a + b;
	}
	
	int add ( int[] arr ) {
		System.out.println("add ( int[] arr )");
		int sum = 0;
		for (int i : arr)
			sum += i;
		return sum;
	}
}