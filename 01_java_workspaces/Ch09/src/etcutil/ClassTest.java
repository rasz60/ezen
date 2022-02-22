package etcutil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Person2 person1 = new Person2("ȫ�浿");
		System.out.println(person1);
		
		Class c1 = Class.forName("objectclass.Person2");
		Person2 person2 = (Person2)c1.newInstance();
		System.out.println(person2);
		
		//���� �ν��Ͻ� ����
		Class[] parameterTypes = { String.class };										// parameterTypes��� �迭�� String �� �ְڴٰ� ����
		Constructor<?> cons = c1.getConstructor(parameterTypes);							// reflect.Constructor Ŭ������ cons ���� �� c1�� ������ �Ű������� �����´�. (= null)
		
		Object[] initags = {"������"};
		Person2 pKim = (Person2)cons.newInstance(initags);								// cons�� ���� Constructor Ŭ������ initags�� �Ű������� �ϴ� �ν��Ͻ� 'pKim' ����
		System.out.println(pKim);
		
		
		Class c2 = Class.forName("objectclass.Person2");
		Class[] parameterTypes1 = { String.class, Integer.class };
		Constructor cons1 = c2.getConstructor(parameterTypes1);
		
		Object[] initags2 = {"������", 31};
		Person2 wHwang = (Person2)cons1.newInstance(initags2);
		System.out.println(wHwang);
		
		//2���� �迭 initag3 �����ؼ� for������ ������ ���� 
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
