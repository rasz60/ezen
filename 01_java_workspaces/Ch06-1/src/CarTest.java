
public class CarTest {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		c1.color = "White";
		c1.gearType = "Auto";
		c1.door = 4;
		
		Car c2 = new Car("Blue", "Auto", 4);

		System.out.println("c1 ======================================\n"
							+ " Color : "+ c1.color + ", GearType : " + c1.gearType + ", Door : " + c1.door);
		System.out.println("c2 ======================================\n "
							+ "Color : " + c2.color + ", GearType : " + c2.gearType + ", Door : " + c2.door);
	}

}
