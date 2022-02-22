package objectclass;

import java.util.Objects;

class Card {
	String kind;
	int number;
	
	Card() {
		this("Spade", 1);
	}
	
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	@Override
	public String toString() {
		if ( kind.equals("Spade") ) {
			this.kind = "♠";
		} else if ( kind.equals("Clover") ) {
			this.kind = "♣";
		} else if ( kind.equals("Heart") ) {
			this.kind = "♥";
		} else if ( kind.equals("Diamond") ) {
			this.kind = "◆";
		} else {
			this.kind = null;
		}
		return this.kind + this.number;
	}

	public boolean equals(Object obj) {
		if ( !(obj instanceof Card) ) {
			return false;
		}
		else {
			if ( this.kind == ((Card)obj).kind && this.number == ((Card)obj).number ) {
				return true;
			} else {
				return false;
			}
		}
	}


	public int hashCode() {								// 속성값이 같은 객체의 hashCode를 동일하게 하는 방법 (Objects.hash() 이용)
		return Objects.hash(this.kind, this.number);	
	}

}

public class CardToString {

	public static void main(String[] args) {
		Card c1 = new Card("Heart", 10);
		Card c2 = new Card("Clover", 13);
		Card c3 = new Card();
		Card c4 = new Card();
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());
		
		System.out.println();
		
		System.out.println(c1.equals(c2));
		System.out.println(c3.equals(c4));
		
		System.out.println();
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c4.hashCode());
		
	}

}
