package array;

public class ArrayEx06 {

	public static void main(String[] args) {
		// �迭�� �ִ밪, �ּҰ� ���ϱ�
		int[] score = { 79, 88, 91, 33, 100, 55, 95 };
		
		//�ִ밪(max), �ּҰ�(min) ���� �����ϰ�, score[0] �� ����
		int max = score[0];
		int min = score[0];
		

		for ( int i = 1; i < score.length; i++ ) {
			//score[1]���� ���Ͽ� max(score[0])���� ū ���̸� max�� ����
			if ( score[i] > max ) {
				max = score[i];
			}

			//score[1]���� ���Ͽ� min(score[0])���� ���� ���̸� min�� ����
			else if ( score[i] < min ) {
				min = score[i];
			}
		}

		System.out.println("score �迭 �ִ밪�� " + max + "�Դϴ�.");
		System.out.println("score �迭 �ּҰ��� " + min + "�Դϴ�.");
		
	}

}
