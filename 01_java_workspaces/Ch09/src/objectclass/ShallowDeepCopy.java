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
	
	public Circle shallowCopy() {									// ���ο� �ν��Ͻ��� �����Ͽ� ���� �ν��Ͻ� ���������� �ּ� ���� �����Ͽ� ���ο� �ν��Ͻ��� return (���� ����)
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ce) {}
		return (Circle)obj;		
	}
	
	public Circle deepCopy() {										// ���ο� �ν��Ͻ��� �����Ͽ� ���� �ν��Ͻ� �������� ������ �����Ͽ� ���ο� �ν��Ͻ��� return (���� ����)
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ce) {}
		
		Circle c = (Circle)obj;
		c.p2 = new Point2(this.p2.x, this.p2.y);						// Point2�� Cloneable�� �ƴ� ��, Point2�� ���ο� �ν��Ͻ��� �����Ͽ� ����.
//		c.p = (Point)c.p.clone();									// Point2�� Cloneable�� ��, Point2�� �����Ǿ��ִ� Clone�� ���ؼ� ���� �����Ѵ�.
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

		//c1 �� ����
		c1.p2.x = 9;
		c1.p2.y = 9;
//		c1.r = 3.0;	
		
		System.out.println("c1 ���� �� ======================");
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);								// c2(���� ����)�� c1�� ����Ű�� �ִ� p�� x, y���� �ּҸ� ����Ű�� �����Ƿ�, c1�� ���� �����ϸ� ���� ����ȴ�.
		System.out.println("c3 = " + c3);								// c3(���� ����)�� c1�� x, y���� ������ ���ο� �ν��Ͻ��̹Ƿ�, c1�� ����� ����� ����.
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
