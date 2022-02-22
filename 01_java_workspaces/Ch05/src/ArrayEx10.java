import java.util.Arrays;

public class ArrayEx10 {

	public static void main(String[] args) {
		//오름차순 정렬
		int[] numArr = new int[5];
	 	
		for ( int i = 0; i < numArr.length; i++ ) {
			numArr[i] = (int)(Math.random() * numArr.length);
		}
		System.out.println(Arrays.toString(numArr));
		System.out.println();
		
		//numArr의 길이 - 1만큼 반복. changed는 false 초기화.
		for ( int i = 0; i < numArr.length-1; i++ ) {
			boolean changed = false;
			//반복문을 수행하면서 젤 뒤로 보내진 값이 제일 큰 값이므로,
			//앞선 반복에서 뒤로 보내진 값을 제외하고 수행하기 위해 length - i를 실행(없어도 결과는 같음)
			for ( int j = 0; j < numArr.length-1-i; j++ ) {
				// 만약 j번째 값이 j+1번째 값보다 크면 if문 수행
				if (numArr[j] > numArr[j+1]) {
					int tmp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = tmp;
					//changed에 true 대입
					changed = true;
				}
			}
			// 변수 j에 대한 for문을 수행하고, changed가 true로 바뀌면 증감식 수행.
			// 변수 j에 대한 for문을 수행하고, changed가 false이면 break.
			if (! changed) {
				break;
			}

			for(int k = 0; k < numArr.length; k++ ) {
				System.out.print(numArr[k]);
			}
			System.out.println();
		}
	}
}