
public class Shape {

	String color;
	
	Shape() {
		this("Green");
	}
	
	Shape(String color) {
		this.color = color;
	}
	
	void draw() {
		System.out.printf("[color=%s]%n", color);
	}
	
}
