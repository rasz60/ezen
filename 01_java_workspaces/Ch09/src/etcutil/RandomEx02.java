package etcutil;

import java.util.Random;

public class RandomEx02 {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] number = new int[100];
		int[] counter = new int[10];
		
		for( int i = 0; i < number.length; i++ ) {
			System.out.print("[");
			System.out.print(number[i] = rand.nextInt(10));											// 0 <= x < 10 int 랜덤으로 생성하여 number[i]에 넣어준다.
			System.out.print("]");
		}
		System.out.println();
		System.out.println();
		System.out.println("WHO GOTTA TOP SCORE??????????????");
		
		for( int i = 0; i < number.length; i++ ) {
			counter[number[i]]++;
		}
		
		for ( int i = 0; i < counter.length; i++ ) {
			System.out.println("["+ i + "] : " + printGraph('☆', counter[i]) + " " + counter[i]);
		}
		
	}
	
	public static String printGraph(char ch, int value) {
		char[] bar = new char[value];
		
		for ( int i = 0; i < bar.length; i++ ) {
			bar[i] = ch;
		}
		return new String(bar);
	}

}
