import java.io.*;
public class RandomAccessFileEx01 {

	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("test.dat","rw");
			System.out.println("���� �������� ��ġ: "+raf.getFilePointer());
			raf.writeInt(100);
			System.out.println("���� �������� ��ġ: "+raf.getFilePointer());
			raf.writeLong(100L);
			System.out.println("���� �������� ��ġ: "+raf.getFilePointer());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}