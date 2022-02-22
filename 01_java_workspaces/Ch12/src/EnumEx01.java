// 상수의 집합을 클래스처럼 선언한다. = 열거형 상수 집합
enum Direction { EAST, SOUTH, WEST, NORTH }

public class EnumEx01 {

	public static void main(String[] args) {
		Direction d1 = Direction.EAST;												// 인스턴스를 만들거나 상수 값을 가져올 때도 클래스처럼 쓸 수 있다.
		Direction d2 = Direction.valueOf("WEST");									// 열거형.valueOf(value) : 열거형에 있는 상수 값(value)을 가져온다.
		Direction d3 = Enum.valueOf(Direction.class, "EAST");						// Enum.valuOf(class, value) : class 이름으로 선언된 enum에서 value를 가져온다.

		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		System.out.println("d1 == d2 ? " + (d1==d2));
		System.out.println("d1 == d3 ? " + (d1==d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//		System.out.println("d2 > d3 ? " + (d1 > d3));								// 비교연산자를 쓸 수 없고, compareTo나 equals를 이용한다.
		System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
		System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d2));
		
		switch(d1) {
			case EAST : 															// 조건문을 작성할 때, 열거형 이름없이 상수 값을 바로 넣어준다.
				System.out.println("The direction is EAST.");
				break;
				
			case SOUTH : 
				System.out.println("The direction is SOUTH.");
				break;
				
			case WEST : 
				System.out.println("The direction is WEST.");
				break;
				
			case NORTH : 
				System.out.println("The direction is NORTH.");
				break;
				
			default : 
				System.out.println("Invalid direction.");
				break;
		}
		
		Direction[] dArr = Direction.values();										// 열거형에 선언된 상수를 배열로 저장한다.
		
		for ( Direction d : dArr ) {
			System.out.printf("%s = %d%n", d.name(), d.ordinal());					// name() : 상수의 이름 , ordinal() : 배열로 저장된 상수의 인덱스
		}
	}

}
