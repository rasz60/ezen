
public class BindingTest {

	public static void main(String[] args) {

		Parent p = new Child();
		Parent p1 = new Parent();
		Child  c = new Child();
		//같은 이름의 변수와 메서드일 때, 변수는 Parent / 메서드는 Child 클래스의 것을 불러옴
		System.out.println("p.x = " + p.x);
		p.method();
		System.out.println();
		
		System.out.println("p1.x = " + p1.x);
		p1.method();
		System.out.println();		
		//
		System.out.println("c.x = " + c.x);
		c.method();
		
	}

}
