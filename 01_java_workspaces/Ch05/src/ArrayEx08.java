import java.util.Arrays;

public class ArrayEx08 {

	public static void main(String[] args) {
		// 1~45까지 배열 생성
		int[] ball = new int[45];
		
		for ( int i = 0; i < ball.length; i++ ) {
			ball[i] = i + 1;
		}
		
		// 임시변수 선언
		int tmp = 0;
		int n =0;
		
		// 배열 숫자를 i번 섞음
		for ( int i = 0; i < 6; i++ )  {
			n = (int)(Math.random() * ball.length);
			
			tmp = ball[i];
			ball[i] = ball[n];
			ball[n] = tmp;
			
			System.out.println((i+1) + "번 섞은 배열 (n = " + n + ") : " + Arrays.toString(ball));
		}
				
		// ball[0~5] 값 출력
		System.out.println();
		System.out.println("==================당첨번호==================");
		for ( int i = 0; i < 6; i++ ) {
			System.out.printf("%d\t", ball[i]);
		}
		System.out.println("\n==========================================");
	}

}