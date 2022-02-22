package method;

public class MyMath {
	
	long add(long a, long b) {
		long result = a + b;
		return result;
	}
	
	long subtract(long a, long b) {
		return a - b;
	}
	
	long multiply(long a, long b) {
		return a * b;
	}
	
	double divide(long a, long b) {
		return (double)a / b;
	}

	long min (long a, long b) {
		if ( a < b ) return a;
		else return b;
	}
	
	long max (long a, long b) {
		if ( a > b ) return a;
		else return b;
		
	  //return a > b ? b: a;

	}
}