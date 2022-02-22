
public class CaptionTvTest {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();

		//부모 클래스에 멤버를 그대로 사용할 수 있음
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);

		//자식 클래스에 새롭게 생성한 메서드도 사용할 수 있음
		ctv.displayCaption("Hello, world.");
		
		ctv.caption = true;
		ctv.displayCaption("Hello, world!");

	}

}
