class A2 {
	void autoPlay(I i) {
		i.play();
	}
}

interface I {
	public abstract void play();
}

class B2 implements I {
	public void play() {
		System.out.println("play in B class");
	}
}

class C2 implements I {
	public void play() {
		System.out.println("play in C class");
	}
}

class D2 implements I {
	public void play() {
		System.out.println("play in D class");
	}
	
}

class InterfaceTest2 {

	public static void main(String[] args) {
		A2 a2 = new A2();
		a2.autoPlay(new B2());
		a2.autoPlay(new C2());		
		a2.autoPlay(new D2());
	}
}
