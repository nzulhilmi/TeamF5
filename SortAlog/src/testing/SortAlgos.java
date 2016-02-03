package testing;
import java.util.ArrayList;
import java.util.Random;


public class SortAlgos {
	
	public int[] Bubble(int[] input){
		 int n=input.length, i, j, swap;
		// Random randomnumber = new Random();
		 int[] array = new int[n];
		 
		 //Fill with random integers
		 for(i = 0; i < n; i++)
		 {
			 array[i] = input[i]; //randomnumber.nextInt();
		//	 System.out.print(array[i] + " is " + input[i] + " || " );
		 }
		 fillStepsArray(array);
		 for(i=0; i<(n-1); i++){
			 System.out.println("in i ");
			 for(j=0; j<(n-i-1); j++){
				 System.out.println("in j ");
				 if(array[j]>array[j+1]){
					 System.out.println("in if ");
					 swap = array[j];
					 array[j] = array[j+1];
					 array[j+1] = swap;
					 fillStepsArray(array);
				 }
			 }
		 }
		 return array;
	}
	
	private void fillStepsArray(int[] array) {
		int n = array.length;
		int steps[][] = new int[n][n];
		for(int r = 0 ; r < n; r++ ){
			for(int c = 0; c < n; c++){
				steps[r]= array; 
			}
		}
		print2DArray(steps, n);
		
	}

	private void print2DArray(int[][] steps, int n) {
		for(int r = 0 ; r < n; r++ ){
			System.out.print("{ " );
			for(int c = 0; c < n; c++){
				System.out.print(steps[r][c] + ", " );
			}
			System.out.print(" }");
		}
		
	}

	public void printArray(int[] input){
		for(int i=0; i<input.length; i++){
			System.out.print(input[i]+", ");
		}
	}
}
	
