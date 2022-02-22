
public class NewExceptionTest {

	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		} catch ( SpaceException se ) {
			System.out.println("���� �޽��� : " + se.getMessage());
			se.printStackTrace();
			System.out.println("���� Ȯ�� �Ŀ� �ٽ� ��ġ���ּ���.");
		} catch ( MemoryException me ) {
			System.out.println("���� �޽��� : " + me.getMessage());
			me.printStackTrace();
			System.gc();
			System.out.println("�ٽ� ��ġ�� �õ����ּ���.");	
		} finally {
			deleteTempFiles();
		}
	}

	static void startInstall() throws SpaceException, MemoryException {
		System.out.println("��ġ ����.");
		if ( !enoughSpace() ) {
			throw new SpaceException("��ġ�� ������ �����մϴ�.");
		}
		
		if ( !enoughMemory() ) {
			throw new MemoryException("�޸𸮰� �����մϴ�.");
		}
	}
	
	static void copyFiles() {
		System.out.println("���� ����.");
	}
	
	static void deleteTempFiles() {
		System.out.println("�ӽ����� ����.");
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