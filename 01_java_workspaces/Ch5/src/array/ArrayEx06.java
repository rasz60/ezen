package array;

public class ArrayEx06 {

	public static void main(String[] args) {
		// 배열의 최대값, 최소값 구하기
		int[] score = { 79, 88, 91, 33, 100, 55, 95 };
		
		//최대값(max), 최소값(min) 변수 선언하고, score[0] 값 대입
		int max = score[0];
		int min = score[0];
		

		for ( int i = 1; i < score.length; i++ ) {
			//score[1]부터 비교하여 max(score[0])보다 큰 값이면 max에 대입
			if ( score[i] > max ) {
				max = score[i];
			}

			//score[1]부터 비교하여 min(score[0])보다 작은 값이면 min에 대입
			else if ( score[i] < min ) {
				min = score[i];
			}
		}

		System.out.println("score 배열 최대값은 " + max + "입니다.");
		System.out.println("score 배열 최소값은 " + min + "입니다.");
		
	}

}
