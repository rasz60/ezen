
public class CarTest3 {

	public static void main(String[] args) {

		Car c1 = new Car();
		Car c2 = new Car(c1);
		
		System.out.println(
				"c1==========================================\n"+
				"color : " + c1.color + ", gearType : " + c1.gearType + ", door : " + c1.door
				);
		System.out.println();
		System.out.println(
				"c2==========================================\n"+
				"color : " + c2.color + ", gearType : " + c2.gearType + ", door : " + c2.door
				);
		System.out.println();
		
		c1.door = 100;
		c2.color = "Yellow";
		// ���� �ٸ� �ּҿ� �ִ� �ν��Ͻ��̱� ������, �����ߴ��� ���� ���� ������ �ʴ´�.
		System.out.println(
				"c1==========================================\n"+
				"color : " + c1.color + ", gearType : " + c1.gearType + ", door : " + c1.door
				);
		System.out.println();
		System.out.println(
				"c2==========================================\n"+
				"color : " + c2.color + ", gearType : " + c2.gearType + ", door : " + c2.door
				);
	}
}
