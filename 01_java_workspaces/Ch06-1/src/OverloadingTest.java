
public class OverloadingTest {

	public static void main(String[] args) {
		MyMath3 mmm = new MyMath3();

		int[] arr = {30, 40};
		
		System.out.println("result : " + mmm.add(arr) + "\n");
		System.out.println("result : " + mmm.add(30, 40) + "\n");
		System.out.println("result : " + mmm.add(30, 40L) + "\n");
		System.out.println("result : " + mmm.add(30L, 40) + "\n");
		System.out.println("result : " + mmm.add(30L, 40L) + "\n");
	}
}
/*
void ���� (���� ����) {
	if ( ���� == �ڹ������� ) {
		return "����";
	}
	else if ( ���� == ���Ӹ� ) {
		return "Ű���� �ڻ�";
	}
	else {
		return "��Ż";
	}
}
*/