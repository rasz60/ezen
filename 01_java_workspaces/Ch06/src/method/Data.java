package method;

public class Data {

	int x;
	
	static void change(int x) {
		x = 1000;
		System.out.println("change() : x = " + x + "\n");
	}
	
	static void change2(Data d) {
		d.x = 1000;
		System.out.println("change() : x = " + d.x + "\n");
	}

}
