package etcutil;

import java.util.Random;

public class RandomEx01 {

	public static void main(String[] args) {
		Random rand1 = new Random(3);
		Random rand2 = new Random(2);
		
		System.out.println("= rand1 (seed : 3) =");
		for( int i = 0; i < 5; i++ ) {
			System.out.println((i+1) + "ȸ�� ���� : " + rand1.nextInt());
		}
		
		System.out.println();
		System.out.println("= rand2 (seed : 2) =");
		for( int i = 0; i < 5; i++ ) {
			System.out.println((i+1) + "ȸ�� ���� : " + rand2.nextInt());
		}
		
	}
}
