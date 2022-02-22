
public class FinallyTest3 {

	public static void main(String[] args) {
		method1();
		System.out.println("method1()의 수행을 마치고 main메서드로 돌아왔습니다.");
	}

	static void method1() {
		try {
			System.out.println("method1()이 호출되었습니다.");
			return;															//finally 블럭 전에 return문을 만나도 finally는 무조건 수행한다.
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			System.out.println("method1()의 finally블럭이 실행되었습니다.");
		}
	}
	
}
