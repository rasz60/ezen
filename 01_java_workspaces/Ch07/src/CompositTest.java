public class CompositTest {

	public static void main(String[] args) {
		Circle c = new Circle();
		
		//���԰����� Ŭ������ �ִ� ������ ȣ���ϱ� ���ؼ��� �ش� Ŭ������ ���������� �޾��־�� �Ѵ�.
		c.center.x = 10;
		c.center.y = 20; 
		c.r = 30;
		c.color = "red";
		System.out.println("c.center.x = " + c.center.x);
		System.out.println("c.center.y = " + c.center.y);
		System.out.println("c.r = " + c.r);
		System.out.println("c.color = " + c.color);
		c.draw();
	}
}
