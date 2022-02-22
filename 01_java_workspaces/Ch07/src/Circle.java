public class Circle extends Shape {

	Point center;
	int r;
	
	Circle() {
		this(new Point(0, 0), 100);
	}
	
	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	void draw() {
		System.out.printf("[center = (%d, %d) / r = %d / color = %s]%n",
						    center.x, center.y, r, color);
	}
}


class Triangle extends Shape {
	
	Point[] p = new Point[3];
	
	Triangle() {
		this(new Point[3]);
	}
	
	Triangle(Point[] p) {
		this.p = p;
	}
	
	void draw() {
		System.out.printf("[p1 = %s / p2 = %s / p3 = %s / color = %s]%n",
			    p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
	
}
