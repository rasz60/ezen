public class ArrayEx03 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		//배열에 1~5까지 element 대입
		for( int i = 0; i < arr.length; i++ ) {
			arr[i] = i + 1;
		}
		//배열의 길이와 각 element 값이 몇인지 출력 : 5
		System.out.println("변경 전 - arr.length : " + arr.length);
		
		for ( int i = 0; i < arr.length; i++ ) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
		//arr 배열의 길이 2배인 배열 생성
		int[] tmp = new int[arr.length*2];
		
		//arr 배열의 길이만큼 tmp 배열에 element 값 복사
		for (int i = 0; i < arr.length; i++ ) {
			tmp[i] = arr[i];
		}
		// tmp을 arr로 대입.. 이렇게도 되는구나..!
		arr = tmp;
		
		//변경된 arr 길이와 element 출력
		System.out.println("변경 후 - arr.length : " + arr.length);
		for ( int i = 0; i < arr.length; i++ ) {
			System.out.println("arr["+ i + "] : " + arr[i]);
			System.out.println("tmp["+ i + "] : " + tmp[i]);
		}
	}

}
