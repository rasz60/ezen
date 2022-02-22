public class TvTest2 {

	public static void main(String[] args) {
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		
		System.out.printf("t1의 채널은 %02d입니다.\n", t1.channel);
		System.out.printf("t2의 채널은 %02d입니다.\n", t2.channel);
		
		t1.channel = 7;
		System.out.printf("t1의 채널을 %02d로 변경하였습니다.\n", t1.channel);

		System.out.printf("t1의 채널은 %02d입니다.\n", t1.channel);
		System.out.printf("t2의 채널은 %02d입니다.\n", t2.channel);
	}
}