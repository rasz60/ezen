
public class ParserManager {
	
	//String(XML or HTML)�� �޾Ƽ�, Parseable �������̽��� ������ 2���� Ŭ������ ���ο� �ν��Ͻ��� �����Ͽ� ����
	//static �޼����̱� ������ �ν��Ͻ� �������� �ش� Ŭ������ �޼��带 �ҷ��� �� �ִ�.
	public static Parseable getParseable(String type) {
		if ( type == "XML" ) {
			return new XMLParser();
		}
		
		else {
			Parseable p = new HTMLParser();
			return p;
			//return new HTMLParser();
		}
	}
	
}
