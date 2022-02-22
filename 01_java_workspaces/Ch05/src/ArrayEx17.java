public class ArrayEx17 {

	public static void main(String[] args) {
		// args의 length가 3이 아니면 출력문
		if ( args.length != 3 ) {
			System.out.println("usage : java ArrayEx15 NUM1 OP NUM2");
			System.exit(0); //강제종료 메서드
		}
			
		// 계산할 숫자 2개와 operator 1개 생성해서 args 배열에 넣어 줌
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[2]);
		int op = args[1].charAt(0);	
		
		// switch 구문으로 계산식 생성
		int result = 0;
		
		switch (op) {
		case '+' :
			result = num1 + num2;
			break;
						
		case '-' :
			result = num1 - num2;
			break;
		
		case '/' :
			result = num1 / num2;
			break;
						
		case 'x' :
			result = num1 * num2;
			break;
		
		case '%' :
			result = num1 % num2;
			break;
			
		default :
			System.out.println("지원되지 않는 연산입니다.");
		}
		System.out.println("결과 : " + result);
	}

}