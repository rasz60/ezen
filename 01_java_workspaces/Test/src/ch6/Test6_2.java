package ch6;

public class Test6_2 {

	public static void main(String[] args) {

		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
	}

}


class SutdaCard {
	
	int num = (int)((Math.random() * 10) + 1);
	boolean isKwang;
	String kwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
		kwang = this.isKwang == true ? "K": "";
	}
	
	String info() {
		return num + kwang;
	}
	
}
