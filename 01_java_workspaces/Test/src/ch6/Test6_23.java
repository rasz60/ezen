package ch6;

public class Test6_23 {

	static int max(int[] arr) {
		int max;
		if ( arr == null || arr.length == 0 ) {
			max = -999999;
		}
		else {
			max = arr[0];
			for ( int i = 0; i < arr.length - 1; i++ ) {
				max = max < arr[i+1] ? arr[i+1]: max;
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {

		int[] data = {3, 2, 9, 4, 8};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값 : " + max(data));
		System.out.println("최대값 : " + max(null));
		System.out.println("최대값 : " + max(new int[] {}));
	}

}
