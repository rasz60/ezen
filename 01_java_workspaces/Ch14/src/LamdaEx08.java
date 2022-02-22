import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LamdaEx08 {

	public static void main(String[] args) {
		Function<String, Integer> f1 = (s) -> Integer.parseInt(s);
		Function<String, Integer> f2 = Integer::parseInt;
		System.out.println(f1.apply("10") + 20);
		System.out.println(f2.apply("10") + 20);
		
		Supplier<MyClass> 		  s1 = () -> new MyClass();
		Function<String, MyClass> s2 = s -> new MyClass(s);
		Supplier<MyClass> 		  s3 = MyClass::new;
		Function<String, MyClass> s4 = MyClass::new;
		
		MyClass mc1 = s1.get();
		MyClass mc2 = s3.get();		
		System.out.println(mc1);
		System.out.println(mc2);
		
		MyClass mc3 = s2.apply("LamdaMethodReference1.");
		MyClass mc4 = s4.apply("LamdaMethodReference2.");
		System.out.println(mc3);
		System.out.println(mc4);
		
		// iv�� "Hello."�� �ν��Ͻ��� ���� check�� equals üũ
		MyClass mc5 = s4.apply("Hello.");
		String iv1 = "Hello.";
		
		Function<String, Boolean> c = mc5::equals;
		System.out.println(c.apply(iv1));
		
		// MyClass ������ equlas���� String equals ȣ��
		String iv2 = "Hello.";
		BiFunction<String, String, Boolean> bf1 = (a, b) -> a.equals(b);
		BiFunction<String, String, Boolean> bf2 = String::equals;
		System.out.println(bf1.apply(iv1, iv2));
		System.out.println(bf2.apply(iv1, iv2));

		// �Ű����� 2���� �ν��Ͻ� �޼��� ������ ���ٷ� ����
		BiFunction<String, Integer, MyClass> s5 = MyClass::new;
		MyClass mc6 = s5.apply("multiValueConstructor", 5);
		System.out.println(mc6);
		
		// �޼��� ������ �迭 ����
		Function<Integer, int[]> arr = int[]::new;
		int[] fArr = arr.apply(100);
		System.out.printf("fArr�� ���� : %d%n", fArr.length);	
	}

}

class MyClass {
	
	String iv;
	int intV;
	
	public MyClass() {
		this("DefaultConstructor.");
	}
	
	public MyClass(String s) {
		this(s, 1);
	}
	
	public MyClass(String s, int i) {
		iv = s;
		intV = i;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public boolean equals(String string) {
		if ( iv == string ) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "MyClass [iv = " + iv + ", intV = " + intV + "]";
	}

}