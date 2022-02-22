
import java.io.*;
import java.util.ArrayList;

public class SerialEx04 {

	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			
			UserInfo2 u1 = (UserInfo2)in.readObject();
			UserInfo2 u2 = (UserInfo2)in.readObject();
			UserInfo2 u3 = (UserInfo2)in.readObject();
			ArrayList list = (ArrayList)in.readObject();
			
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(u3);
			System.out.println(list);
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}