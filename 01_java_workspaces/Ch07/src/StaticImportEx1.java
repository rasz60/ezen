
import static java.lang.System.out;
import static java.lang.Math.*;

public class StaticImportEx1 {

	public static void main(String[] args) {
		 System.out.println(Math.random());
		 System.out.println("Math.PI : " + Math.PI);
		 
		 //static ����� import�ϸ� Ŭ�������� �����ϰ� ȣ���� �� �ִ�.
		 out.println(random());
		 out.println("Math.PI : " + PI);
	}
}