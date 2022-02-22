
@FunctionalInterface
interface MyFunction2 {
	void myMethod();
}

public class LamdaEx02 {

	public static void main(String[] args) {
		MyFunction2 f = () -> {};												// 구현 내용이 없는 f 생성
		Object obj = (MyFunction2)( () -> {} );									// Object 타입으로 형변환은 생략 가능.
		String str = ( (Object)(MyFunction2)( ()-> {} ) ).toString();			// Object 타입으로 형변환해서 대입 가능
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println( () -> {} );
		System.out.println( (MyFunction2)( () -> {} ) );
//		System.out.println( (MyFunction2)( () -> {} ).toString() );
		System.out.println( ( (Object)(MyFunction2)( ()-> {} ) ).toString() );
	}

}
