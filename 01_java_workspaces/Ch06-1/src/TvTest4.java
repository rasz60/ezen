public class TvTest4 {

	public static void main(String[] args) {
		Tv[] tvArr = new Tv[3];
		System.out.println("-채널변경 전");		
		for ( int i = 0; i < tvArr.length; i++ ) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i + 10;
			System.out.printf("%d번 TV의 채널은 %d입니다.%n", i, tvArr[i].channel);
		}
		System.out.println();
		System.out.println("-채널변경 후");
		for ( int i = 0; i < tvArr.length; i++ ) {
			tvArr[i].channelUp();
			System.out.printf("%d번 TV의 채널은 %d입니다.%n", i, tvArr[i].channel);
		}
		
	}
}