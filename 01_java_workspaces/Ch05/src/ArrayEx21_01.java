import java.util.Scanner;

public class ArrayEx21_01 {

	public static void main(String[] args) {

		// 2차원 5X5배열에 숫자 순서대로 입력
		final int SIZE = 5;
		int x = 0; int y = 0;
		int k = 1;
		
		int[][] bingo = new int[SIZE][SIZE];

		for ( int i = 0; i < SIZE; i++ ) {
			for ( int j = 0; j < SIZE; j++ ) {
				bingo[i][j] = k;
				k++;
			}
		}
		
		// 배열의 숫자를 섞음
		
		for ( int i = 0; i <SIZE; i++ ) {
			for ( int j = 0; j < SIZE; j++ ) {
				int tmp = 0;
				x = (int)(Math.random() * (SIZE)); 
				y = (int)(Math.random() * (SIZE)); 
				
				tmp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;
			}
		}
		
		// 배열 출력
		for (int i = 0; i < SIZE; i++ ) {
			for (int j = 0; j < SIZE; j++ ) {
				System.out.print(bingo[i][j] + "\t");
			}
			System.out.println();
		}

		
		// 2자리 숫자를 입력해서 'x''y' -> [x][y]의 값을 'X'로 바꿔준다
		Scanner sc = new Scanner(System.in);
		System.out.printf("1~%d까지 숫자를 입력해주세요.(종료 0) > ", SIZE*SIZE);
		String input = sc.nextLine();
		int num = 0;
		//반복하게끔
			if (input.length() == 1 || input.length() == 2) {
				x = input.charAt(0) - '0';
				y = input.charAt(1) - '0';		
				num = x + y;
				for ( int i = 0; i < SIZE; i++ ) {
					for ( int j = 0; j < SIZE; j++ ) {
						if (bingo[i][j] == num) {
							bingo[i][j] = 0;
						}
						System.out.print(bingo[i][j] + "\t");
					}
					System.out.println();
				
				}
			}
				
		// 바꾼 값 출력
		
		
		
		
		
		// 추가 1. 중복값 메시지
		
		
		
		// 추가 2. 모든 값이 X가 되면 종료
		
		
		
		// 추가 3. 가로, 세로, 대각선 중 모두 x가 되면 빙고 갯수 추가... 이건 좀..
	}

}