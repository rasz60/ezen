
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
		} catch (SpaceException2 se) {										// SpaceException2�� �߻��ϸ� InstallException�� �������� ����ϰ�, InstallException�� �߻���Ų��.
			InstallException ie = new InstallException("��ġ �� ���ܹ߻�");		// ������ Ÿ��ȭ�Ͽ� �ܺη� �������� �� ���� ������ ���� ������ ������ �ܺη� ������ �ʾƾ��� �� ���
			ie.initCause(se);
			throw ie;
		} catch (MemoryException2 me) {
			InstallException ie = new InstallException("��ġ �� ���ܹ߻�");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}
	
	static void startInstall() throws SpaceException2, MemoryException2 {
		if ( !enoughSpace() ) {
			throw new SpaceException2("��ġ�� ������ �����մϴ�.");
		}
		if ( !enoughMemory() ) {
			throw new MemoryException2("�޸𸮰� �����մϴ�.");
//			throw new RuntimeException(new MemoryException("�޸𸮰� �����մϴ�."));
		}
	}
	
	static void copyFiles() {
		System.out.println("���� ����.");
	}
	
	static void deleteTempFiles() {
		System.out.println("�ӽ����� ����.");
	}
	
	static boolean enoughSpace() {
		System.out.println("��ġ ���� ���� Ȯ�� ��");
		return false;
	}
	
	static boolean enoughMemory() {
		System.out.println("��ġ ���� �޸� Ȯ�� ��");
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