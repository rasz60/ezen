package array;

public class ArrayEx22 {

	public static void main(String[] args) {
		//행렬곱 구하기(대칭으로 수립할때만 가능)
		
		// 2행 3열 배열 생성
		int[][] m1 = {
				{1, 2, 3},
				{4, 5, 6}
		};
		
		// 3행 2열 배열 생성
		int[][] m2 = {
				{1, 2},
				{3, 4},
				{5, 6}
		};
		
		//m1의 행 개수
		final int ROW = m1.length;

		//m2[0]의 열 개수
		final int COL = m2[0].length;

		//m2의 행 개수
		final int M2_ROW = m2.length;
		
		//m3 행 개수 = m1의 행 개수, 열 개수 = m2의 열 개수
		int[][] m3 = new int[ROW][COL];
		
		
		//m1[i][k] * m2[k][j] k++ 누적 -> j++ -> i++(순서대로) 수행
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