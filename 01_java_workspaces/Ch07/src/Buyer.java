
public class Buyer {

	int money = 1000;
	int bonusPoint = 0;
	
	void buy(Product p) {
		if ( money < p.price ) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}		
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + "��/�� �����Ͽ����ϴ�.");
	}
}
