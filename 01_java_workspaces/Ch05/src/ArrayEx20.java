import java.util.Scanner;

public class ArrayEx20 {

	public static void main(String[] args) {
		// final : 상수 선언 (변수명 대문자)
		final int SIZE = 10;
		int x = 0, y = 0;
		
		char[][] board = new char[SIZE][SIZE];
		byte[][] shipBoard = {
				{0, 0, 0, 0, 0, 0, 1, 0, 0},
				{1, 1, 1, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 1, 1, 0},
		};
		
		// board 배열을 '-'로 모두 채움
		for ( int i = 0; i < SIZE; i++ ) {
			for ( int j = 0; j < SIZE; j++ ) {
				board[i][j] = '-';
			}
		}
/*		
		행,열 구분번호 넣어주기
		board[i][0]에 'i+0'의 char값을 넣어주고,
		board[0][i] 값에 대입한다.
		char '0'의 아스키 코드값에 i를 더해서 해당 코드값의 char를 대입
 */
		for ( int i = 0; i < SIZE; i++ ) {
			board[i][0] = (char)(i + '0');
			board[0][i] = board[i][0];
		}
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.printf("좌표를 입력하세요.(종료 : 00)>");
			String input = sc.nextLine();

			if (input.length() == 2) {
				x = input.charAt(0) - '0'; // input의 0번째 char의 코드값에서 '0'의 코드값을 int로 x에 대입
				y = input.charAt(1) - '0';
				
				if (x == 0 && y == 0 ) break;
			}
			
			if (input.length() != 2 || x <= 0 || x > SIZE || y <= 0 || y >= SIZE) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				continue;
			}
			
			//중복으로 입력되면 출력 - 추가로 혼자 해봄
			if (board[x][y] == 'X' || board[x][y] == 'O') {
				System.out.println("이미 확인한 곳입니다. 다시 입력해주세요.");
				continue;	
			}
			
			
			board[x][y] = shipBoard[x-1][y-1] == 1 ? 'O': 'X';
			
			//board[i]행에 1차원 배열 char[i]값을 String으로 출력 
			for (int i = 0; i < SIZE; i++) {
				System.out.print(board[i]);
				System.out.println();
			}

		}
	}
}