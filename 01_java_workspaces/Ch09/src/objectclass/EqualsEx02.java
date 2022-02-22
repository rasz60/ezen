package objectclass;

class Person {
	long id;

	Person(long id) {
		this.id = id;
	}
	
	public boolean equals(Object obj) {						//id가 같으면 같은 객체로 나오도록 equals() 재정의
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
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
		
		
		if ( p1.equals(p2) ) {
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
		
		System.out.println("p1.hashCode() : " + p1.hashCode());
		System.out.println("p2.hashCode() : " + p2.hashCode());		
		System.out.println();
		
		String str1 = new String("ABC");
		String str2 = new String("ABC");		

		if ( str1 == str2 ) {
			System.out.println("str1과 str2는 같습니다.");
		} else {
			System.out.println("str1과 str2는 다릅니다.");
		}
		
		
		if ( str1.equals(str2) ) {
			System.out.println("str1과 str2는 같습니다.");
		} else {
			System.out.println("str1과 str2는 다릅니다.");
		}
		
		System.out.println("str1.hashCode() : " + str1.hashCode());
		System.out.println("str2.hashCode() : " + str2.hashCode());			

		
	}

}
