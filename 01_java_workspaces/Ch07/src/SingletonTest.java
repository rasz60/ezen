
public class SingletonTest {

	public static void main(String[] args) {

//		Singleton s = new Singleton();			// private 생성자를 가진 final 클래스는 외부에서 인스턴스를 생성할 수 없다.
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);

	}
}
