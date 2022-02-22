import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx01 {

	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
													new Student ( "���ڹ�", 3, 300 ),
													new Student ( "���ڹ�", 1, 200 ),
													new Student ( "���ڹ�", 2, 100 ),
													new Student ( "���ڹ�", 2, 150 ),
													new Student ( "���ڹ�", 1, 200 ),
													new Student ( "���ڹ�", 3, 290 ),
													new Student ( "���ڹ�", 3, 180 ) 
												);
		
							
		studentStream.sorted( Comparator.comparing(Student::getBan)						// �� Student ��ü�� Ban�� �����ͼ� ������� ������ ����
							 .thenComparing(Comparator.naturalOrder()) )				// natureOrder() : Comparable�� ������ ����(���� ��)�� ����
					 .forEach(System.out::println);
	}

}

class Student implements Comparable<Student> {

	String name;
	int ban;
	int totalScore;
	
	Student( String name, int ban, int totalScore ) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
		
	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	@Override
	public int compareTo(Student s) {													// Student ��ü�� �⺻ ���� �� �޼���
		return s.totalScore - this.totalScore;
	}
	
}