public class TvTest4 {

	public static void main(String[] args) {
		Tv[] tvArr = new Tv[3];
		System.out.println("-ä�κ��� ��");		
		for ( int i = 0; i < tvArr.length; i++ ) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i + 10;
			System.out.printf("%d�� TV�� ä���� %d�Դϴ�.%n", i, tvArr[i].channel);
		}
		System.out.println();
		System.out.println("-ä�κ��� ��");
		for ( int i = 0; i < tvArr.length; i++ ) {
			tvArr[i].channelUp();
			System.out.printf("%d�� TV�� ä���� %d�Դϴ�.%n", i, tvArr[i].channel);
		}
		
	}
}