
public abstract class Unit {
	int x, y;

	abstract void move (int x, int y);
	
	void stop () {
		System.out.println("����!");
	}
	
}


class Marine extends Unit {

	@Override
	void move(int x, int y) {
		System.out.printf("���� (%d, %d)(��)�� �̵�!%n", x, y);
	}
	
	void stimPack() {
		System.out.println("stimpackckck!!!!");
	}
	
}

class Tank extends Unit {

	boolean sizeMODE;
	
	@Override
	void move(int x, int y) {
		System.out.printf("��ũ (%d, %d)(��)�� �̵�!%n", x, y);		
	}
	
	void changeMode() {
		if (sizeMODE) {
			System.out.println("������ ǯ.");
		}
		else {
			System.out.println("������.");
		}
		sizeMODE = !sizeMODE;
	}
}

class Dropship extends Unit {

	@Override
	void move(int x, int y) {
		System.out.printf("����� (%d, %d)(��)�� �̵�!%n", x, y);
	}
	
	void load() {
		System.out.println("Ÿ.");
	}
	
	void unload() {
		System.out.println("����.");
	}
	
}
