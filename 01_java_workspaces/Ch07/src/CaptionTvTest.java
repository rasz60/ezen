
public class CaptionTvTest {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();

		//�θ� Ŭ������ ����� �״�� ����� �� ����
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);

		//�ڽ� Ŭ������ ���Ӱ� ������ �޼��嵵 ����� �� ����
		ctv.displayCaption("Hello, world.");
		
		ctv.caption = true;
		ctv.displayCaption("Hello, world!");

	}

}
