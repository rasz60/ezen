package etcutil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Person2 person1 = new Person2("홍길동");
		System.out.println(person1);
		
		Class c1 = Class.forName("objectclass.Person2");
		Person2 person2 = (Person2)c1.newInstance();
		System.out.println(person2);
		
		//동적 인스턴스 생성
		Class[] parameterTypes = { String.class };										// parameterTypes라는 배열에 String 을 넣겠다고 선언
		Constructor<?> cons = c1.getConstructor(parameterTypes);							// reflect.Constructor 클래스에 cons 생성 후 c1의 생성자 매개변수를 가져온다. (= null)
		
		Object[] initags = {"김유신"};
		Person2 pKim = (Person2)cons.newInstance(initags);								// cons를 통해 Constructor 클래스에 initags를 매개변수로 하는 인스턴스 'pKim' 생성
		System.out.println(pKim);
		
		
		Class c2 = Class.forName("objectclass.Person2");
		Class[] parameterTypes1 = { String.class, Integer.class };
		Constructor cons1 = c2.getConstructor(parameterTypes1);
		
		Object[] initags2 = {"김진웅", 31};
		Person2 wHwang = (Person2)cons1.newInstance(initags2);
		System.out.println(wHwang);
		
		//2차원 배열 initag3 생성해서 for문으로 여러명 생성 
		Object[][] initag3 = new Object[10][2];
		for ( int i = 0; i < initag3.length; i++ ) {
			Random random = new Random();
			initag3[i][0] = "Person" + (i + 1);
			initag3[i][1] = random.nextInt(80);
			Person2 pTest = (Person2)cons1.newInstance(initag3[i]);
			System.out.println(pTest);
		}
	}
}
