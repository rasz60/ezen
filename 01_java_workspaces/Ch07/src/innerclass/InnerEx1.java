package innerclass;

public class InnerEx1 {
	class InstanceInner {
		int iv = 100;
//		static int cv = 100;			//static 변수는 static클래스에만 정의할 수 있다.
		final static int CONST = 100;	//final static은 상수임으로 가능
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}
	
	void myMethod() {
		class LocalInner {
			int iv = 300;
//			static int cv = 300;
			final static int CONST = 300;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);

	}
}
