package innerclass;

class Outer {
	class InstanceInner {
		int iv = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 300;
	}
	
	void myMethod() {
		class LocalInner {
			int iv = 400;
		}
	}
}

public class InnerEx4 {

	public static void main(String[] args) {
		//다른 클래스에서 내부 클래스의 멤버를 사용하려면, 외부 클래스에 인스턴스 생성 후 그 참조변수를 이용하여 접근해야 한다.
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);

		//static 내부클래스는 '외부클래스.내부static클래스' 로 외부 클래스 인스턴스 생성과 상관없이 불러올 수 있다. 
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.iv :" + si.iv);

	}
}
