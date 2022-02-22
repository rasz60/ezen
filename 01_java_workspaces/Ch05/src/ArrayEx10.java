import java.util.Arrays;

public class ArrayEx10 {

	public static void main(String[] args) {
		//�������� ����
		int[] numArr = new int[5];
	 	
		for ( int i = 0; i < numArr.length; i++ ) {
			numArr[i] = (int)(Math.random() * numArr.length);
		}
		System.out.println(Arrays.toString(numArr));
		System.out.println();
		
		//numArr�� ���� - 1��ŭ �ݺ�. changed�� false �ʱ�ȭ.
		for ( int i = 0; i < numArr.length-1; i++ ) {
			boolean changed = false;
			//�ݺ����� �����ϸ鼭 �� �ڷ� ������ ���� ���� ū ���̹Ƿ�,
			//�ռ� �ݺ����� �ڷ� ������ ���� �����ϰ� �����ϱ� ���� length - i�� ����(��� ����� ����)
			for ( int j = 0; j < numArr.length-1-i; j++ ) {
				// ���� j��° ���� j+1��° ������ ũ�� if�� ����
				if (numArr[j] > numArr[j+1]) {
					int tmp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = tmp;
					//changed�� true ����
					changed = true;
				}
			}
			// ���� j�� ���� for���� �����ϰ�, changed�� true�� �ٲ�� ������ ����.
			// ���� j�� ���� for���� �����ϰ�, changed�� false�̸� break.
			if (! changed) {
				break;
			}

			for(int k = 0; k < numArr.length; k++ ) {
				System.out.print(numArr[k]);
			}
			System.out.println();
		}
	}
}