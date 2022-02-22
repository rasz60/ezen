public class ArrayEx01 {

	public static void main(String[] args) {

		int[] score = new int[5];
		int k = 1;
		
		score[0] = 50;
		score[1] = 60;
		score[k+1] = 70;
		score[3] = 80;
		score[4] = 90;

		int tmp = score[k+2] + score[4];
		
		for(int i = 0; i < score.length; i++) {
			System.out.printf("score[%d] : %d\n", i, score[i]);
		}
		

		System.out.printf("tmp : %d%n", tmp);
		System.out.printf("score[%d] : %d\n", 7, score[7]);
	
	
		int score0 = 50, score1 = 60, score2 = 70, score3 = 80, score4 = 90;
		
		int tmp1 = score3 + score4;
		
		System.out.println("score0 : " + score0);
		System.out.println("score1 : " + score1);
		System.out.println("score2 : " + score2);
		System.out.println("score3 : " + score3);
		System.out.println("score4 : " + score4);
		
		System.out.println("tmp : " + (score3 + score4));
		
	}
	

}