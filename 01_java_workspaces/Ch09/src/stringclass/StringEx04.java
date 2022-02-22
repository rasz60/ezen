package stringclass;

import java.io.UnsupportedEncodingException;
import java.util.StringJoiner;

public class StringEx04 {

	public static void main(String[] args) throws Exception {
		String str = "가";
		
		byte[] bArr = str.getBytes("UTF-8");
		byte[] bArr2 = str.getBytes("CP949");
		
//		byte를 binary로 출력해보기
//		for (byte i : bArr) {
//			System.out.println("UTF-8(byte) : " + i);
//			System.out.println("UTF-8(binary) : " + Integer.toBinaryString(i));
//		}
		System.out.println("UTF-8 : " + joinByteArr(bArr));
		System.out.println("CP949 : " + joinByteArr(bArr2));
		
		System.out.println("UTF-8 : " + new String(bArr, "UTF-8"));
		System.out.println("CP949 : " + new String(bArr2, "CP949"));
	}
	
	static String joinByteArr(byte[] bArr) {
		StringJoiner sj =new StringJoiner(" : ", "[", "]");
		
		for(byte b : bArr) {
			sj.add(String.format("%02X", b));
		}
		return sj.toString();
	}
	
}
