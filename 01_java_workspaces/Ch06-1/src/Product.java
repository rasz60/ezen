public class Product {

	static int count = 0;
	int serialNo;
	
	{ 
		++count;
		serialNo = count;
	}
	
	public Product() {}
	
}
