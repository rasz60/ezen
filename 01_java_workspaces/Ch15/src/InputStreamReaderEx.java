
import java.io.*;
public class InputStreamReaderEx {

	public static void main(String[] args) {
		String line = "";
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("������� OS�� ���ڵ� :"+isr.getEncoding());
			
			do {
				System.out.print("������ �Է��ϼ���. ��ġ�÷��� q�� �Է��ϼ���.>");
				line= br.readLine();
				System.out.println("�Է��Ͻ� ���� : "+line);
			}while(!line.equals("q"));
			
			System.out.println("���Ϸ��� �����մϴ�.");
		}catch(IOException e) {}
		
	}

}
