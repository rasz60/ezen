class MyMath3 {
	
	int add ( int a, int b ) {
		System.out.println("int add(int a, int b) ? ");
		return a + b;
	}
	
	long add ( int a, long b ) {
		System.out.println("int add(int a, long b) ? ");
		return a + b;
	}
	
	long add ( long a, int b ) {
		System.out.println("int add(long a, int b) ? ");
		return a + b;
	}
	
	long add ( long a, long b) {
		System.out.println("int add(long a, long b) ? ");
		return a + b;
	}
	
	int add ( int[] a ) {
		System.out.println("int[0 ~ n] total ? ");
		int sum = 0;
		
		for (int i : a) {
			sum += i;
		}
		return sum;
	}
}
