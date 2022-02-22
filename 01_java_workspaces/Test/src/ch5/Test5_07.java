package ch5;

public class Test5_07 {

	public static void main(String[] args) {

		if(args.length!=1) {
			System.out.println("USAGE: java Exercise5_7 3120");
			System.exit(0);
			}

		// . . ���ڿ��� ���ڷ� ��ȯ�Ѵ� �Է��� ���� ���ڰ� �ƴ� ��� ���ܰ� �߻��Ѵ�
		int money = Integer.parseInt(args[0]);
		System.out.println("money="+money);
		int[] coinUnit = {500, 100, 50, 10 }; // ������ ����
		int[] coin = {5, 5, 5, 5}; // ������ ������ ����
		for(int i=0;i<coinUnit.length;i++) {
			int coinNum = 0;
			/*
			(1) . �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�
			1. (money) (coinNum) . �ݾ� �� ���������� ������ �ʿ��� ������ ���� �� ���Ѵ�
			coinNum = money / coinUnit[i];
			
			2. coin coinNum . �迭 ���� ��ŭ�� ������ ����
			( coin .) ���� ����� ������ ���ٸ� �迭 �� �ִ� ��ŭ�� ����
			if ( coin[i] >= coinNum) {
				 coin[i] -= coinNum;
				}
			else {
				coinNum = coin[i];
				coin[i] = 0;
			}
			
			3. (coinNum) . �ݾ׿��� ������ ���� �� ���������� ���� ���� ����
			money -= coinNum*coinUnit[i];
			
			 */
			System.out.println(coinUnit[i]+" : "+coinNum);
			}
		if(money > 0) {
			System.out.println(" ."); //�Ž������� �����մϴ�
			System.exit(0); // . ���α׷��� �����Ѵ�
			}
			System.out.println("= ="); //���� ������ ����
			for(int i=0;i<coinUnit.length;i++) {
			System.out.println(coinUnit[i]+" :"+coin[i]);
			}
	}

}
