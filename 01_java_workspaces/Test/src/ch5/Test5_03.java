package ch5;

public class Test5_03 {

	public static void main(String[] args) {

		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for ( int i = 0; i < arr.length; i++ ) {
			sum += arr[i];
		}
		
		int sum1 = 0;
		for ( int i : arr) {
			sum1 += i;
		}
		
		System.out.println(sum);
		System.out.println(sum1);
	}

	
}
