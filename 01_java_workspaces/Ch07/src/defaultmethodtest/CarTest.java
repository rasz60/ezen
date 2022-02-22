package defaultmethodtest;

public class CarTest {

	public static void main(String[] args) {
		Vehicle SM6 = new Car("RENAULT SAMSUNG");
		System.out.println(SM6.getBrand());
		System.out.println(SM6.speedUp());
		System.out.println(SM6.slowDown());
		System.out.println(SM6.turnAlarmOn());
		System.out.println(SM6.turnAlarmOff());
		
		System.out.println();
		
		Car NewBeatles = new Car("VOLKSWAGEN");
		System.out.println(NewBeatles.getBrand());
		System.out.println(NewBeatles.speedUp());
		System.out.println(NewBeatles.slowDown());
		System.out.println(NewBeatles.turnAlarmOn());
		System.out.println(NewBeatles.turnAlarmOff());
				
	}
}
