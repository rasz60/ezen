package objectclass;

public class EqualsEx01 {

	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(20);
		
		if ( v1.equals(v2) ) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		}
		
		v2 = v1;
		
		if ( v1.equals(v2) ) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		}
	}

}

class Value {
	int value;
	
	Value(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if ( !(obj instanceof Value) ) {
			return false;
		} else {		
			Value v = (Value)obj;
			return this.value == v.value;
		}
	}
	
}