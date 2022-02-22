package defaultmethodtest;

public class DefaultMethodTest {

	public static void main(String[] args) {
		Child c = new Child();

		c.method1();
		c.method2();
		
		MyInterface.staticMethod();
		MyInterface2.staticMethod();

	}
}
