import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamEx07 {

	public static void main(String[] args) {
		Student3[] stuArr = {
								new Student3("���ڹ�", true,  1, 1, 300),
								new Student3("������", false, 1, 1, 250),
								new Student3("���ڹ�", true,  1, 1, 200),
								new Student3("������", false, 1, 2, 150),
								new Student3("���ڹ�", true,  1, 2, 100),
								new Student3("������", false, 1, 2,  50),
								new Student3("Ȳ����", false, 1, 3, 100),
								new Student3("������", false, 1, 3, 150),
								new Student3("���ڹ�", true,  1, 3, 200),

								new Student3("���ڹ�", true,  2, 1, 300),
								new Student3("������", false, 2, 1, 250),
								new Student3("���ڹ�", true,  2, 1, 200),
								new Student3("������", false, 2, 2, 150),
								new Student3("���ڹ�", true,  2, 2, 100),
								new Student3("������", false, 2, 2,  50),
								new Student3("Ȳ����", false, 2, 3, 100),
								new Student3("������", false, 2, 3, 150),
								new Student3("���ڹ�", true,  2, 3, 200)
							};
		
		System.out.println("1. �ܼ�����(������ ����)");
		Map<Boolean, List<Student3>> stuBySex = Stream.of(stuArr)
													  .collect(partitioningBy(Student3::isMale));
		
		List<Student3> maleStudent = stuBySex.get(true);
		List<Student3> femaleStudent = stuBySex.get(false);		
		
		for( Student3 s : maleStudent ) {
			System.out.println(s);
		}
		
		for( Student3 s : femaleStudent ) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("2. �ܼ����� + ���(���� �л���)");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
											   .collect(partitioningBy(Student3::isMale, counting()));
		
		System.out.println("���л� �� : " + stuNumBySex.get(true));
		System.out.println("���л� �� : " + stuNumBySex.get(false));		
		System.out.println();
		
		System.out.println("3. �ܼ����� + ���(���� 1��)");
		Map<Boolean, Optional<Student3>> topScoreBySex = Stream.of(stuArr)
															   .collect(partitioningBy(Student3::isMale, maxBy(comparingInt(Student3::getScore))));
		
		System.out.println("���л� 1�� : " + topScoreBySex.get(true));
		System.out.println("���л� 1�� : " + topScoreBySex.get(false));
		
		//maxBy()�� Optional Ÿ������ ��ȯ�ǹǷ�, Optional�� get()�� �̿��ؼ� Student3Ÿ������ �ҷ��´�.
		Map<Boolean, Student3> topScoreBySex2 = Stream.of(stuArr)
													  .collect(partitioningBy(Student3::isMale, collectingAndThen(maxBy(comparingInt(Student3::getScore)), Optional::get)));
		
		System.out.println("���л� 1�� : " + topScoreBySex2.get(true));
		System.out.println("���л� 1�� : " + topScoreBySex2.get(false));
		System.out.println();
		
		System.out.println("4. ���ߺ���(���� ���հ���, 100�� ����)");
		
		Map<Boolean, Map<Boolean, List<Student3>>> failedStuBySex = Stream.of(stuArr)
																		  .collect(partitioningBy(Student3::isMale, partitioningBy(s -> s.getScore() <= 100)));
		
		List<Student3> failedMaleStu   = failedStuBySex.get(true).get(true);
		List<Student3> failedFemaleStu = failedStuBySex.get(false).get(true);
		
		for( Student3 s : failedMaleStu ) {
			System.out.println(s);
		}
		
		for( Student3 s : failedFemaleStu ) {
			System.out.println(s);
		}
		
	}

}

class Student3 {
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	Student3(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	String getName() {
		return name;
	}

	boolean isMale() {
		return isMale;
	}

	int getHak() {
		return hak;
	}

	int getBan() {
		return ban;
	}

	int getScore() {
		return score;
	}
	
	public String toString() {
		return String.format("[%s, %s, %d�г� %d��, %3d��]", name, isMale ? "��" : "��", hak, ban, score);	
	}
	
	enum Level { HIGH , MID , LOW }
	
}