package etcutil;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String[] argArr = null;
		
		while(true) {
			String prompt = ">>";
			System.out.println(prompt);
			
			String input = s.nextLine();
			
			input = input.trim();
			argArr = input.split(" +");								// ���� 1�� �̻��� �� ���еǰ��ϴ� ���Խ� ���
			
			String command = argArr[0].trim();
			
			if ( "".equals(command) ) {
				continue;
			}
			
			command = command.toLowerCase();
			
			if ( command.equals("q") ) {
				System.out.println("bYe..");
				System.exit(0);
			} else {
				for ( int i = 0; i < argArr.length; i++ ) {
					System.out.println(argArr[i]);
				}
			}//if ��
		}//while ��

	}
}
