import java.util.ArrayList;

public class AnnotationEx03 {
	@SuppressWarnings({"deprecation", "unchecked"}) 	// �迭 ���·� ������ ������ �� ����
	public static void main(String[] args) {
		NewClass nc = new NewClass();
		
		nc.oldField = 10;
		System.out.println(nc.getOldField());
														// unchecked : Generics ���� ��� ����
		ArrayList<NewClass> list = new ArrayList();		// Generics Ÿ���� �������� �ʾƵ� ����
		list.add(nc);
	}

}
