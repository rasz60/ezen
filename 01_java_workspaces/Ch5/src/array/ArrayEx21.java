package array;

import java.util.Scanner;

public class ArrayEx21 {

	public static void main(String[] args) {

		final int SIZE = 5;
		int x = 0, y = 0, num = 0;
		
		int [][] bingo = new int[SIZE][SIZE];
		Scanner sc = new Scanner(System.in);
		
		int no = 1;
		for ( int i = 0; i < SIZE; i++ ) {
			for ( int j = 0; j < SIZE; j++ ) {
				//bingo[i][j] = i * SIZE + j + i;
				bingo[i][j] = no++;
			}
		}
		
		for ( int i = 0; i < SIZE; i++ ) {
			for ( int j = 0; j < SIZE; j++ ) {
				x = (int)(Math.random() * SIZE);
				y = (int)(Math.random() * SIZE);
				
				int tmp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;
			}
		}
		
		do {
			for ( int i = 0; i < SIZE; i++ ) {
				for ( int j = 0; j < SIZE; j++ ) 
					System.out.printf("%2d ", bingo[i][j]);
				System.out.println();
		}
		System.out.println();
		
		System.out.printf("1~%d의 숫자를 입력하세요.(종료 0)>", SIZE*SIZE);
		String str = sc.nextLine();
		num = Integer.parseInt(str);

		outer : 
			for ( int i = 0; i < SIZE; i++ ) {
				for ( int j = 0; j < SIZE; j++ ) {
					// 끝내면 outer 밖으로 나감
					if (bingo[i][j] == num) {
						bingo[i][j] = 0;
						break outer;
					}
				}
			}
		} while (num != 0);
	}
}
