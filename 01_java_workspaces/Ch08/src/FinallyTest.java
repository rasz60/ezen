
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
			deleteTempFiles();							//exception과 상관없이 무조건 수행하는 내용을 finally문으로 선언
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
