package ch2;

public class Test2_05 {

	public static void main(String[] args) {

		System.out.println("1" + "2");
		// ��� : 12
		
		System.out.println(true + "");
		// ��� : ���� ->���� true(..!)
		// true�� String�������� ����� �ȴ�..?
		
		System.out.println('A' + 'B');
		// ��� : AB ->���� 131
		// char�� ���� String x
		// �� char�� �ƽ�Ű �ڵ尪�� ���� ������ ����
		
		System.out.println('1' + "2");
		// ��� : 12
		// char + String = String
		
		System.out.println('1' + '2');
		// ��� : 12 ->���� 99
		// char�� ���� String x
		// �� char�� �ƽ�Ű �ڵ尪�� ���� ������ ����
		
		System.out.println('J' + "ava");
		// ��� : Java
		// char + String = String
		
	  //System.out.println(true + null);	
		// ��� : ����
			
		

	}

}
