import java.util.Arrays;

public class ArrayEx09 {

	public static void main(String[] args) {
		//������ ������ ������ �迭
		int[] code = {-4, -1, 3, 6, 11};
		int[] arr = new int[10];
		
		for ( int i = 0; i < arr.length; i++ ) {
			int tmp = (int)(Math.random() * code.length);
			arr[i] = code[tmp];
			
			System.out.println("temp = " + tmp);
		}
		
		System.out.println(Arrays.toString(arr));
		
		
	}

}
