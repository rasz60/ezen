import java.util.ArrayList;
import java.util.Iterator;

public class Ex12_2 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("자바왕", 1, 1));
		list.add(new Student("자바짱", 1, 2));
		list.add(new Student("홍길동", 2, 1));
		
		Iterator<Student> it = list.iterator();
		while( it.hasNext() ) {
//			Student s = (Student)it.next();				// Generic을 사용하지 않으면 Object 타입으로 반환되기 때문에 형변환이 필요했다.
			Student s = it.next();
			System.out.println(s.name);
//			System.out.println(it.next().name);			// 객체 생성하지 않아도 Iterator로 객체의 속성값을 불러올 수 있다.
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
