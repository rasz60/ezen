public class TvTest {

	public static void main(String[] args) {

		Tv t;
		t = new Tv();
		//Tv t = new Tv();
		
		t.channel = 7;

		t.channelDown();
		System.out.printf("���� ä���� %d�Դϴ�.\n", t.channel);
		
		t.channelUp();
		System.out.printf("���� ä���� %d�Դϴ�.\n", t.channel);
		
	}

}
