
import java.io.*;
import java.util.ArrayList;

public class SerialEx01 {

	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			
			UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
			UserInfo u2 = new UserInfo("JavaWoman", "4321", 26);			
			UserInfo u3 = new UserInfo();
			
			ArrayList<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			list.add(u3);
			
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(u3);
			out.writeObject(list);
			out.close();
			System.out.println("직렬화가 잘 끝났습니다.");
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		
		
	}

}
