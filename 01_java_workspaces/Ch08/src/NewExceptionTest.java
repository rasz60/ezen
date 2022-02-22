
public class NewExceptionTest {

	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		} catch ( SpaceException se ) {
			System.out.println("에러 메시지 : " + se.getMessage());
			se.printStackTrace();
			System.out.println("공간 확보 후에 다시 설치해주세요.");
		} catch ( MemoryException me ) {
			System.out.println("에러 메시지 : " + me.getMessage());
			me.printStackTrace();
			System.gc();
			System.out.println("다시 설치를 시도해주세요.");	
		} finally {
			deleteTempFiles();
		}
	}

	static void startInstall() throws SpaceException, MemoryException {
		System.out.println("설치 시작.");
		if ( !enoughSpace() ) {
			throw new SpaceException("설치할 공간이 부족합니다.");
		}
		
		if ( !enoughMemory() ) {
			throw new MemoryException("메모리가 부족합니다.");
		}
	}
	
	static void copyFiles() {
		System.out.println("파일 복사.");
	}
	
	static void deleteTempFiles() {
		System.out.println("임시파일 제거.");
	}
	
	static boolean enoughSpace() {
		return false;
	}
	
	static boolean enoughMemory() {
		return true;
	}
	
}

class SpaceException extends Exception {
	SpaceException(String msg) {
		super(msg);
	}
}

class MemoryException extends Exception {
	MemoryException(String msg) {
		super(msg);
	}
}