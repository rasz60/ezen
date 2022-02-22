package objectclass;

final class Card3 {
	String kind;
	int num;
	
	Card3() {
		this("SPADE", 1);
	}
	
	Card3(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	public String toString() {
		switch(kind) {
			case "SPADE" :
				this.kind = "��";
				break;
			case "CLOVER" :
				this.kind = "��";
				break;
			case "HEART" :
				this.kind = "��";
				break;
			case "DIAMOND" :
				this.kind = "��";
				break;
			default :
				this.kind = null;
				break;
		}
		return this.kind + this.num;
	}

}

public class ClassEx01 {

	public static void main(String[] args) throws Exception {
		Card3 c = new Card3("HEART", 3);
		Card3 c2 = Card3.class.newInstance();
		
		Class cObj = c.getClass();									// Class Ÿ�Կ� cObj ��ü�� c�� ��ü ������ �־� ��
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(cObj.getName());							// Ŭ������ �̸� ��������
		System.out.println(cObj.toGenericString());					// ������, Ŭ���� or �������̽�..., Ŭ���� �̸�
		System.out.println(cObj.toString());						// Class Ŭ������ ���ǵ� toString ('Ŭ���� or �������̽�...' Ŭ������)
		
	}

}
