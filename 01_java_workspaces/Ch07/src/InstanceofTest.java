
public class InstanceofTest {
	
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if ( fe instanceof FireEngine ) {
			System.out.println("This is a FireEngine instance.");
		}
		if ( fe instanceof Car ) {
			System.out.println("This is a Car instance.");
		}
		if ( fe instanceof Object ) {
			System.out.println("This is a Object instance.");
		}
		System.out.println(fe.getClass().getName());

		
		Car car = new Car();
		
		if ( car instanceof FireEngine ) {
			System.out.println("This is a FireEngine instance.");
		}
		if ( car instanceof Car ) {
			System.out.println("This is a Car instance.");
		}
		if ( car instanceof Object ) {
			System.out.println("This is a Object instance.");
		}
		System.out.println(car.getClass().getName());

	}
}
