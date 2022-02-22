
public class DrawShape {

	public static void main(String[] args) {
		
		Point[] p = { new Point(100, 100),
					  new Point(140,  50),
					  new Point(200, 100) 
					};
		
		Triangle t = new Triangle(p);
		
//		Triangle t1 = new Triangle();
//		t1.p[0] = new Point(100, 100);
//		t1.p[1] = new Point(140,  50);
//		t1.p[2] = new Point(200, 100);
		
		Circle	 c = new Circle  (new Point(150, 150), 50);
		
		t.draw();
		c.draw();
	}

}
