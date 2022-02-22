
public class FinallyTest {

	public static void main(String[] args) {

		try {
			startInstall();
			copyFiles();
//			deleteTempFiles();
		} catch ( Exception e ) {
			e.printStackTrace();
//			deleteTempFiles();
		} finally {
			deleteTempFiles();							//exception�� ������� ������ �����ϴ� ������ finally������ ����
		}
		
	}
		
	static void startInstall() {
		System.out.println("Start Install.");
	}
	
	static void copyFiles() {
		System.out.println("Copy Files.");
	}
	
	static void deleteTempFiles() {
		System.out.println("Delete Temp Files.");
	}
	
}
