public class ArrayEx18 {

	public static void main(String[] args) {
		// 4행 3열의 2차원 배열 선언
		int[][] score = {
							{ 100, 100, 100 },
							{ 20, 20, 20 },
							{ 30, 30, 30 },
							{ 40, 40, 40 }
						};
		
		int sum = 0;
		
		// i = 배열의 length(행 개수), j = 배열[i]행의 length(열 개수)
		// for문으로 각 요소를 출력
		for (int i = 0; i < score.length; i++ ) {
			for (int j = 0; j < score[i].length; j++ ) {
				System.out.printf("score[%d][%d] = %d\n" , i, j, score[i][j]);
			}
		}
		
		// 향상된 for문 (inhanced for)
		// tmp 배열 행에 score 행의 각 요소를 불러옴
		for (int[] tmp : score ) {
			// i는 score에서 tmp로 가져온 각 행의 값
			for ( int i : tmp ) {
				sum += i;
			}
		}	
		System.out.println("sum = " + sum);
	}
}