package method;

public class PrimitiveParamEx {

	public static void main(String[] args) {

		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x + "\n");
		
		d.change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x + "\n");
		
		d.change2(d);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x + "\n");
	}

}
