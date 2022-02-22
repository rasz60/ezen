
import java.io.*;
import java.util.ArrayList;

public class SerialEx02 {

	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			
			UserInfo u1 = (UserInfo)in.readObject();
			UserInfo u2 = (UserInfo)in.readObject();
			UserInfo u3 = (UserInfo)in.readObject();
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
