import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx03 {

	public static void main(String[] args) {
		Student[] stuArr = {
							new Student("���ڹ�", 3, 300),
							new Student("���ڹ�", 1, 200),
							new Student("���ڹ�", 2, 100),
							new Student("���ڹ�", 2, 150),
							new Student("���ڹ�", 1, 200),
							new Student("���ڹ�", 3, 290),
							new Student("���ڹ�", 3, 180),
						   };
		
		Stream<Student> stuStream = Stream.of(stuArr);
		
		stuStream.sorted(Comparator.comparing(Student::getBan)
				 		.thenComparing(Comparator.naturalOrder()))
						.forEach(System.out::println);
		
		stuStream = Stream.of(stuArr);
		IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);
		
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		System.out.println("count : " + stat.getCount());
		System.out.println("sum : " + stat.getSum());
		System.out.printf("average : %.2f%n", stat.getAverage());
		System.out.println("min : " + stat.getMin());
		System.out.println("max : " + stat.getMax());
	}

}
