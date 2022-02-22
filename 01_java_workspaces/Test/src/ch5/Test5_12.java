package ch5;

import java.util.Scanner;

public class Test5_12 {

	public static void main(String[] args) {

		String[][] quiz = {
				{"chair", "의자"},
				{"computer", "컴퓨터"},
				{"integer", "정수"}
		};
		
		int score = 0;
		Scanner sc = new Scanner(System.in);
		
		for ( int i = 0; i < quiz.length; i++ ) {
			System.out.printf("Q%d. %s의 뜻은? > ",i+1 ,quiz[i][0]);
			String x = sc.nextLine();
			
		}
	}

}