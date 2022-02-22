
public class Buyer2 {

	int money = 1000;
	int bonusPoint = 0;
	Product[] item = new Product[10];
	int i = 0;
	
	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "을/를 구입하였습니다.");
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
		
		System.out.println("구입하신 물품의 총 금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");	
	}
}
