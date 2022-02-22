import java.util.ArrayList;
import java.util.Iterator;

public class Ex12_2 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("�ڹٿ�", 1, 1));
		list.add(new Student("�ڹ�¯", 1, 2));
		list.add(new Student("ȫ�浿", 2, 1));
		
		Iterator<Student> it = list.iterator();
		while( it.hasNext() ) {
//			Student s = (Student)it.next();				// Generic�� ������� ������ Object Ÿ������ ��ȯ�Ǳ� ������ ����ȯ�� �ʿ��ߴ�.
			Student s = it.next();
			System.out.println(s.name);
//			System.out.println(it.next().name);			// ��ü �������� �ʾƵ� Iterator�� ��ü�� �Ӽ����� �ҷ��� �� �ִ�.
		}
		
	}

}

class Student {
	
	String name= "";
	int ban;
	int no;
	
	Student(String name, int ban, int no) {
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
}
