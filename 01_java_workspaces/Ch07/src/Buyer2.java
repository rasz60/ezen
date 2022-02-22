
public class Buyer2 {

	int money = 1000;
	int bonusPoint = 0;
	Product[] item = new Product[10];
	int i = 0;
	
	void buy(Product p) {
		if (money < p.price) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "��/�� �����Ͽ����ϴ�.");
	}

	void summary() {
		int sum = 0;
		String itemList = "";
		
		for ( int i = 0; i < item.length; i++ ) {
			if ( item[i] == null) {
				break;
			}
			
			sum += item[i].price;
			
			if ( i == 0 || i == item.length ) {
				itemList += item[i];
			}
			else {
				itemList += ", " + item[i];
			}
		}
		
		System.out.println("�����Ͻ� ��ǰ�� �� �ݾ��� " + sum + "�����Դϴ�.");
		System.out.println("�����Ͻ� ��ǰ�� " + itemList + "�Դϴ�.");	
	}
}
