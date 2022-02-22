import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx00_1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();
		
		intStream.forEach(System.out::print);
//		intStream.forEach(System.out::print);											// Stream은 일회용이므로, 다시 값을 대입해서 써야한다.
		System.out.println();
		
		intStream = list.stream();
		System.out.print("count = " + intStream.count());
		System.out.println();
		
		Stream<String> strStream = Stream.of("a", "b", "c");
		strStream.forEach(System.out::print);
		System.out.println();
		
		strStream = Stream.of(new String[] {"e", "f", "g"});
		strStream.forEach(System.out::print);
		System.out.println();
		
		strStream = Arrays.stream(new String[] {"h", "i", "j"});
		strStream.forEach(System.out::print);
		System.out.println();
		
		strStream = Arrays.stream(new String[] {"a", "b", "c", "d", "e"}, 1, 5);		// index 1 ~ 5까지 스트림에 저장
		strStream.forEach(System.out::print);
		System.out.println();
		
		int[] intArr = {1, 2, 3, 4, 5};
		IntStream intStream2 = Arrays.stream(intArr);
		intStream2.forEach(System.out::print);
		System.out.println();
		
		intStream2 = Arrays.stream(intArr);
		System.out.println("sum = " + intStream2.sum());
		
	}

}
