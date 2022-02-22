// ����� ������ Ŭ����ó�� �����Ѵ�. = ������ ��� ����
enum Direction { EAST, SOUTH, WEST, NORTH }

public class EnumEx01 {

	public static void main(String[] args) {
		Direction d1 = Direction.EAST;												// �ν��Ͻ��� ����ų� ��� ���� ������ ���� Ŭ����ó�� �� �� �ִ�.
		Direction d2 = Direction.valueOf("WEST");									// ������.valueOf(value) : �������� �ִ� ��� ��(value)�� �����´�.
		Direction d3 = Enum.valueOf(Direction.class, "EAST");						// Enum.valuOf(class, value) : class �̸����� ����� enum���� value�� �����´�.

		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		System.out.println("d1 == d2 ? " + (d1==d2));
		System.out.println("d1 == d3 ? " + (d1==d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//		System.out.println("d2 > d3 ? " + (d1 > d3));								// �񱳿����ڸ� �� �� ����, compareTo�� equals�� �̿��Ѵ�.
		System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
		System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d2));
		
		switch(d1) {
			case EAST : 															// ���ǹ��� �ۼ��� ��, ������ �̸����� ��� ���� �ٷ� �־��ش�.
				System.out.println("The direction is EAST.");
				break;
				
			case SOUTH : 
				System.out.println("The direction is SOUTH.");
				break;
				
			case WEST : 
				System.out.println("The direction is WEST.");
				break;
				
			case NORTH : 
				System.out.println("The direction is NORTH.");
				break;
				
			default : 
				System.out.println("Invalid direction.");
				break;
		}
		
		Direction[] dArr = Direction.values();										// �������� ����� ����� �迭�� �����Ѵ�.
		
		for ( Direction d : dArr ) {
			System.out.printf("%s = %d%n", d.name(), d.ordinal());					// name() : ����� �̸� , ordinal() : �迭�� ����� ����� �ε���
		}
	}

}
