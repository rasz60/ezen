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
				this.kind = "♠";
				break;
			case "CLOVER" :
				this.kind = "♣";
				break;
			case "HEART" :
				this.kind = "♥";
				break;
			case "DIAMOND" :
				this.kind = "◆";
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
		
		Class cObj = c.getClass();									// Class 타입에 cObj 객체에 c의 객체 정보를 넣어 줌
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(cObj.getName());							// 클래스의 이름 가져오기
		System.out.println(cObj.toGenericString());					// 제어자, 클래스 or 인터페이스..., 클래스 이름
		System.out.println(cObj.toString());						// Class 클래스에 정의된 toString ('클래스 or 인터페이스...' 클래스명)
		
	}

}
