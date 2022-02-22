package stringbuffer;

public class StringBufferEx02 {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("01");
		StringBuffer sb2 = sb1.append("23");									// sb1�� append�� ���� sb2���� �����ϴ� ������ ��������, sb1�� append�� ����� ������ ����ȴ�.
//		StringBuffer sb2 = new StringBuffer(sb1.append("23"));					// new �ؼ� ������ �� ���� ���� �Ű������� ������ ����ȭ���� �ʴ´�.
		sb1.append('4').append(56);
		
		StringBuffer sb3 = sb1.append(78);
		sb3.append(9.0);														// ����ȭ �� �ν��Ͻ� �� � ���� �����ϴ��� ��� ����ȴ�.
		
		// sb1���� �����Ͽ� ������ �ν��Ͻ��� ����ȭ�Ǿ� ���ÿ� ����ȴ�.
		System.out.println("sb1 = " + sb1);
		System.out.println("sb2 = " + sb2);
		System.out.println("sb3 = " + sb3);
		System.out.println();

		System.out.println("sb1 = " + sb1.deleteCharAt(10));
		System.out.println("sb1 = " + sb1.delete(3, 6));
		System.out.println("sb1 = " + sb1.insert(3, "abc"));
		System.out.println("sb1 = " + sb1.replace(6, sb1.length(), "END"));
		System.out.println();
		
		System.out.println("sb1 = " + sb1);
		System.out.println("sb2 = " + sb2);
		System.out.println("sb3 = " + sb3);
		System.out.println();		
		
		System.out.println("capacity = " + sb1.capacity());
		System.out.println("length = " + sb1.length());
		
	}

}
