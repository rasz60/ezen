enum Transportation {
	BUS(100) { 
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},

	TRAIN(140) { 
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},

	SHIP(100) { 
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},

	AIRPLANE(300) { 
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	};

	protected final int BASIC_FARE;
	
	Transportation(int basicFare) {													// ���������� private���� �Ǿ��־ �ܺο��� �����ڿ� ������ �� ����.
		BASIC_FARE = basicFare;														// ����� ���� ������ ���� ����� value�鿡 ���� �������·� �� �� ? ������ get, set�� ���� �ܺο��� �ҷ��� �� ����
	}
	
	public int getBasicFare() {
		return BASIC_FARE;
	}
	
	abstract int fare(int distance);
	
}
public class EnumEx03 {

	public static void main(String[] args) {
		System.out.println("bus fare = " + Transportation.BUS.fare(100));
		System.out.println("train fare = " + Transportation.TRAIN.fare(100));
		System.out.println("ship fare = " + Transportation.SHIP.fare(100));
		System.out.println("airplane fare = " + Transportation.AIRPLANE.fare(100));
	}

}
