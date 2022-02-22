package mathclass;

public class WrapperEx01 {

	public static void main(String[] args) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println("i1 == i2 ? " + (i1 == i2));
		System.out.println("i1.equals(i2) ? " + i1.equals(i2));
		System.out.println("i1.compareTo(i2) ? " + i1.compareTo(i2));				// �Ű������� �� ũ�� -1, ������ 0, ȣ���� �ν��Ͻ��� �� ũ�� 1
		System.out.println("i1.toString() =  " + i1.toString());
		
		System.out.println("MAX_VALUE = " + Integer.MAX_VALUE);
		System.out.println("MIN_VALUE = " + Integer.MIN_VALUE);		
		System.out.println("SIZE = " + Integer.SIZE + " byte");
		System.out.println("TYPE = " + Integer.TYPE);

		
//int �⺻ �ڷ��� ������ Integer Wrapper Ŭ���� �޼��带 ����ϱ� ���ؼ��� ����ȯ�� �ʿ��ϴ�.
//		int i3 = 100;
//		int i4 = 100;
//		System.out.println("i3 == i4 ? " + (i3 == i4));
//		System.out.println("i3.equals(i4) ? " + i3.equals(i4));
//		System.out.println("i3.compareTo(i4) ? " + i3.compareTo(i4));
//		System.out.println("i3.toString() =  " + i3.toString());
//		System.out.println("i4.toString() =  " + i4.toString());
	}
}
