import java.util.Scanner;

public class ArrayEx23 {

	public static void main(String[] args) {
		String[][] word = {
				{"chair", "의자"},
				{"computer", "컴퓨터"},
				{"integer", "정수"}
		};
		
		Scanner sc = new Scanner(System.in);
	
	for ( int i = 0; i < word.length; i++ ) {
		System.out.printf("Q%d. %s의 뜻은? ", i+1, word[i][0]);
		String str = sc.nextLine();

		if (str.equals(word[i][1])) {
			System.out.println("ㅇㅇ, 정답입니다.");
			System.out.println();
			}

		else {
			System.out.printf("ㄴㄴ, 정답은 %s입니다.\n", word[i][1]);
			System.out.println();
			}
		
		}
	
	}
}
