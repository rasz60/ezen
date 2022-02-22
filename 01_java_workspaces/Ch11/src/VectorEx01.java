import java.util.Vector;

public class VectorEx01 {

	public static void main(String[] args) {
		Vector v = new Vector(5);
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		// trimToSize() : size�� �°� capacity�� trim�� �迭�� �����Ѵ�.
		v.trimToSize();
		System.out.println("=====After trimToSize()=====");
		print(v);
		
		v.ensureCapacity(6);
		System.out.println("=====After ensureCapacity(6)=====");
		print(v);
		
		// setSize(n) : n���� ����� ����. �߰��Ǹ� ����ִ� �ε����� null�� �߰�, ������� �۰� �����ϸ� ���� �ִ� ���� �����Ѵ�.
		// capacity�� �ʰ��ϸ� ���� capacity�� 2�� ���� �迭�� ���� �����ϰ�, ���� capacity�� 2�� ������ ū ���� �����ϸ� �ش� ����� �´� �迭�� �����Ѵ�.
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
