
public class SingletonTest {

	public static void main(String[] args) {

//		Singleton s = new Singleton();			// private �����ڸ� ���� final Ŭ������ �ܺο��� �ν��Ͻ��� ������ �� ����.
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);

	}
}
