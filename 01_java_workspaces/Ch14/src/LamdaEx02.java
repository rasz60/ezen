
@FunctionalInterface
interface MyFunction2 {
	void myMethod();
}

public class LamdaEx02 {

	public static void main(String[] args) {
		MyFunction2 f = () -> {};												// ���� ������ ���� f ����
		Object obj = (MyFunction2)( () -> {} );									// Object Ÿ������ ����ȯ�� ���� ����.
		String str = ( (Object)(MyFunction2)( ()-> {} ) ).toString();			// Object Ÿ������ ����ȯ�ؼ� ���� ����
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println( () -> {} );
		System.out.println( (MyFunction2)( () -> {} ) );
//		System.out.println( (MyFunction2)( () -> {} ).toString() );
		System.out.println( ( (Object)(MyFunction2)( ()-> {} ) ).toString() );
	}

}
