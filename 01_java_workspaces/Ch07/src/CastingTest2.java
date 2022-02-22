
public class CastingTest2 {

	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
		
		car.drive();
		//FireEngine 타입의 인스턴스가 생성되지 않은 상태로 참조변수만 대입해서 사용할 수는 없다.
		fe = (FireEngine)car;
		fe.drive();
		car2 = fe;
		car2.drive();
	}

}
