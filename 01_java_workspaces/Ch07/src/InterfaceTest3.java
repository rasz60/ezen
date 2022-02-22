interface I3 {
	public abstract void methodB();
	default void methodB1() {}
}

class InstanceManager {
	public static I3 getInstance() {
		return new B3();
	}
	
}

class A3 {
	void methodA() {
		I3 i = InstanceManager.getInstance();
		i.methodB();
		System.out.println(i);
	}
	
}

class B3 implements I3 {
	public void methodB() {
		System.out.println("methodB in B3 class");
	}
	
	public String toString() {
		return "class B3";
	}


}

class C3 implements I3 {
	@Override
	public void methodB() {
		System.out.println("methodB in C3 class.");
	}
	
	public String toString() {
		return "class C3";
	}
	
}


class InterfaceTest3 {

	public static void main(String[] args) {
		A3 a = new A3();
		a.methodA();
	}

}