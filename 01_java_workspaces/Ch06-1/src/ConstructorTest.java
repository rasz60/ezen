
public class ConstructorTest {

	public static void main(String[] args) {

		Data d1 = new Data();
//		Data2 d2 = new Data2();  // 매개변수가 없어서 인스턴스를 생성할 수 없다.
		Data2 d2 = new Data2(100);
		
		System.out.println(d1.x);
		System.out.println(d2.value);
	}

}
