
public class ExceptionEx10 {

	public static void main(String[] args) {
		try {
			Member member1 = new Member("김진웅");
			System.out.println("ID가 " + member1.ID + "이(가) 맞습니까?");
		} catch (WrongIDLengthException wile) {
			System.out.println("WrongIDLengthException!!");
		} catch (WrongIDLanguageException wile) {
			System.out.println("WrongIDLanguageException!!");
		}
			
	}

}

class WrongIDLengthException extends Exception {
	WrongIDLengthException(String msg) {
		super(msg);
	}
	
}

class WrongIDLanguageException extends Exception {
	WrongIDLanguageException(String msg) {
		super(msg);
	}
	
}



class Member {
	
	String ID;
	
	Member (String ID) throws WrongIDLengthException, WrongIDLanguageException {
		if ( ID.length() < 0 || ID.length() < 8 ) {
			throw new WrongIDLengthException("ID는 8자 이상으로 해야합니다.");
		}
		else {
			this.ID = ID;
		}
		char[] ch = ID.toCharArray();
		for (int i = 0; i < ch.length; i++ ) {
			if ( ch[i] < 'A' || ch[i] > 'z' ) {
			throw new WrongIDLanguageException("ID는 영문/숫자로만 만들 수 있습니다.");
			}
		}
	}
	
}