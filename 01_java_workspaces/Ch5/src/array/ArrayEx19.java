package array;

public class ArrayEx19 {

	public static void main(String[] args) {

		int[][] score = {
							{ 100, 100, 100 },
							{ 20, 20, 20 },
							{ 30, 30, 30 },
							{ 40, 40, 40 },
							{ 50, 50, 50 }
						};
		
		System.out.println("��ȣ\t����\t����\t����\t����\t���");
		System.out.println("=============================================");
		
		// k = ��ȣ
		int k = 1;
		for (int i = 0; i < score.length; i++ ) {
			System.out.print(k + "\t");
			int sum = 0;
			float average = 0f;
			
			for (int j = 0; j < score[i].length; j++ ) {
				System.out.print(score[i][j] + "\t");
				sum += score[i][j];
			}
			System.out.print(sum + "\t");
			average = (float)sum / score[i].length;
			System.out.printf(average + "\t");			
			System.out.println();
			k++;
		}
		System.out.println("=============================================");
		System.out.printf("����");

		// 1���� �迭 tmp[j]�� score[i] �� ��� ���� ���� ���� �ϰ� ���� j++
		int[] tmp = new int[score[0].length];
		int i = 0;
		for (int j = 0; j < score[i].length; j ++) {
			for (i = 0; i < score.length; i++ ) {
				tmp[j] += score[i][j];
			}
			System.out.print("\t" + tmp[j]);
		}
	}
}