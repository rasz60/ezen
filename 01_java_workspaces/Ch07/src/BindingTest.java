
public class BindingTest {

	public static void main(String[] args) {

		Parent p = new Child();
		Parent p1 = new Parent();
		Child  c = new Child();
		//���� �̸��� ������ �޼����� ��, ������ Parent / �޼���� Child Ŭ������ ���� �ҷ���
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
