import java.util.Arrays;

public class ArrayEx08 {

	public static void main(String[] args) {
		// 1~45���� �迭 ����
		int[] ball = new int[45];
		
		for ( int i = 0; i < ball.length; i++ ) {
			ball[i] = i + 1;
		}
		
		// �ӽú��� ����
		int tmp = 0;
		int n =0;
		
		// �迭 ���ڸ� i�� ����
		for ( int i = 0; i < 6; i++ )  {
			n = (int)(Math.random() * ball.length);
			
			tmp = ball[i];
			ball[i] = ball[n];
			ball[n] = tmp;
			
			System.out.println((i+1) + "�� ���� �迭 (n = " + n + ") : " + Arrays.toString(ball));
		}
				
		// ball[0~5] �� ���
		System.out.println();
		System.out.println("==================��÷��ȣ==================");
		for ( int i = 0; i < 6; i++ ) {
			System.out.printf("%d\t", ball[i]);
		}
		System.out.println("\n==========================================");
	}

}