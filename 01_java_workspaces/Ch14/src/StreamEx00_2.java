import java.util.Random;
import java.util.stream.IntStream;

public class StreamEx00_2 {

	public static void main(String[] args) {
		IntStream intStream1 = new Random().ints();					// �������� longŸ�� ���� ����
		intStream1.limit(5).forEach(System.out::println);				// limit(5).forEach(��¹�) : 5�������� �ⷰ
		System.out.println();
		
		IntStream intStream2 = new Random().ints(5);				// longŸ�� ���� 5�� ����
		intStream2.forEach(System.out::println);
		System.out.println();
		
		IntStream intStream3 = new Random().ints(5,11);				// 5�̻� 11�̸��� longŸ�� ���� ����
		intStream3.distinct().limit(5).forEach(System.out::println);  // distinct() : �ߺ� ����
		System.out.println();
		
		IntStream intStream4 = new Random().ints(10,5,11);			// 5�̻� 11�̸��� longŸ�� ���� 10�� ����
		intStream4.forEach(System.out::println);
		
	}

}
