package repairabletest;

public class Medic extends GroundUnit implements Cureable {

	Medic() {
		super(60);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Medic";
	}
	
	void Cure(Unit u) {
		if (u instanceof Cureable ) {
			int HP = u.hitPoint;
			while ( u.hitPoint != u.MAX_HP ) {
				u.hitPoint++;
			}
			System.out.printf("%s is cured. (HP +%d)%n", u, (u.MAX_HP - HP));
		}
		else {
			System.out.println("CANNOT.");
		}

	}

}
