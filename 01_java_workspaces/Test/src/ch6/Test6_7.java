package ch6;

class MyPoint {
	int x;
	int y;
	
	MyPoint (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistance(int x1, int y1) {
		double distance = Math.sqrt((double)((this.x-x1)*(this.x-x1)) + ((this.y-y1)*(this.y-y1)));
		return distance;
	}
}


public class Test6_7 {

	public static void main(String[] args) {
		MyPoint p = new MyPoint(1, 1);

		System.out.println(p.getDistance(2,2));
	}


}
