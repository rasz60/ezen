
public class ParserTest {

	public static void main(String[] args) {

		Parseable parser = ParserManager.getParseable("XML");
		parser.parse("document.xml");
		
		parser = ParserManager.getParseable("HTML");
		parser.parse("document.html");
		
	}

}
