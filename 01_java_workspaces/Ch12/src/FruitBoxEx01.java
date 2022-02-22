import java.util.ArrayList;

class Fruit {
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}

class Toy {
	public String toString() {
		return "Toy";
	}
}

public class FruitBoxEx01 {

	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<>();
		Box<Apple> appleBox = new Box<>();
//		Box<Grape> grapeBox = new Box<Apple>();			// ���׸� Ÿ�� ����ġ�� ����
		Box<Toy> toyBox = new Box<>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Toy());						// �ٸ� Ŭ������ ��ü�� ���� �� ����.
		
		toyBox.add(new Toy());

		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
		
	}
	
}

class Box<T> {
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
