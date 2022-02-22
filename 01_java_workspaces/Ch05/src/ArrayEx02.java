import java.util.Arrays;

public class ArrayEx02 {

	public static void main(String[] args) {

		int[] iArr1 = new int[10];
		int[] iArr2 = new int[10];
//		int[] iArr3 = new int[] {100, 95, 80, 70, 60};
		int[] iArr3 = {100, 95, 80, 70, 60};
		char[] chArr = {'a', 'b', 'c', 'd'};
		
		for(int i = 0; i < iArr1.length; i++) {
			iArr1[i] = i + 1;
		}
		
		// iArr2에 랜덤한 
		for (int i = 0; i < iArr2.length; i++) {
			iArr2[i] = (int)(Math.random()*10) + 1;
						   //Math.random 매서드 : 0 ~ 1 사이 값을 랜덤으로 가져옴
		}
		
		// iArr1[0] ~ iArr1[9] 값 출력
		for(int i = 0; i < iArr1.length; i++) {
			System.out.print(iArr1[i] + ",");
		}
		
		System.out.println();
		
		//Arrays.toString = 대괄호([])안에 인덱스 순서대로 값을 나열
		System.out.println(Arrays.toString(iArr2));
		System.out.println(Arrays.toString(iArr3));
		System.out.println(Arrays.toString(chArr));

		//toString 없이 배열 출력 시 메모리 주소 값 출력?
		System.out.println(iArr3);
		
		//char형은 toString 출력 값 정의되어 있음?
		System.out.println(chArr);
	}

}