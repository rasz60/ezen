
public class VarArgsEx {

	public static void main(String[] args) {
		String[] strArr = {"100", "200", "300"};
		
//		System.out.println(concatenate("", "100", "200", "300"));
		//?
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[] {"1","2","3"}));
//		System.out.println(concatenate(",", {"1","2","3"}));
		System.out.println("["+concatenate(",", new String[0])+"]");
//		System.out.println("["+concatenate(",")+"]");
		//가변인자를 사용한 메서드는 오버로딩하여 사용할 수 없다.
	}

	static String concatenate(String delim, String... args) {
		String result = args[0];

		if (args.length < 1 ) {
			return result;
		}

		for (int i = 1; i < args.length; i++) {
			result += delim + args[i];
		}
		
		return result;
	}
	
//	static String concatenate(String... args) {
//		return concatenate("", args);
//	}
	
}
