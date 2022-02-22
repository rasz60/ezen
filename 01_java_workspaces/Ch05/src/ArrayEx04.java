public class ArrayEx04 {

	public static void main(String[] args) {

		char[] abc = { 'A', 'B', 'C', 'D' };
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.out.println(abc);
		System.out.println(num);
		
		
		char[] result = new char[abc.length + num.length];
		
		// abc �迭�� 0��°���� �迭�� ���̸�ŭ result �迭�� 0��°���� ���ʴ�� ����
		System.arraycopy(abc, 0, result, 0, abc.length);
		
		// num �迭�� 0��°���� �迭�� ���̸�ŭ result �迭�� abc�迭�� ���̹�°���� ���ʴ�� ����
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result);
			
		
		//abc�迭�� 0��° ���� �迭�� ���̸�ŭ num 0��°���� ���ʴ�� ����
		System.arraycopy(abc, 0, num, 0, abc.length);
		System.out.println(num);
		//num = { 'A', 'B', 'C', 'D', '4', '5', '6', '7', '8', '9'};
		
		//abc�迭�� 0��° ���� ���� 3��ŭ num 6��°���� ���ʴ�� ����
		System.arraycopy(abc, 0, num, 6, 3);
		System.out.println(num);
		//num = { 'A', 'B', 'C', 'D', '4', '5', 'A', 'B', 'C', '9'};
	}

}