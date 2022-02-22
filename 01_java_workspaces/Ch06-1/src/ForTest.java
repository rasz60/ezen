public class ForTest {

	public static void main(String[] args) {

		for ( int i = 0; i < 4; i++ ) {
			int resultJ = 0;
			System.out.printf("i는 %d이고, j는 %d인 상태로 반복 실행.%n", i, resultJ);
			for ( int j = 0; j < 4; j++ ) {
				System.out.printf("i는 %d이고, j는 %d으로 반복 실행. j++%n", i, j);
				resultJ = j;
			}
			System.out.printf("j는 %d까지 반복 종료. i++ 실행%n%n", resultJ);
		}
		System.out.printf("반복 종료%n");
		
	}
}