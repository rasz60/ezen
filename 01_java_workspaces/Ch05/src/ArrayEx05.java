public class ArrayEx05 {

	public static void main(String[] args) {

		int sum = 0;
		float average = 0f;
		
		int[] arr = {100, 88, 95, 70, 80};
		
		//배열의 값을 하나씩 sum에 누적
		for (int i = 0; i < arr.length; i++ )
			sum += arr[i];
				
		//for문으로 구한 sum을 배열 길이로 나누어서 평균 구하기
		//float으로 형변환하여 실수 표현
		average = (float)sum / arr.length;
		
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + average);
		
	}

}