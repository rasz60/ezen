import java.util.Scanner;

public class ArrayEx20 {

	public static void main(String[] args) {
		// final : ��� ���� (������ �빮��)
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
		
		// board �迭�� '-'�� ��� ä��
		for ( int i = 0; i < SIZE; i++ ) {
			for ( int j = 0; j < SIZE; j++ ) {
				board[i][j] = '-';
			}
		}
/*		
		��,�� ���й�ȣ �־��ֱ�
		board[i][0]�� 'i+0'�� char���� �־��ְ�,
		board[0][i] ���� �����Ѵ�.
		char '0'�� �ƽ�Ű �ڵ尪�� i�� ���ؼ� �ش� �ڵ尪�� char�� ����
 */
		for ( int i = 0; i < SIZE; i++ ) {
			board[i][0] = (char)(i + '0');
			board[0][i] = board[i][0];
		}
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.printf("��ǥ�� �Է��ϼ���.(���� : 00)>");
			String input = sc.nextLine();

			if (input.length() == 2) {
				x = input.charAt(0) - '0'; // input�� 0��° char�� �ڵ尪���� '0'�� �ڵ尪�� int�� x�� ����
				y = input.charAt(1) - '0';
				
				if (x == 0 && y == 0 ) break;
			}
			
			if (input.length() != 2 || x <= 0 || x > SIZE || y <= 0 || y >= SIZE) {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			
			//�ߺ����� �ԷµǸ� ��� - �߰��� ȥ�� �غ�
			if (board[x][y] == 'X' || board[x][y] == 'O') {
				System.out.println("�̹� Ȯ���� ���Դϴ�. �ٽ� �Է����ּ���.");
				continue;	
			}
			
			
			board[x][y] = shipBoard[x-1][y-1] == 1 ? 'O': 'X';
			
			//board[i]�࿡ 1���� �迭 char[i]���� String���� ��� 
			for (int i = 0; i < SIZE; i++) {
				System.out.print(board[i]);
				System.out.println();
			}

		}
	}
}