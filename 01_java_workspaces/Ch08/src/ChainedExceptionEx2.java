
public class ChainedExceptionEx2 {

	public static void main(String[] args) {
		install();
	}

	static void install() {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException3 se) {										// SpaceException2�� �߻��ϸ� InstallException�� �������� ����ϰ�, InstallException�� �߻���Ų��.
			InstallException2 ie = new InstallException2("��ġ �� ���ܹ߻�");		// ������ Ÿ��ȭ�Ͽ� �ܺη� �������� �� ���� ������ ���� ������ ������ �ܺη� ������ �ʾƾ��� �� ���
			ie.initCause(se);
			throw ie;
		} catch (MemoryException3 me) {
			InstallException2 ie = new InstallException2("��ġ �� ���ܹ߻�");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}
	
	static void startInstall() throws SpaceException3, MemoryException3 {
		if ( !enoughSpace() ) {
			throw new SpaceException3("��ġ�� ������ �����մϴ�.");
		}
		if ( !enoughMemory() ) {
			throw new MemoryException3("�޸𸮰� �����մϴ�.");
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

class InstallException2 extends RuntimeException {									// �׽�Ʈ�� �Ϸ�� �Ŀ� ī�װ�ȭ �� ������ ���� Ŭ������ RuntimeException���� �ϸ�,
	InstallException2 (String msg) {												// try-catch�� �����Ͽ� �ڵ带 ������ �ϰ� ������ ��ȭ�� �� �ִ�.
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