import java.util.Scanner;

public class ArrayEx23 {

	public static void main(String[] args) {
		String[][] word = {
				{"chair", "����"},
				{"computer", "��ǻ��"},
				{"integer", "����"}
		};
		
		Scanner sc = new Scanner(System.in);
	
	for ( int i = 0; i < word.length; i++ ) {
		System.out.printf("Q%d. %s�� ����? ", i+1, word[i][0]);
		String str = sc.nextLine();

		if (str.equals(word[i][1])) {
			System.out.println("����, �����Դϴ�.");
			System.out.println();
			}

		else {
			System.out.printf("����, ������ %s�Դϴ�.\n", word[i][1]);
			System.out.println();
			}
		
		}
	
	}
}
