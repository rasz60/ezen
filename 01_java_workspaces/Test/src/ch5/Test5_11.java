package ch5;

public class Test5_11 {

	public static void main(String[] args) {
		int[][] score = {
				{100, 100, 100}
				, {20, 20, 20}
				, {30, 30, 30}
				, {40, 40, 40}
				, {50, 50, 50}
			};
		
	int[][] result = new int[score.length+1][score[0].length+1];
	
	System.out.println("���� ��, ���� �� ���ϱ�\n");
	for(int i=0; i < score.length;i++) {
		for(int j=0; j < score[i].length;j++) {
			result[i][j] = score[i][j];
			result[i][score[i].length] += score[i][j]; //���� �հ�
			result[score.length][j] += score[i][j];    //���� �հ�
			result[score.length][score[i].length] += score[i][j];
	
		}
	}
	
	
	for(int i=0; i < result.length;i++) {
		for(int j=0; j < result[i].length;j++) {
			System.out.printf("%4d",result[i][j]);
		}
		System.out.println();
		}
	} // main
}
