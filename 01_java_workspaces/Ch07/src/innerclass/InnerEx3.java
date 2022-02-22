package innerclass;

public class InnerEx3 {
	private int outerIv = 0;
	static	int outerCv = 0;
	
	class InstanceInner {
		int iiv = outerIv;
		int iiv2 = outerCv;
	}
	
	static class StaticInner {
//		int siv = outerIv;			//static 내부 클래스에서는 외부클래스의 인스턴스변수 접근 불가
		static int scv = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0;

		class LocalInner {
			int liv = outerIv;
			final int liv2 = outerCv;
			// 지역클래스에서는 상수로 선언된 지역변수에만 접근 가능하다.
			// JDK1.8부터는 상수로 선언하지 않은 지역 변수도 final로 자동 변환되므로
			// 해당 지역변수의 값이 변하는 문장이 메서드 안에 들어가면 에러가 발생한다.
			int liv3 = lv;		
			int liv4 = LV;
		}
	}
	
	
}
