package ch5;

public class Test5_08 {

	public static void main(String[] args) {

		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];
		

		 for ( int i = 0; i < answer.length; i++) {
		 	for ( int j = 0; j < 5; j++ ) {
		 		if (answer[i] == j) {
		 			counter[j-1]++;
		 		}
		 	}
		 }

/*		
		for ( int i = 0; i < answer.length; i++ ) {
				counter[answer[i] - 1]++;
			}
*/		

		System.out.println("배열 안에 숫자 개수");
		for ( int i = 0; i < counter.length; i++ ) {
			System.out.printf("%d : %d개 (", i+1, counter[i]);
			for ( int j = 1; j <= counter[i]; j++ ) {
				System.out.print("*");
			}
			System.out.println(")");
		}
	}
}
