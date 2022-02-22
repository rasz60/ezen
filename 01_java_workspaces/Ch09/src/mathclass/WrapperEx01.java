package mathclass;

public class WrapperEx01 {

	public static void main(String[] args) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println("i1 == i2 ? " + (i1 == i2));
		System.out.println("i1.equals(i2) ? " + i1.equals(i2));
		System.out.println("i1.compareTo(i2) ? " + i1.compareTo(i2));				// 매개변수가 더 크면 -1, 같으면 0, 호출한 인스턴스가 더 크면 1
		System.out.println("i1.toString() =  " + i1.toString());
		
		System.out.println("MAX_VALUE = " + Integer.MAX_VALUE);
		System.out.println("MIN_VALUE = " + Integer.MIN_VALUE);		
		System.out.println("SIZE = " + Integer.SIZE + " byte");
		System.out.println("TYPE = " + Integer.TYPE);

		
//int 기본 자료형 변수가 Integer Wrapper 클래스 메서드를 사용하기 위해서는 형변환이 필요하다.
//		int i3 = 100;
//		int i4 = 100;
//		System.out.println("i3 == i4 ? " + (i3 == i4));
//		System.out.println("i3.equals(i4) ? " + i3.equals(i4));
//		System.out.println("i3.compareTo(i4) ? " + i3.compareTo(i4));
//		System.out.println("i3.toString() =  " + i3.toString());
//		System.out.println("i4.toString() =  " + i4.toString());
	}
}
