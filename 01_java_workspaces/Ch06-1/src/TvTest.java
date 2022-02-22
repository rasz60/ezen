public class TvTest {

	public static void main(String[] args) {

		Tv t;
		t = new Tv();
		//Tv t = new Tv();
		
		t.channel = 7;

		t.channelDown();
		System.out.printf("현재 채널은 %d입니다.\n", t.channel);
		
		t.channelUp();
		System.out.printf("현재 채널은 %d입니다.\n", t.channel);
		
	}

}
