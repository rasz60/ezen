public class ArrayEx03 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		//�迭�� 1~5���� element ����
		for( int i = 0; i < arr.length; i++ ) {
			arr[i] = i + 1;
		}
		//�迭�� ���̿� �� element ���� ������ ��� : 5
		System.out.println("���� �� - arr.length : " + arr.length);
		
		for ( int i = 0; i < arr.length; i++ ) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
		//arr �迭�� ���� 2���� �迭 ����
		int[] tmp = new int[arr.length*2];
		
		//arr �迭�� ���̸�ŭ tmp �迭�� element �� ����
		for (int i = 0; i < arr.length; i++ ) {
			tmp[i] = arr[i];
		}
		// tmp�� arr�� ����.. �̷��Ե� �Ǵ±���..!
		arr = tmp;
		
		//����� arr ���̿� element ���
		System.out.println("���� �� - arr.length : " + arr.length);
		for ( int i = 0; i < arr.length; i++ ) {
			System.out.println("arr["+ i + "] : " + arr[i]);
			System.out.println("tmp["+ i + "] : " + tmp[i]);
		}
	}

}
