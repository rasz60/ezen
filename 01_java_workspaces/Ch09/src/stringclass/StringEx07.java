package stringclass;

public class StringEx07 {

	public static void main(String[] args) {
		String fullName = "Hello.java";
		
		// '.'�� String �迭 index�� ������
		int index = fullName.indexOf('.');
		
		// fullName���� 0��°���� '.'�� ���ڱ��� fileName�� ����
		String fileName = fullName.substring(0, index);
		
		// '.' ���� ���ں��� ������ ���ڿ� �����Ѵ�.
		String ext = fullName.substring( index + 1 );
		
		System.out.println(fullName + "�� Ȯ���� ���� �̸� : " + fullName);
		System.out.println(fullName + "�� Ȯ����	 :" + ext);
		
	}

}
