import java.util.Arrays;
import java.util.stream.*;

public class StreamEx04 {

	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of( new String[] { "abc", "def", "jkl" },
												 new String[] { "ABC", "GHI", "JKL" });

//		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);					// 2차원 배열을 String Stream으로 전환 - 2차원의 Stream을 1차원으로 변환

		strStrm.map(String::toLowerCase)												// 요소들을 소문자로 전환
			   .distinct()																// 중복 제거
			   .sorted()																// 정렬
			   .forEach(System.out::println);											// 각각 출력
		System.out.println();

		String[] linArr = { "Believe or not It is true.",
							"Do or do not There is no try."
						  };

		Stream<String> lineStream = Arrays.stream(linArr);
		lineStream.flatMap( line -> Stream.of(line.split(" +")) )
				  .map(String::toLowerCase)
				  .distinct()
				  .sorted()
				  .forEach(System.out::println);
		System.out.println();

		Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");
		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
		Stream<String> strStream = strStrmStrm.map( s -> s.toArray(String[]::new) ).flatMap(Arrays::stream);
		strStream.map(String::toLowerCase)
				 .distinct()
				 .forEach(System.out::println);
	}

}
