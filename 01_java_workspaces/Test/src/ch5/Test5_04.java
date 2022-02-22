package ch5;

public class Test5_04 {

	public static void main(String[] args) {
		int[][] arr = {
				{ 5, 5, 5, 5, 5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
				};
		
		int total = 0;
		float average = 0;
		
		int i = 0;
		int j = 0;
		for ( i = 0; i < arr.length; i++ ) {
			for ( j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
		}
		
		average = (float)total / (i*j);
		
		
		System.out.println("total="+total);
		System.out.println("average="+average);
	}

}
