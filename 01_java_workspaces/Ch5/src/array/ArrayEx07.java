package array;

import java.util.Arrays;

public class ArrayEx07 {

	public static void main(String[] args) {
		//�迭 ���� ����
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(arr));
		System.out.println();
		
		for (int i = 0; i < 100; i++) {
			int n = (int)(Math.random() * 10);
			
			int tmp = arr[0];
			arr[0] = arr[n];
			arr[n] = tmp;
			System.out.println((i+1) + "�� ���� ��� (n : " + n + ") : " + Arrays.toString(arr));
		}
		
		System.out.println("\n���� �迭\n" + Arrays.toString(arr));

	}
}
