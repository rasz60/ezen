public class ArrayEx18 {

	public static void main(String[] args) {
		// 4�� 3���� 2���� �迭 ����
		int[][] score = {
							{ 100, 100, 100 },
							{ 20, 20, 20 },
							{ 30, 30, 30 },
							{ 40, 40, 40 }
						};
		
		int sum = 0;
		
		// i = �迭�� length(�� ����), j = �迭[i]���� length(�� ����)
		// for������ �� ��Ҹ� ���
		for (int i = 0; i < score.length; i++ ) {
			for (int j = 0; j < score[i].length; j++ ) {
				System.out.printf("score[%d][%d] = %d\n" , i, j, score[i][j]);
			}
		}
		
		// ���� for�� (inhanced for)
		// tmp �迭 �࿡ score ���� �� ��Ҹ� �ҷ���
		for (int[] tmp : score ) {
			// i�� score���� tmp�� ������ �� ���� ��
			for ( int i : tmp ) {
				sum += i;
			}
		}	
		System.out.println("sum = " + sum);
	}
}