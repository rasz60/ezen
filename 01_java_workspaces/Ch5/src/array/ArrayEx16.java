package array;

public class ArrayEx16 {

	public static void main(String[] args) {
		if ( args != null ) {
		System.out.println("�Ű������� ���� : " + args.length);
		
			for (int i = 0; i < args.length; i++ ) {
				System.out.println("args[" + i + "] = \""+ args[i] + "\"");
			}
		}
	}
}
