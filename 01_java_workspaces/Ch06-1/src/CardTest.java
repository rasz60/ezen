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

		System.out.printf("c1�� %s, %d�̸�, ũ��� %d, %d�Դϴ�.%n", c1.kind,c1.number,c1.width,c1.height);
		System.out.printf("c2�� %s, %d�̸�, ũ��� %d, %d�Դϴ�.%n", c2.kind,c2.number,c2.width,c2.height);		
		System.out.println();		

		System.out.println("c1�� width�� height�� ���� 50, 80���� �����մϴ�.");
		System.out.println();
		
		c1.width = 50;
		c1.height = 80;
	
		System.out.printf("c1�� %s, %d�̸�, ũ��� %d, %d�Դϴ�.%n", c1.kind,c1.number,c1.width,c1.height);
		System.out.printf("c2�� %s, %d�̸�, ũ��� %d, %d�Դϴ�.%n", c2.kind,c2.number,c2.width,c2.height);
		
	}
}