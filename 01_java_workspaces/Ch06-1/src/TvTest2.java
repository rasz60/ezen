public class TvTest2 {

	public static void main(String[] args) {
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		
		System.out.printf("t1�� ä���� %02d�Դϴ�.\n", t1.channel);
		System.out.printf("t2�� ä���� %02d�Դϴ�.\n", t2.channel);
		
		t1.channel = 7;
		System.out.printf("t1�� ä���� %02d�� �����Ͽ����ϴ�.\n", t1.channel);

		System.out.printf("t1�� ä���� %02d�Դϴ�.\n", t1.channel);
		System.out.printf("t2�� ä���� %02d�Դϴ�.\n", t2.channel);
	}
}