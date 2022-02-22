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
	
	Transportation(int basicFare) {													// 내부적으로 private으로 되어있어서 외부에선 생성자에 접근할 수 없다.
		BASIC_FARE = basicFare;														// 상수를 먼저 선언해 놓고 상수와 value들에 대한 정의형태로 쓸 것 ? 각각의 get, set을 만들어서 외부에서 불러갈 수 있음
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
