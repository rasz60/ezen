package repairabletest;

public class SCV extends GroundUnit implements Repairable {

	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "SCV";
	}

	void repair(Unit u) {
		if ( u instanceof Repairable ) {
			int HP = u.hitPoint;
			while ( u.hitPoint != u.MAX_HP ) {
				u.hitPoint++;
			}
			System.out.printf("%s is repaired. (HP +%d)%n", u, u.hitPoint - HP);
		}
		else {
			System.out.println("CANNOT.");
		}
	}
	
}
