package stringclass;

public class StringEx07 {

	public static void main(String[] args) {
		String fullName = "Hello.java";
		
		// '.'의 String 배열 index를 가져옴
		int index = fullName.indexOf('.');
		
		// fullName에서 0번째부터 '.'전 글자까지 fileName에 대입
		String fileName = fullName.substring(0, index);
		
		// '.' 다음 문자부터 끝까지 문자열 추출한다.
		String ext = fullName.substring( index + 1 );
		
		System.out.println(fullName + "의 확장자 제외 이름 : " + fullName);
		System.out.println(fullName + "의 확장자	 :" + ext);
		
	}

}
