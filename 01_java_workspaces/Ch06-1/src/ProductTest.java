public class ProductTest {

	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println("p1 ��ǰ��ȣ(serialNo) : " + p1.serialNo);
		System.out.println("p2 ��ǰ��ȣ(serialNo) : " + p2.serialNo);
		System.out.println("p3 ��ǰ��ȣ(serialNo) : " + p3.serialNo);
										    //Ŭ������.Ŭ���������� -> �ٸ� Ŭ���� ���� ȣ��
		System.out.println("����� ��ǰ�� ��� " + Product.count + "�� �Դϴ�.");
		
	}

}
