package innerclass;

class InnerEx2 {
	class InstanceInner {}
	static class StaticInner {}
	
	InstanceInner iv = new InstanceInner();
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		//static 메서드 안에 instance 멤버를 사용할 수 없다.
		//꼭 필요한 경우 외부클래스에서 인스턴스 생성 후에 사용한다.
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
