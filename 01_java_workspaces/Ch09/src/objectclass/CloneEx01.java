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

	public Point clone() {								// ���ο� �ν��Ͻ��� �����Ͽ� ���� �ν��Ͻ��� ���� ������ ���ο� �ν��Ͻ��� return(Object Ÿ�� ��ȯ)
		Object obj = null;
		try {
			obj = super.clone();						
		} catch (CloneNotSupportedException ce) {}		// Cloneable�� implement���� ���� Ŭ������ �ν��Ͻ��� clone�� ���� ����� Exceptionó��
		return (Point)obj;		
	}
	
	
}


public class CloneEx01 {

	public static void main(String[] args) {
		Point original = new Point(3, 5);
		Point copy = original.clone();			// Point Ÿ���� copy�� ObjecetŸ������ ��ȯ�� clone()�� �����Ƿ� ����ȯ �ʿ�
		
		System.out.println(original);
		System.out.println(copy);	
	}

}
