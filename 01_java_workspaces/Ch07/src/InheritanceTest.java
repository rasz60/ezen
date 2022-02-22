class PointH {
	int x;
	int y;
}

class CircleH extends PointH {
	int r;
	
}

public class InheritanceTest {
	public static void main(String[] args) {
		CircleH c = new CircleH();
		c.x = 10;
		c.y = 20;
		c.r = 30;
		
		System.out.println("c.x = " + c.x);
		System.out.println("c.y = " + c.r);
		System.out.println("c.r = " + c.y);
		//인스턴스.toString() : 클래스명@해시코드
		System.out.println("c.toString = " + c.toString());
		System.out.println("c = " + c);
	}

}
