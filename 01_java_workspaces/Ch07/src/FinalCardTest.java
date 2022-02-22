class Card2 {
	
	final int NUMBER;
	final String KIND;
	static int width = 100;
	static int height = 250;
	
	Card2() {
		this("HEART", 1);
	}
	
	Card2(String kind, int num) {
		this.KIND = kind;
		this.NUMBER = num;
	}
	
	public String toString() {
		return KIND + " " + NUMBER;
	}
	
}

public class FinalCardTest {

	public static void main(String[] args) {
		Card2 c = new Card2("HEART", 10);

		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);
	}

}
