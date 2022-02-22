import java.util.Random;
import java.util.stream.IntStream;

public class StreamEx00_2 {

	public static void main(String[] args) {
		IntStream intStream1 = new Random().ints();					// 무한으로 long타입 난수 생성
		intStream1.limit(5).forEach(System.out::println);				// limit(5).forEach(출력문) : 5개까지만 출럭
		System.out.println();
		
		IntStream intStream2 = new Random().ints(5);				// long타입 난수 5개 생성
		intStream2.forEach(System.out::println);
		System.out.println();
		
		IntStream intStream3 = new Random().ints(5,11);				// 5이상 11미만의 long타입 난수 생성
		intStream3.distinct().limit(5).forEach(System.out::println);  // distinct() : 중복 제거
		System.out.println();
		
		IntStream intStream4 = new Random().ints(10,5,11);			// 5이상 11미만의 long타입 난수 10개 생성
		intStream4.forEach(System.out::println);
		
	}

}
