public class TimeTest {

	public static void main(String[] args) {
		Time t = new Time(12, 35, 60);
		System.out.println(t);
//		t.hour = 13;					//Time Ŭ������ hour�� private�̱� ������ �Ұ���
		t.setHour(t.getHour() + 1);
		System.out.println(t);
	}
}
