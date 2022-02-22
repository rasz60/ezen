package ch7;

class Exercise07_01 {
	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();

		deck.shuffle();
		deck.showAllCard();
	}
}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		for ( int i = 0; i < cards.length; i++ ) {
			if ( i == 0 || i == 2 || i == 7 ) {
				cards[i] = new SutdaCard(i+1, true);
			}
			else if ( i >= 0 && i < 10 ) {
				cards[i] = new SutdaCard(i+1, false);
			}
			else {
				cards[i] = new SutdaCard(i-9, false);
			}
		}
	}

	SutdaCard pick(int num) {
		return cards[num - 1];
	}

	SutdaCard pick() {
		int random = (int)(Math.random() * cards.length);
		return cards[random];
	}
	
	void shuffle() {
		for (int i = 0; i < cards.length; i++ ) {
			int random = (int)(Math.random() * cards.length);
			SutdaCard tmp = cards[i];
			cards[i] = cards[random];
			cards[random] = tmp;
		}
	}
	
	void showCard(SutdaCard sc) {
		if ( sc.toString().equals("1K") || sc.toString().equals("3K") || sc.toString().equals("8K") || sc.toString().equals("10")) {
			System.out.print(
					"������������\n�� " + sc +
					  " ��\n������������\n");
		}
		else {
			System.out.print(
					"������������\n�� 0" + sc +
					  " ��\n������������\n");
		}
	}
	
	void showAllCard() {

		for (int i = 0; i < cards.length; i++) {
			if ( cards[i].toString().equals("1K") || cards[i].toString().equals("3K") || cards[i].toString().equals("8K") || cards[i].toString().equals("10")) {
				System.out.print(
						"������������\n�� " + cards[i] +
						  " ��\n������������\n");
			}
			else {
				System.out.print(
						"������������\n�� 0" + cards[i] +
						  " ��\n������������\n");
			}
		}
	}

}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() {
		return num + ( isKwang ? "K":"");
	}
}

