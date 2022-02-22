package etcutil;

import static java.util.Objects.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ObjectsTest {

	public static void main(String[] args) {
		String[][] str2D   = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D_2 = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		
		System.out.print("str2D = { ");
		for( String[] tmp : str2D ) {
			System.out.print(Arrays.toString(tmp));
		}
		System.out.println(" }");
		
		System.out.print("str2D_2 = { ");
		for( String[] tmp : str2D_2 ) {
			System.out.print(Arrays.toString(tmp));
		}
		System.out.println(" }");
		
		System.out.println("equals(str2D, str2D_2) = "     + Objects.equals(str2D, str2D_2));
		System.out.println("deepEquals(str2D, str2D_2) = " + deepEquals(str2D, str2D_2));
		System.out.println("isNull(null) = "               + isNull(null));
		System.out.println("nonNull(null) = " 			   + nonNull(null));
		System.out.println("hashCode(null) = " 			   + Objects.hashCode(null));
		System.out.println("toString(null) = "             + Objects.toString(null));
		System.out.println("toString(null, \"\") = " 	   + Objects.toString(null, "!"));					// 2번째 매개변수(nullDefault)는 첫번째 매개변수가 null일 때 출력함.
		
		
		Comparator c = String.CASE_INSENSITIVE_ORDER;														// 오름-내림차순 정리시 유용
		
		System.out.println("compare(\"aa\", \"bb\") = " + compare("aa", "bb", c));							// 매개변수 a가 b보다 작으면 -1
		System.out.println("compare(\"bb\", \"aa\") = " + compare("bb", "aa", c));							// 매개변수 a가 b보다 크면  1
		System.out.println("compare(\"ab\", \"AB\") = " + compare("ab", "AB", c));							// 매개변수 a가 b보다 작으면  0
	}

}
