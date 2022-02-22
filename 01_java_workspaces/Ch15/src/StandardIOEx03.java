import java.io.*;
public class StandardIOEx03 {

	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		
		try {
			fos=new FileOutputStream("test.txt");
			ps = new PrintStream(fos);
			System.setOut(ps);
		}catch(FileNotFoundException e) {
			System.out.println("File not fount.");
		}
		
		System.out.println("Hello by System.out");
		System.err.println("Hello by System.err");
	}

}
