
public class Fighter extends FUnit implements Fightable {

	@Override
	public void attack(FUnit u) {
		System.out.println("attack!");
	}

	@Override
	public void move(int x, int y) {
		System.out.printf("(%d, %d)�� �̵�!%n", x, y);
	}

	void instanceOfClass(Object obj) {
		if ( obj instanceof Object ) {
			System.out.println("f - Object ��� 100%");
		}
		else {
			System.out.println("f - Object ��� 0%");
		}
		
		if ( obj instanceof FUnit ) {
			System.out.println("f - FUnit ��� 100%");
		}
		else {
			System.out.println("f - FUnit ��� 0%");
		}
	
	}
		
	void instanceOfInterface(Object obj) {
		if ( obj instanceof Fightable ) {
			System.out.println("f - Fightable ���� 100%");
		}
		else {
			System.out.println("f - Fightable ���� 0%");
		}
		
		if ( obj instanceof Attackable ) {
			System.out.println("f - Attackable ���� 100%");
		}
		else {
			System.out.println("f - Attackable ���� 0%");
		}
		
		if ( obj instanceof Movable ) {
			System.out.println("f - Movable ���� 100%");
		}
		else {
			System.out.println("f - Movable ���� 0%");
		}

	}
	
}
