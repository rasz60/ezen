public class Document {
	static int count = 0;
	String name;
	
	Document() {
		this("�������" + ++count);
	}
	
	Document(String name) {
		this.name = name;
		System.out.println("���� " + this.name + ".txt��(��) �����Ǿ����ϴ�.");
	}
	
}
