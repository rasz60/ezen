import java.util.ArrayList;

public class AnnotationEx03 {
	@SuppressWarnings({"deprecation", "unchecked"}) 	// 배열 형태로 여러개 지정할 수 있음
	public static void main(String[] args) {
		NewClass nc = new NewClass();
		
		nc.oldField = 10;
		System.out.println(nc.getOldField());
														// unchecked : Generics 관련 경고를 억제
		ArrayList<NewClass> list = new ArrayList();		// Generics 타입을 지정하지 않아도 실행
		list.add(nc);
	}

}
