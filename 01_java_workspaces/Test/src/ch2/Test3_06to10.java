package ch2;

public class Test3_06to10 {

	public static void main(String[] args) {

		int num = 24;
		int num1 = num;

		while (num % 10 != 0) {
			num++;
		}
		
		System.out.println(num - num1);
		
		int fahrenheit = 100;
		float celcius = 5 / 9f * (fahrenheit - 32f);
		
		System.out.println(fahrenheit);
		System.out.printf("celcius : %f3", celcius);
		System.out.println();
		
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b);
		System.out.println("c="+c);
		
		char ch = 'A';
		ch += 2;
		System.out.println(ch);
		
		float f = 3/2f;
		long l = 3000 * 3000 * 3000l;
		System.out.println(f);
		System.out.println(l);
		
		float f2 = 0.1f;
		double d = 0.1;
		boolean result = (float)d == f2;
		
		System.out.println(result);

		
		char ch1 = 'z';
		boolean b1 = 'a' <= ch1 && ch1 <= 'z' || 'A' <= ch1 && ch1 <= 'Z' || 0 <= ch1 && ch1 <= 9;
		
		System.out.println(b1);
		

		char ch2 = 'A';
		
		char lowerCase = ch < ch + 32 ? (char)(ch + 32): ch;
		
		System.out.println(lowerCase);
	}

}
