package ch5;

import java.util.Scanner;

public class Test5_12 {

	public static void main(String[] args) {

		String[][] quiz = {
				{"chair", "����"},
				{"computer", "��ǻ��"},
				{"integer", "����"}
		};
		
		int score = 0;
		Scanner sc = new Scanner(System.in);
		
		for ( int i = 0; i < quiz.length; i++ ) {
			System.out.printf("Q%d. %s�� ����? > ",i+1 ,quiz[i][0]);
			String x = sc.nextLine();
			
		}
	}

}