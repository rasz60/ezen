import java.util.Scanner;

public class ArrayEx21_01 {

	public static void main(String[] args) {

		// 2���� 5X5�迭�� ���� ������� �Է�
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
		
		// �迭�� ���ڸ� ����
		
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
		
		// �迭 ���
		for (int i = 0; i < SIZE; i++ ) {
			for (int j = 0; j < SIZE; j++ ) {
				System.out.print(bingo[i][j] + "\t");
			}
			System.out.println();
		}

		
		// 2�ڸ� ���ڸ� �Է��ؼ� 'x''y' -> [x][y]�� ���� 'X'�� �ٲ��ش�
		Scanner sc = new Scanner(System.in);
		System.out.printf("1~%d���� ���ڸ� �Է����ּ���.(���� 0) > ", SIZE*SIZE);
		String input = sc.nextLine();
		int num = 0;
		//�ݺ��ϰԲ�
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
				
		// �ٲ� �� ���
		
		
		
		
		
		// �߰� 1. �ߺ��� �޽���
		
		
		
		// �߰� 2. ��� ���� X�� �Ǹ� ����
		
		
		
		// �߰� 3. ����, ����, �밢�� �� ��� x�� �Ǹ� ���� ���� �߰�... �̰� ��..
	}

}