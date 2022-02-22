package innerclass;

class Outer2 {
	int value = 10;
	
	class Inner {
		int value = 20;
		
		void method1() {
			int value = 30;

			//innerclass 안에 method1 지역변수 'value'
			System.out.println("value : " + value);

			//method1이 들어있는 innerclass 인스턴스 변수 'value'
			System.out.println("this.value : " + this.value);

			//innerclass가 들어있는 outerclass 인스턴스 변수 'value'
			System.out.println("Outer2.value : " + Outer2.this.value);
		}
	}
}


public class InnerEx5 {

	public static void main(String[] args) {
		Outer2 oc = new Outer2();
		Outer2.Inner inner = oc.new Inner();
		inner.method1();
	}

}
