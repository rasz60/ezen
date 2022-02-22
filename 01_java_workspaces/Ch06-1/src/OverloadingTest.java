
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
void 컨닝 (교재 교재) {
	if ( 교재 == 자바의정석 ) {
		return "정답";
	}
	else if ( 교재 == 내머리 ) {
		return "키보드 박살";
	}
	else {
		return "해탈";
	}
}
*/