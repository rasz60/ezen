import java.util.Vector;

public class VectorEx01 {

	public static void main(String[] args) {
		Vector v = new Vector(5);
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		// trimToSize() : size에 맞게 capacity를 trim한 배열을 생성한다.
		v.trimToSize();
		System.out.println("=====After trimToSize()=====");
		print(v);
		
		v.ensureCapacity(6);
		System.out.println("=====After ensureCapacity(6)=====");
		print(v);
		
		// setSize(n) : n개로 사이즈를 조정. 추가되면 비어있는 인덱스엔 null을 추가, 사이즈보다 작게 지정하면 원래 있던 값을 삭제한다.
		// capacity를 초과하면 이전 capacity의 2배 값인 배열을 새로 생성하고, 이전 capacity의 2배 값보다 큰 값을 지정하면 해당 사이즈에 맞는 배열을 생성한다.
		v.setSize(7);
		System.out.println("=====After setSize(7)=====");
		print(v);
		
		v.clear();
		System.out.println("=====After clear()=====");
		print(v);
		
	}
	static void print(Vector v) {
		System.out.println(v);
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
		System.out.println();
	}
	
}
