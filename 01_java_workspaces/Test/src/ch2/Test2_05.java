package ch2;

public class Test2_05 {

	public static void main(String[] args) {

		System.out.println("1" + "2");
		// 출력 : 12
		
		System.out.println(true + "");
		// 출력 : 없음 ->ㄴㄴ true(..!)
		// true는 String형식으로 출력이 된다..?
		
		System.out.println('A' + 'B');
		// 출력 : AB ->ㄴㄴ 131
		// char의 합은 String x
		// 각 char의 아스키 코드값의 합이 정수로 나옴
		
		System.out.println('1' + "2");
		// 출력 : 12
		// char + String = String
		
		System.out.println('1' + '2');
		// 출력 : 12 ->ㄴㄴ 99
		// char의 합은 String x
		// 각 char의 아스키 코드값의 합이 정수로 나옴
		
		System.out.println('J' + "ava");
		// 출력 : Java
		// char + String = String
		
	  //System.out.println(true + null);	
		// 출력 : 오류
			
		

	}

}
