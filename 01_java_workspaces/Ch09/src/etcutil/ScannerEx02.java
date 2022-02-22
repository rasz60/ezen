package etcutil;

import java.io.File;
import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("src\\etcutil\\Untitled 4.txt"));
		int sum = 0;
		int cnt = 0;
		// hasNextInt() : 그 다음으로 읽어들일 라인에 int가 있는지 확인 (boolean)
		while ( sc.hasNextInt() ) {											
			sum += sc.nextInt();
			cnt++;
		}
		
//		for (cnt = 0; sc.hasNextInt(); cnt++) {
//			sum += sc.nextInt();
//		}
		
		System.out.println("sum = " + sum);
		System.out.println("average = " + (double)sum/cnt);

	}
}
