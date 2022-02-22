
public class ExceptionEx10 {

	public static void main(String[] args) {
		try {
			Member member1 = new Member("������");
			System.out.println("ID�� " + member1.ID + "��(��) �½��ϱ�?");
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
			throw new WrongIDLengthException("ID�� 8�� �̻����� �ؾ��մϴ�.");
		}
		else {
			this.ID = ID;
		}
		char[] ch = ID.toCharArray();
		for (int i = 0; i < ch.length; i++ ) {
			if ( ch[i] < 'A' || ch[i] > 'z' ) {
			throw new WrongIDLanguageException("ID�� ����/���ڷθ� ���� �� �ֽ��ϴ�.");
			}
		}
	}
	
}