package objectclass;

import java.util.Arrays;

public class CloneEx02 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
		int[] arrClone = arr.clone();
		for ( int i = 0; i < arrClone.length; i++ ) {
			arrClone[i] = arr[arr.length - 1] + (i+1);
		}
	
		int[] arrCopy = new int[arr.length * 2];
		System.arraycopy(arr, 0, arrCopy, 0, arr.length);
		System.arraycopy(arrClone, 0, arrCopy, 5, arrClone.length);
		
		System.out.println("arr[] 	   : " + Arrays.toString(arr));
		System.out.println("arrClone[] : " + Arrays.toString(arrClone));
		System.out.println("arrCopy[]  : " + Arrays.toString(arrCopy));
	}

}