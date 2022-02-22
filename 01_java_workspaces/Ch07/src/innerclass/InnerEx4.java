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
		//�ٸ� Ŭ�������� ���� Ŭ������ ����� ����Ϸ���, �ܺ� Ŭ������ �ν��Ͻ� ���� �� �� ���������� �̿��Ͽ� �����ؾ� �Ѵ�.
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);

		//static ����Ŭ������ '�ܺ�Ŭ����.����staticŬ����' �� �ܺ� Ŭ���� �ν��Ͻ� ������ ������� �ҷ��� �� �ִ�. 
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.iv :" + si.iv);

	}
}
