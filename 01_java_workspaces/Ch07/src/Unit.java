
public abstract class Unit {
	int x, y;

	abstract void move (int x, int y);
	
	void stop () {
		System.out.println("정지!");
	}
	
}


class Marine extends Unit {

	@Override
	void move(int x, int y) {
		System.out.printf("마린 (%d, %d)(으)로 이동!%n", x, y);
	}
	
	void stimPack() {
		System.out.println("stimpackckck!!!!");
	}
	
}

class Tank extends Unit {

	boolean sizeMODE;
	
	@Override
	void move(int x, int y) {
		System.out.printf("탱크 (%d, %d)(으)로 이동!%n", x, y);		
	}
	
	void changeMode() {
		if (sizeMODE) {
			System.out.println("시즈모드 풂.");
		}
		else {
			System.out.println("시즈모드.");
		}
		sizeMODE = !sizeMODE;
	}
}

class Dropship extends Unit {

	@Override
	void move(int x, int y) {
		System.out.printf("드랍쉽 (%d, %d)(으)로 이동!%n", x, y);
	}
	
	void load() {
		System.out.println("타.");
	}
	
	void unload() {
		System.out.println("내려.");
	}
	
}
