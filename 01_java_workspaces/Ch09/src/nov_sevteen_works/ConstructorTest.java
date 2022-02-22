package nov_sevteen_works;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ConstructorTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		String[] man_sFirstName   = { "Justin", "Kendrick", "Kanye", "Chris", "Tom", "Michael" };
		String[] woman_sFirstName = { "Amy", "Anne", "Selena", "Ariana", "Zendaya", "Rachel" };
		
		String[] man_sLastName   = { "Bieber", "Lamar", "West", "Hemsworth", "Holland", "Jackson" };
		String[] woman_sLastName = { "Winehouse", "Hathaway", "Gomes", "Grande", "Coleman", "McAdams" };		
		
		String[] gender = { "MAN", "WOMAN" };	
		
		Object[][] initag = new Object[12][2];		
		
		for ( int i = 0; i < initag.length; i++ ) {
			Random random = new Random();
			StringBuffer name = new StringBuffer();
			Integer age;
			if ( gender[random.nextInt(gender.length-1)].equals(gender[0]) ) {
				name.append(man_sFirstName[random.nextInt(man_sFirstName.length - 1)]).append(" ").append(man_sLastName[random.nextInt(man_sLastName.length - 1)]);
				age = ((random.nextInt(3) + 2) * 10) + random.nextInt(9);
			} else {
				name.append(woman_sFirstName[random.nextInt(woman_sFirstName.length - 1)]).append(" ").append(woman_sLastName[random.nextInt(woman_sLastName.length - 1)]);
				age = ((random.nextInt(4) + 1) * 10) + random.nextInt(9);
			}
			initag[i][0] = name;
			initag[i][1] = age;
		}

		Class c1 = Class.forName("nov_sevteen_works.Person3");
		Class[] parameterTypes = { StringBuffer.class, Integer.class };
		Constructor cons = c1.getConstructor(parameterTypes);
		
		for ( int i = 0; i < initag.length; i++ ) {
			Person3 person = (Person3)cons.newInstance(initag[i]);
			System.out.println("person" + (i+1) + " : " + person);
		}

	}
}
