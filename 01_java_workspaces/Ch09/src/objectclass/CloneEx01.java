package objectclass;

class Point implements Cloneable {
	int x, y;
	
	Point( int x , int y ) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x = " + x + ", y = " + y;
	}

	public Point clone() {								// 새로운 인스턴스를 생성하여 원본 인스턴스의 값을 대입한 새로운 인스턴스로 return(Object 타입 반환)
		Object obj = null;
		try {
			obj = super.clone();						
		} catch (CloneNotSupportedException ce) {}		// Cloneable을 implement하지 않은 클래스의 인스턴스를 clone할 때를 대비한 Exception처리
		return (Point)obj;		
	}
	
	
}


public class CloneEx01 {

	public static void main(String[] args) {
		Point original = new Point(3, 5);
		Point copy = original.clone();			// Point 타입의 copy에 Objecet타입으로 반환된 clone()을 넣으므로 형변환 필요
		
		System.out.println(original);
		System.out.println(copy);	
	}

}
