public class ProductTest {

	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println("p1 제품번호(serialNo) : " + p1.serialNo);
		System.out.println("p2 제품번호(serialNo) : " + p2.serialNo);
		System.out.println("p3 제품번호(serialNo) : " + p3.serialNo);
										    //클래스명.클래스변수명 -> 다른 클래스 변수 호출
		System.out.println("생산된 제품은 모두 " + Product.count + "개 입니다.");
		
	}

}
