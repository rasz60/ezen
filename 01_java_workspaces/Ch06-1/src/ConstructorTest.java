
public class ConstructorTest {

	public static void main(String[] args) {

		Data d1 = new Data();
//		Data2 d2 = new Data2();  // �Ű������� ��� �ν��Ͻ��� ������ �� ����.
		Data2 d2 = new Data2(100);
		
		System.out.println(d1.x);
		System.out.println(d2.value);
	}

}
