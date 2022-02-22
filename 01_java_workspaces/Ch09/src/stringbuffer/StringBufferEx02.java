package stringbuffer;

public class StringBufferEx02 {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("01");
		StringBuffer sb2 = sb1.append("23");									// sb1에 append한 값을 sb2에만 대입하는 것으로 보이지만, sb1도 append가 수행된 값으로 변경된다.
//		StringBuffer sb2 = new StringBuffer(sb1.append("23"));					// new 해서 생성할 때 변경 값을 매개변수로 넣으면 동기화되지 않는다.
		sb1.append('4').append(56);
		
		StringBuffer sb3 = sb1.append(78);
		sb3.append(9.0);														// 동기화 된 인스턴스 중 어떤 것을 변경하더라도 모두 변경된다.
		
		// sb1값을 대입하여 생성한 인스턴스는 동기화되어 동시에 변경된다.
		System.out.println("sb1 = " + sb1);
		System.out.println("sb2 = " + sb2);
		System.out.println("sb3 = " + sb3);
		System.out.println();

		System.out.println("sb1 = " + sb1.deleteCharAt(10));
		System.out.println("sb1 = " + sb1.delete(3, 6));
		System.out.println("sb1 = " + sb1.insert(3, "abc"));
		System.out.println("sb1 = " + sb1.replace(6, sb1.length(), "END"));
		System.out.println();
		
		System.out.println("sb1 = " + sb1);
		System.out.println("sb2 = " + sb2);
		System.out.println("sb3 = " + sb3);
		System.out.println();		
		
		System.out.println("capacity = " + sb1.capacity());
		System.out.println("length = " + sb1.length());
		
	}

}
