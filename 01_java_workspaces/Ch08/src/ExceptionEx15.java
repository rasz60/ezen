import java.io.*;

public class ExceptionEx15 {

	public static void main(String[] args) {	
		File f = createFile(args[0]);
		System.out.println("'" + f.getName() + "' ���� ������ �Ϸ�Ǿ����ϴ�.");
	}

	static File createFile(String fileName) {
		try {
			if ( fileName == null || fileName.equals("") ) 
				throw new Exception("���ϸ��� ��ȿ���� �ʽ��ϴ�.");

		} catch ( Exception e ) {
			fileName = "�������.txt";
		} finally {
			File f = new File(fileName);
			createNewFile(f);
			return f;
		}
	}
	
	static void createNewFile(File f) {
		try {
			f.createNewFile();	
		} catch ( Exception e ) {	}
	}
	
}
