package defaultmethodtest;

public class Car implements Vehicle {

	private String brand;

	Car(String brand) {//constructer
		this.brand = brand;
	}
	
	@Override
	public String getBrand() {//@override
		return brand;
	}

	@Override
	public String speedUp() {//@override
		return "The car is speeding up.";
	}

	@Override
	public String slowDown() {//@override
		return "The car is slowing down.";
	}
	
}
