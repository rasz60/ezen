
public class PolyArgumentTest {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv2());
		b.buy(new Computer());
		b.buy(new Audio());

		System.out.println("현재 남은 돈은 " + b.money + "만원 입니다.");
		System.out.println("현재 보너스 포인트는 " + b.bonusPoint + "점 입니다.");
		
		System.out.println();
		
		Buyer2 b2 = new Buyer2();
		
		b2.buy(new Tv2());
		b2.buy(new Computer());
		b2.buy(new Audio());
		b2.summary();
		
		System.out.println("현재 남은 돈은 " + b2.money + "만원 입니다.");
		System.out.println("현재 보너스 포인트는 " + b2.bonusPoint + "점 입니다.");

		System.out.println();
		
		Buyer3 b3 = new Buyer3();
		Tv2 tv = new Tv2();
		Computer com = new Computer();
		Audio audio = new Audio();
				
		b3.buy(tv);
		b3.buy(com);
		b3.buy(audio);
		b3.summary();
		System.out.println();
		b3.refund(com);
		b3.summary();
		
		System.out.println("현재 남은 돈은 " + b2.money + "만원 입니다.");
		System.out.println("현재 보너스 포인트는 " + b2.bonusPoint + "점 입니다.");
		
		
		
	}
	
	

}
