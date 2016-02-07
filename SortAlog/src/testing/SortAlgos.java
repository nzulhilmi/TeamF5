package testing;

import java.util.ArrayList;

/**
 * Sorting algorithms to be used for visualisation
 * @author tanya
 *
 */
public class SortAlgos {
	
	public ArrayList<Integer> Bubble(ArrayList<Integer> input){
		 int n=input.size(), i, j, swap;
		// Random randomnumber = new Random();
		// int[] array = new int[n];
		 ArrayList<Integer> array = new ArrayList<Integer>();
		 ArrayList<Integer> steps = new ArrayList<Integer>();
		 
		 //Fill with random integers
		 for(i = 0; i < n; i++)
		 {
			// array[i] = input[i]; //randomnumber.nextInt();
		//	 System.out.print(array[i] + " is " + input[i] + " || " );
			 array.add(input.get(i));
			 
		 }
		 //fillStepsArray(array);
		 for(i=0; i<(n-1); i++){
			 System.out.println("in i ");
			 for(j=0; j<(n-i-1); j++){
				 System.out.println("in j ");
				 if(array.get(j)>array.get(j+1)){
					 System.out.println("in if ");
					 swap = array.get(j);
					 array.set(j, array.get(j+1));
					 array.set((j+1), swap);
					 addStep(array, steps);
					 //fillStepsArray(array);
				 }
			 }
		 }
		 return array;
	}
private void addStep(ArrayList<Integer> array, ArrayList<Integer> steps) {
		// TODO Auto-generated method stub
		
	}
/*	
	private void fillStepsArray(ArrayList<Integer> array) {
		int n = array.size();
		int steps[][] = new int[n][n];
		for(int r = 0 ; r < n; r++ ){
			for(int c = 0; c < n; c++){
				steps[r]= array; 
			}
		}
		print2DArray(steps, n);
		
	}
*/
	private void print2DArray(int[][] steps, int n) {
		for(int r = 0 ; r < n; r++ ){
			System.out.print("{ " );
			for(int c = 0; c < n; c++){
				System.out.print(steps[r][c] + ", " );
			}
			System.out.print(" }");
		}
		
	}

	public void printArrayList(ArrayList<Integer> input){
		for(int i=0; i<input.size(); i++){
			System.out.print(input.get(i)+", ");
		}
	}
}
	
