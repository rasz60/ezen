package repairabletest;

public class Marine extends GroundUnit implements Cureable {

	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Marine";
	}
	
}
