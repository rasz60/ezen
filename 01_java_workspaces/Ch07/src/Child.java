
public class Child extends Parent {
	int x = 200;
	
	void method() {
		System.out.println("Child Method");
	}
	
	void method1() {
		System.out.println("x : " + x);
		System.out.println("this.x : " + this.x);
		System.out.println("super.x : " + super.x);
	}
}