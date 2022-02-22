import java.util.ArrayList;

class Member {
	ArrayList arrList = new ArrayList();
	
	String name;
	public ArrayList getArrList() {
		return arrList;
	}

	public void setArrList(ArrayList arrList) {
		this.arrList = arrList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	int ID = 1;
	int age;

	private Member () {}
	
	public Member (String name, int age) {
		Member m = new Member();
		this.name = name;
		this.age = age;
		ID = ID + 1;
		ID++;
		arrList.add(m);
	}
	
//	public Member findMemberToID(String name) {
//		
//		for ( int i = 0; i < arrList.size(); i++ ) {
//			arrList[i].getName();
//			if (  ) {
//				
//				
//			}
//		}
//	}
	
	public String toString() {
		return "ID : " + ID + ", MemberName : " + name + ", age : " + age;
	}
	
}


public class ArrayList0 {

	public static void main(String[] args) {
		Member member1 = new Member("±èÁø¿õ", 31);
		
		
		

		
	}

}
