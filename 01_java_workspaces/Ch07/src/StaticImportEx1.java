
import static java.lang.System.out;
import static java.lang.Math.*;

public class StaticImportEx1 {

	public static void main(String[] args) {
		 System.out.println(Math.random());
		 System.out.println("Math.PI : " + Math.PI);
		 
		 //static 멤버를 import하면 클래스명을 생략하고 호출할 수 있다.
		 out.println(random());
		 out.println("Math.PI : " + PI);
	}
}