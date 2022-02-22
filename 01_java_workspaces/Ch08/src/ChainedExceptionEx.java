
public class ChainedExceptionEx {

	public static void main(String[] args) {
		try {
			install();
		} catch (InstallException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException2 se) {										// SpaceException2가 발생하면 InstallException의 원인으로 등록하고, InstallException을 발생시킨다.
			InstallException ie = new InstallException("설치 중 예외발생");		// 에러를 타입화하여 외부로 보여지게 할 때나 보안을 위해 에러의 이유를 외부로 밝히지 않아야할 때 사용
			ie.initCause(se);
			throw ie;
		} catch (MemoryException2 me) {
			InstallException ie = new InstallException("설치 중 예외발생");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}
	
	static void startInstall() throws SpaceException2, MemoryException2 {
		if ( !enoughSpace() ) {
			throw new SpaceException2("설치할 공간이 부족합니다.");
		}
		if ( !enoughMemory() ) {
			throw new MemoryException2("메모리가 부족합니다.");
//			throw new RuntimeException(new MemoryException("메모리가 부족합니다."));
		}
	}
	
	static void copyFiles() {
		System.out.println("파일 복사.");
	}
	
	static void deleteTempFiles() {
		System.out.println("임시파일 제거.");
	}
	
	static boolean enoughSpace() {
		System.out.println("설치 가능 공간 확인 중");
		return false;
	}
	
	static boolean enoughMemory() {
		System.out.println("설치 가능 메모리 확인 중");
		return true;
	}
}

class InstallException extends Exception {
	InstallException (String msg) {
		super(msg);
	}
}

class SpaceException2 extends Exception {
	SpaceException2 (String msg) {
		super(msg);
	}
}

class MemoryException2 extends Exception {
	MemoryException2 (String msg) {
		super(msg);
	}
}