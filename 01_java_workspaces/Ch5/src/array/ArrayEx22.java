package array;

public class ArrayEx22 {

	public static void main(String[] args) {
		//��İ� ���ϱ�(��Ī���� �����Ҷ��� ����)
		
		// 2�� 3�� �迭 ����
		int[][] m1 = {
				{1, 2, 3},
				{4, 5, 6}
		};
		
		// 3�� 2�� �迭 ����
		int[][] m2 = {
				{1, 2},
				{3, 4},
				{5, 6}
		};
		
		//m1�� �� ����
		final int ROW = m1.length;

		//m2[0]�� �� ����
		final int COL = m2[0].length;

		//m2�� �� ����
		final int M2_ROW = m2.length;
		
		//m3 �� ���� = m1�� �� ����, �� ���� = m2�� �� ����
		int[][] m3 = new int[ROW][COL];
		
		
		//m1[i][k] * m2[k][j] k++ ���� -> j++ -> i++(�������) ����
		for ( int i = 0; i < ROW; i++ ) {
			for ( int j = 0; j <COL; j++ ) {
				for ( int k = 0; k < M2_ROW; k++ ) {
					m3[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		
		for ( int[] i : m3 ) {
			for ( int j : i ) {
				System.out.print(j + "\t");
			}
		System.out.println();
		}
	}
}