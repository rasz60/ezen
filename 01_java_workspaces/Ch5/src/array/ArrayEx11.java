package array;

import java.util.Arrays;

public class ArrayEx11 {

	public static void main(String[] args) {
		//������ �迭 �����ؼ� �� ���ڰ� � �ִ��� ī��Ʈ
		int[] numArr = new int[10];
		int[] counter = new int[10];
		
		for (int i = 0; i < numArr.length; i++ ) {
			numArr[i] = (int)(Math.random() * numArr.length);
		}
		System.out.println(Arrays.toString(numArr));
		
		for ( int i = 0; i < numArr.length; i++ ) {
			counter[numArr[i]] = counter[numArr[i]] + 1;
		}
		
		for ( int i = 0; i < numArr.length; i++ ) {
			System.out.println( i + "�� ���� : " + counter[i]);
		}
				
	}

}
