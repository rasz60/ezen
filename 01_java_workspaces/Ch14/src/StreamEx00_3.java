import java.util.stream.Stream;

public class StreamEx00_3 {

	public static void main(String[] args) {
		Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2 * 2);
		
		evenStream.limit(5).forEach(System.out::println);
		System.out.println();
		
		Stream<Integer> oneStream = Stream.generate(() -> 1);
		oneStream.limit(5).forEach(System.out::println);
		System.out.println();
		
		Stream<Double> randomStream = Stream.generate(Math::random);
		randomStream.limit(5).forEach(System.out::println);
	}

}
