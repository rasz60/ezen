import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx03 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "�ѱ�");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		try {
			prop.store(new FileOutputStream("output.txt"), "Properties Example"); 		// �ڿ� String�� �ּ����� ��.
			prop.storeToXML(new FileOutputStream("output.xml"), "Properties Example");
			System.out.println("������ �ۼ��Ǿ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
