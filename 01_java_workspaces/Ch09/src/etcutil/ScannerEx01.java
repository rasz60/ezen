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
			argArr = input.split(" +");								// 공백 1개 이상일 때 구분되게하는 정규식 사용
			
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
			}//if 끝
		}//while 끝

	}
}
