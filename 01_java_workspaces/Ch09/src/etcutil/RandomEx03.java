package etcutil;

import java.util.Arrays;
import java.util.Random;

public class RandomEx03 {

	public static void main(String[] args) {
		System.out.println("getRand TEST ---------");
		System.out.print("[");
		for ( int i = 0; i < 10; i++ ) {
			if ( i < 9 ) {
				System.out.print(getRand(5, 10) + ", ");
			} else {
				System.out.print(getRand(5, 10));
			}
		}
		System.out.println("]");
		System.out.println();
		
		int[] result = fillRand(new int[10], new int[] { 2, 3, 7, 5 });
		System.out.println("result ---------------");
		System.out.println(Arrays.toString(result));
		System.out.println("result2 --------------");
		// fillRand(int[] arr, int from, int to) 사용
		int[] result2 = fillRand(new int[10], 5, 10);
		System.out.println(Arrays.toString(result2));
	}
	
	public static int[] fillRand(int[] arr, int from, int to) {
		for ( int i = 0; i < arr.length; i++ ) {
			arr[i] = getRand(from, to);
		}
		return arr;
	}
	
	public static int[] fillRand(int[] arr, int[] data) {
		for ( int i = 0; i < arr.length; i++ ) {
			arr[i] = data[getRand(0, data.length - 1)];
		}
		return arr;
	}

	public static int getRand(int from, int to) {
		return (int) (Math.random() * (Math.abs(to-from) + 1)) + Math.min(from, to);				// Math.abs() : 절대 값
	}

}
