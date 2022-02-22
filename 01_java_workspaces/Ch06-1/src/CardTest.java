public class CardTest {

	public static void main(String[] args) {

		System.out.printf("Card.width = %d%n", Card.width);
		System.out.printf("Card.height = %d%n", Card.height);
		System.out.println();		
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;

		System.out.printf("c1은 %s, %d이며, 크기는 %d, %d입니다.%n", c1.kind,c1.number,c1.width,c1.height);
		System.out.printf("c2은 %s, %d이며, 크기는 %d, %d입니다.%n", c2.kind,c2.number,c2.width,c2.height);		
		System.out.println();		

		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
		System.out.println();
		
		c1.width = 50;
		c1.height = 80;
	
		System.out.printf("c1은 %s, %d이며, 크기는 %d, %d입니다.%n", c1.kind,c1.number,c1.width,c1.height);
		System.out.printf("c2은 %s, %d이며, 크기는 %d, %d입니다.%n", c2.kind,c2.number,c2.width,c2.height);
		
	}
}