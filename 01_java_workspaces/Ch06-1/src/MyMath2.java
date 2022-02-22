class MyMath2 {

	long a, b;
	
	long add() {
		return a + b;
	}
	
	long subtract() {
		return a - b;
	}
	
	long multiply() {
		return a * b;
	}
	
	double divide() {
		return a / b;
	}
	
	
	static long add(long a, long b) {
		return a + b;
	}
	
	static long subtract(long a, long b) {
		return a - b;
	}
	
	static long multiply(long a, long b) {
		return a * b;
	}
	
	static double divide(long a, long b) {
		return (double)a / b;
	}
	
	public static void main(String[] args) {
		
		System.out.println(add(200L, 100L));
		System.out.println(subtract(200L, 100L));
		System.out.println(multiply(200L, 100L));
		System.out.println(divide(200, 100));
		
		System.out.println();
		
		MyMath2 myMath2 = new MyMath2();
		myMath2.a = 200;
		myMath2.b = 100;
		System.out.println(myMath2.add());
		System.out.println(myMath2.subtract());
		System.out.println(myMath2.multiply());
		System.out.println(myMath2.divide());
		
	}
}
