package defaultmethodtest;

public interface MyInterface {
	default void method1() {
		System.out.println("method1() in MyInterface.");
	}
	
	default void method2() {
		System.out.println("method2() in MyInterface.");
	}
	
	static void staticMethod() {
		System.out.println("staticMethod() in MyInterface.");
	}
}