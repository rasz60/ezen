package objectclass;

class Person {
	long id;

	Person(long id) {
		this.id = id;
	}
	
	public boolean equals(Object obj) {						//id�� ������ ���� ��ü�� �������� equals() ������
		if (obj != null && obj instanceof Person ) {
			return id == ((Person)obj).id;
		} else if ( obj != null && obj instanceof String ) {
			return this == obj;
		} else {
			return false;
		}
	}
	


}

public class EqualsEx02 {

	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);
		
		if ( p1 == p2 ) {
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		} else {
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
		}
		
		
		if ( p1.equals(p2) ) {
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		} else {
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
		}
		
		System.out.println("p1.hashCode() : " + p1.hashCode());
		System.out.println("p2.hashCode() : " + p2.hashCode());		
		System.out.println();
		
		String str1 = new String("ABC");
		String str2 = new String("ABC");		

		if ( str1 == str2 ) {
			System.out.println("str1�� str2�� �����ϴ�.");
		} else {
			System.out.println("str1�� str2�� �ٸ��ϴ�.");
		}
		
		
		if ( str1.equals(str2) ) {
			System.out.println("str1�� str2�� �����ϴ�.");
		} else {
			System.out.println("str1�� str2�� �ٸ��ϴ�.");
		}
		
		System.out.println("str1.hashCode() : " + str1.hashCode());
		System.out.println("str2.hashCode() : " + str2.hashCode());			

		
	}

}
