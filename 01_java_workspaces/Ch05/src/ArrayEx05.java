public class ArrayEx05 {

	public static void main(String[] args) {

		int sum = 0;
		float average = 0f;
		
		int[] arr = {100, 88, 95, 70, 80};
		
		//�迭�� ���� �ϳ��� sum�� ����
		for (int i = 0; i < arr.length; i++ )
			sum += arr[i];
				
		//for������ ���� sum�� �迭 ���̷� ����� ��� ���ϱ�
		//float���� ����ȯ�Ͽ� �Ǽ� ǥ��
		average = (float)sum / arr.length;
		
		System.out.println("���� : " + sum);
		System.out.println("��� : " + average);
		
	}

}