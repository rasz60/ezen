package repairabletest;

public class Firebat extends GroundUnit implements Cureable {

	Firebat() {
		super(50);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Firebat";
	}

}
