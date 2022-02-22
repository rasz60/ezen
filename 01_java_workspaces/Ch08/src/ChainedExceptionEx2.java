
public class ChainedExceptionEx2 {

	public static void main(String[] args) {
		install();
	}

	static void install() {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException3 se) {										// SpaceException2가 발생하면 InstallException의 원인으로 등록하고, InstallException을 발생시킨다.
			InstallException2 ie = new InstallException2("설치 중 예외발생");		// 에러를 타입화하여 외부로 보여지게 할 때나 보안을 위해 에러의 이유를 외부로 밝히지 않아야할 때 사용
			ie.initCause(se);
			throw ie;
		} catch (MemoryException3 me) {
			InstallException2 ie = new InstallException2("설치 중 예외발생");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}
	
	static void startInstall() throws SpaceException3, MemoryException3 {
		if ( !enoughSpace() ) {
			throw new SpaceException3("설치할 공간이 부족합니다.");
		}
		if ( !enoughMemory() ) {
			throw new MemoryException3("메모리가 부족합니다.");
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

class InstallException2 extends RuntimeException {									// 테스트가 완료된 후에 카테고리화 한 예외의 조상 클래스를 RuntimeException으로 하면,
	InstallException2 (String msg) {												// try-catch를 생략하여 코드를 간단히 하고 보안을 강화할 수 있다.
		super(msg);
	}
}

class SpaceException3 extends Exception {
	SpaceException3 (String msg) {
		super(msg);
	}
}

class MemoryException3 extends Exception {
	MemoryException3 (String msg) {
		super(msg);
	}
}