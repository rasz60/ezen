public class Card {

	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	
	int kind;
	int number;
	
	Card() {
		this(SPADE, 1);
	}
	
	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	public String toString() {
		String[] kinds = {"¢À", "¢¾", "¡ß", "¢¼"};
		String numbers = "A23456789XJQK";
		
		return numbers.charAt(this.number - 1) + kinds[this.kind - 1];
	}
	
}
