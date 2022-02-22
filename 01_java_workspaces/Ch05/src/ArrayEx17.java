public class ArrayEx17 {

	public static void main(String[] args) {
		// args�� length�� 3�� �ƴϸ� ��¹�
		if ( args.length != 3 ) {
			System.out.println("usage : java ArrayEx15 NUM1 OP NUM2");
			System.exit(0); //�������� �޼���
		}
			
		// ����� ���� 2���� operator 1�� �����ؼ� args �迭�� �־� ��
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[2]);
		int op = args[1].charAt(0);	
		
		// switch �������� ���� ����
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
			System.out.println("�������� �ʴ� �����Դϴ�.");
		}
		System.out.println("��� : " + result);
	}

}