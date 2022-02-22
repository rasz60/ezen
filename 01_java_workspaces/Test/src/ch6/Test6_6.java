package ch6;

public class Test6_6 {

	static double getDistance(int x, int y, int x1, int y1) {
		double distance = Math.sqrt((double)((x-x1)*(x-x1)) + ((y-y1)*(y-y1)));
		return distance;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getDistance(1,1,2,2));
		
	}

}
