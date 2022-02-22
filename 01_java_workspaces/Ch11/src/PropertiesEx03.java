import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx03 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "한글");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		try {
			prop.store(new FileOutputStream("output.txt"), "Properties Example"); 		// 뒤에 String은 주석으로 들어감.
			prop.storeToXML(new FileOutputStream("output.xml"), "Properties Example");
			System.out.println("파일이 작성되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
