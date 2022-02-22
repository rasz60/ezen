public class Product {

	int price;
	int bonusPoint;
	
	Product() {}
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price * 0.1);
	}

}
