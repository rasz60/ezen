public class ForTest {

	public static void main(String[] args) {

		for ( int i = 0; i < 4; i++ ) {
			int resultJ = 0;
			System.out.printf("i�� %d�̰�, j�� %d�� ���·� �ݺ� ����.%n", i, resultJ);
			for ( int j = 0; j < 4; j++ ) {
				System.out.printf("i�� %d�̰�, j�� %d���� �ݺ� ����. j++%n", i, j);
				resultJ = j;
			}
			System.out.printf("j�� %d���� �ݺ� ����. i++ ����%n%n", resultJ);
		}
		System.out.printf("�ݺ� ����%n");
		
	}
}