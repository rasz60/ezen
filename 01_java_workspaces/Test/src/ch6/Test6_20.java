package ch6;

public class Test6_20 {

	static int[] shuffle(int[] arr) {
		int[] result = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++ ) {
				int suffle = (int)(Math.random() * 10 - 1);
				int tmp = arr[i];
				arr[i] = arr[suffle];
				arr[suffle] = tmp;
			}

		return arr;
	}

	public static void main(String[] args) {

		int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(java.util.Arrays.toString(original));

		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

}
