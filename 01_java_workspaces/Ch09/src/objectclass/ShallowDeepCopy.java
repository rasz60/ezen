package objectclass;

import java.util.Objects;

class Circle implements Cloneable {
	Point p;
	Point2 p2;
	double r;
	
	Circle(Point2 p, double radius) {
		this.p2 = p;
		this.r = radius;
	}
	
	public Circle shallowCopy() {									// 새로운 인스턴스를 생성하여 원본 인스턴스 참조변수의 주소 값을 대입하여 새로운 인스턴스를 return (얕은 복사)
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ce) {}
		return (Circle)obj;		
	}
	
	public Circle deepCopy() {										// 새로운 인스턴스를 생성하여 원본 인스턴스 참조변수 값까지 대입하여 새로운 인스턴스를 return (깊은 복사)
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ce) {}
		
		Circle c = (Circle)obj;
		c.p2 = new Point2(this.p2.x, this.p2.y);						// Point2가 Cloneable이 아닐 때, Point2에 새로운 인스턴스를 생성하여 대입.
//		c.p = (Point)c.p.clone();									// Point2이 Cloneable일 때, Point2에 구현되어있는 Clone을 통해서 값을 대입한다.
		return c;
	}
	
	public boolean equals(Object obj) {
		if ( !(obj instanceof Circle ) ) {
			return false;
		} else {
			if ( this.p2.x == ((Circle)obj).p2.x && this.p2.y == ((Circle)obj).p2.y && this.r == ((Circle)obj).r) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	public int hashCode() {
		return Objects.hash(this.p2.x, this.p2.y, this.r);
	}
	
	public String toString() {
		return "x = " + p2.x + ", y = " + p2.y + ", radius = " + r;
	}
	
}

class Point2 {
	int x, y;
	
	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x = " + x + ", y = " + y;
	}
}

public class ShallowDeepCopy {

	public static void main(String[] args) {
		Circle c1 = new Circle(new Point2(1, 1), 2.0);
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1.deepCopy();
		
		System.out.println("toString ======================");		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		System.out.println();

		//c1 값 변경
		c1.p2.x = 9;
		c1.p2.y = 9;
//		c1.r = 3.0;	
		
		System.out.println("c1 변경 후 ======================");
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);								// c2(얕은 복사)는 c1이 가르키고 있는 p의 x, y값의 주소를 가르키고 있으므로, c1의 값을 변경하면 같이 변경된다.
		System.out.println("c3 = " + c3);								// c3(깊은 복사)는 c1의 x, y값을 대입한 새로운 인스턴스이므로, c1의 변경과 상관이 없다.
		System.out.println();
		
		
		System.out.println("equals ========================");
		System.out.println("c1.equals(c2) = " + c1.equals(c2));
		System.out.println("c1.equals(c3) = " + c1.equals(c3));		
		System.out.println();
		
		
		System.out.println("hashCode ======================");
		System.out.println("c1.hashCode() = " + c1.hashCode());
		System.out.println("c2.hashCode() = " + c2.hashCode());
		System.out.println("c3.hashCode() = " + c3.hashCode());
	}

}
