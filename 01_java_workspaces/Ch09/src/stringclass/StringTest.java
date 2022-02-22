package stringclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StringTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class c = Class.forName("java.lang.String");

		Constructor<String>[] cons = c.getConstructors();

		System.out.println("String Constructor----------------------------------------------------------------------------");
		System.out.println();
		for ( Constructor<String> con : cons ) { 
			System.out.println(con);
		}
		System.out.println();
		System.out.println("String Methods--------------------------------------------------------------------------------");
		System.out.println();


		Method[] methods = c.getMethods();
		for ( Method m : methods ) {
			System.out.println(m);
		}
		
		System.out.println();
		System.out.println("Person2 Constructor---------------------------------------------------------------------------");
		System.out.println();
		
		
		Class c2 = Class.forName("objectclass.Person2");
		Constructor<String>[] cons2 = c2.getConstructors();
		for ( Constructor<String> con : cons2 ) { 
		System.out.println(con);
		}
		
		System.out.println();
		System.out.println("Person2 Methods-------------------------------------------------------------------------------");
		System.out.println();
		
		Method[] methods2 = c2.getMethods();
		for ( Method m : methods2 ) {
			System.out.println(m);
		}
			
	}
}
