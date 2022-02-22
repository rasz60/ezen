public class ArrayEx04 {

	public static void main(String[] args) {

		char[] abc = { 'A', 'B', 'C', 'D' };
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.out.println(abc);
		System.out.println(num);
		
		
		char[] result = new char[abc.length + num.length];
		
		// abc 배열의 0번째부터 배열의 길이만큼 result 배열의 0번째부터 차례대로 대입
		System.arraycopy(abc, 0, result, 0, abc.length);
		
		// num 배열의 0번째부터 배열의 길이만큼 result 배열의 abc배열의 길이번째부터 차례대로 대입
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result);
			
		
		//abc배열의 0번째 부터 배열의 길이만큼 num 0번째부터 차례대로 대입
		System.arraycopy(abc, 0, num, 0, abc.length);
		System.out.println(num);
		//num = { 'A', 'B', 'C', 'D', '4', '5', '6', '7', '8', '9'};
		
		//abc배열의 0번째 부터 길이 3만큼 num 6번째부터 차례대로 대입
		System.arraycopy(abc, 0, num, 6, 3);
		System.out.println(num);
		//num = { 'A', 'B', 'C', 'D', '4', '5', 'A', 'B', 'C', '9'};
	}

}