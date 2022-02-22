package innerclass;

class InnerEx2 {
	class InstanceInner {}
	static class StaticInner {}
	
	InstanceInner iv = new InstanceInner();
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		//static �޼��� �ȿ� instance ����� ����� �� ����.
		//�� �ʿ��� ��� �ܺ�Ŭ�������� �ν��Ͻ� ���� �Ŀ� ����Ѵ�.
//		InstanceInner obj1 = new InstanceInner();
		InnerEx2 outer = new InnerEx2();
		InstanceInner obj1 = outer.new InstanceInner();

		StaticInner obj2 = new StaticInner();
	}
	
	void instanceMethod() {
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
//		LocalInner lv = new LocalInner();
	}

	void myMethod() {
		class LocalInner {}
		LocalInner lv = new LocalInner();
	}
	
}
