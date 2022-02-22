
public class ParserManager {
	
	//String(XML or HTML)을 받아서, Parseable 인터페이스를 구현한 2개의 클래스에 새로운 인스턴스릉 생성하여 리턴
	//static 메서드이기 때문에 인스턴스 생성없이 해당 클래스의 메서드를 불러올 수 있다.
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
