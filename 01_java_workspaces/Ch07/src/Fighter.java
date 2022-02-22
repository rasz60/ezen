
public class Fighter extends FUnit implements Fightable {

	@Override
	public void attack(FUnit u) {
		System.out.println("attack!");
	}

	@Override
	public void move(int x, int y) {
		System.out.printf("(%d, %d)로 이동!%n", x, y);
	}

	void instanceOfClass(Object obj) {
		if ( obj instanceof Object ) {
			System.out.println("f - Object 상속 100%");
		}
		else {
			System.out.println("f - Object 상속 0%");
		}
		
		if ( obj instanceof FUnit ) {
			System.out.println("f - FUnit 상속 100%");
		}
		else {
			System.out.println("f - FUnit 상속 0%");
		}
	
	}
		
	void instanceOfInterface(Object obj) {
		if ( obj instanceof Fightable ) {
			System.out.println("f - Fightable 구현 100%");
		}
		else {
			System.out.println("f - Fightable 구현 0%");
		}
		
		if ( obj instanceof Attackable ) {
			System.out.println("f - Attackable 구현 100%");
		}
		else {
			System.out.println("f - Attackable 구현 0%");
		}
		
		if ( obj instanceof Movable ) {
			System.out.println("f - Movable 구현 100%");
		}
		else {
			System.out.println("f - Movable 구현 0%");
		}

	}
	
}
