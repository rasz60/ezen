
public class CastingTest {

	public static void main(String[] args) {
		Car car = new Car();
		FireEngine fe = null;
		FireEngine fe2 = null;
		
//		fe.water();
//		car = fe;
//		car.water();
		fe2 = (FireEngine)car;
		fe2.water();
	}

}
