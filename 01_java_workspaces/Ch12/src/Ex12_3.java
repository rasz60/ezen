import java.util.HashMap;

public class Ex12_3 {
	static int ID = 1;
	
	public static void main(String[] args) {
		HashMap<Integer, Student> map = new HashMap<>();
		map.put(ID++, new Student("�ڹٿ�", 1, 1));
		map.put(ID++, new Student("�ڹ�¯", 1, 2));
		map.put(ID++, new Student("ȫ�浿", 2, 1));
		
		System.out.println(map);
		
		Student s = map.get(2);
		System.out.println(s.name + " " + s.ban + " " + s.no);
	}

}