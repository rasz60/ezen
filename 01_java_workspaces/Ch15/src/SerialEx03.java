
import java.io.*;
import java.util.ArrayList;

public class SerialEx03 {

	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			
			UserInfo2 u1 = new UserInfo2("JavaMan", "1234", 30);
			UserInfo2 u2 = new UserInfo2("JavaWoman", "4321", 26);			
			UserInfo2 u3 = new UserInfo2();
			
			ArrayList<UserInfo2> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			list.add(u3);
			
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(u3);
			out.writeObject(list);
			out.close();
			System.out.println("����ȭ�� �� �������ϴ�.");
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		
		
	}

}