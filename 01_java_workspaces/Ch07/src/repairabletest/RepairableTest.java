package repairabletest;

public class RepairableTest {

	public static void main(String[] args) {

		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		Marine marine = new Marine();
		SCV scv = new SCV();
		Medic medic = new Medic();
		Firebat firebat = new Firebat();
		
		firebat.hitPoint = 20;
		marine.hitPoint = 33;
		medic.hitPoint = 24;
		
		tank.hitPoint = 40;
		dropship.hitPoint = 55;
		scv.hitPoint = 24;
		
		
		scv.repair(medic);
		scv.repair(marine);
		scv.repair(firebat);
		scv.repair(tank);
		scv.repair(dropship);
		scv.repair(scv);
		
		System.out.println();
		
		medic.Cure(medic);
		medic.Cure(marine);
		medic.Cure(firebat);
		medic.Cure(tank);
		medic.Cure(dropship);
		medic.Cure(scv);

	}

}
