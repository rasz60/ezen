import java.util.ArrayList;

class Fruit2 implements Eatable {
	public String toString() {
		return "Fruit";
	}
}

class Apple2 extends Fruit2 {
	public String toString() {
		return "Apple";
	}
}

class Grape2 extends Fruit2 {
	public String toString() {
		return "Grape";
	}
}

class Toy2 {
	public String toString() {
		return "Toy";
	}
}

interface Eatable {}

public class FruitBoxEx02 {

	public static void main(String[] args) {
		FruitBox2<Fruit2> fruitBox = new FruitBox2<>();
		FruitBox2<Apple2> appleBox = new FruitBox2<>();		
		FruitBox2<Grape2> grapeBox = new FruitBox2<>();
//		FruitBox2<Grape2> grapeBox = new FruitBox2<Apple2>();
//		FruitBox2<Toy2> toyBox = new FruitBox2<Toy>();
		
		fruitBox.add(new Fruit2());
		fruitBox.add(new Apple2());
		fruitBox.add(new Grape2());
		appleBox.add(new Apple2());
//		appleBox.add(new Grape2());
		grapeBox.add(new Grape2());
	
		System.out.println("fruitBox - " + fruitBox);
		System.out.println("appleBox - " + appleBox);
		System.out.println("grapeBox - " + grapeBox);
		
	}

}

class FruitBox2<T extends Fruit2 & Eatable> extends Box2<T> {}

class Box2<T> {
	ArrayList<T> list = new ArrayList<>();
	void add(T item) {
		list.add(item);
	}
	
	T get(int i) {
		return list.get(i);
	}
	
	int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
}