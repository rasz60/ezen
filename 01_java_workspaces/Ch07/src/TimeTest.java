public class TimeTest {

	public static void main(String[] args) {
		Time t = new Time(12, 35, 60);
		System.out.println(t);
//		t.hour = 13;					//Time 클래스의 hour가 private이기 때문에 불가능
		t.setHour(t.getHour() + 1);
		System.out.println(t);
	}
}
