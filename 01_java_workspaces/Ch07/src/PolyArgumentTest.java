
public class PolyArgumentTest {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv2());
		b.buy(new Computer());
		b.buy(new Audio());

		System.out.println("���� ���� ���� " + b.money + "���� �Դϴ�.");
		System.out.println("���� ���ʽ� ����Ʈ�� " + b.bonusPoint + "�� �Դϴ�.");
		
		System.out.println();
		
		Buyer2 b2 = new Buyer2();
		
		b2.buy(new Tv2());
		b2.buy(new Computer());
		b2.buy(new Audio());
		b2.summary();
		
		System.out.println("���� ���� ���� " + b2.money + "���� �Դϴ�.");
		System.out.println("���� ���ʽ� ����Ʈ�� " + b2.bonusPoint + "�� �Դϴ�.");

		System.out.println();
		
		Buyer3 b3 = new Buyer3();
		Tv2 tv = new Tv2();
		Computer com = new Computer();
		Audio audio = new Audio();
				
		b3.buy(tv);
		b3.buy(com);
		b3.buy(audio);
		b3.summary();
		System.out.println();
		b3.refund(com);
		b3.summary();
		
		System.out.println("���� ���� ���� " + b2.money + "���� �Դϴ�.");
		System.out.println("���� ���ʽ� ����Ʈ�� " + b2.bonusPoint + "�� �Դϴ�.");
		
		
		
	}
	
	

}
