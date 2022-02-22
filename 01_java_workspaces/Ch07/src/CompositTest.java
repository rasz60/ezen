public class CompositTest {

	public static void main(String[] args) {
		Circle c = new Circle();
		
		//포함관계인 클래스에 있는 변수를 호출하기 위해서는 해당 클래스의 참조변수를 달아주어야 한다.
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
