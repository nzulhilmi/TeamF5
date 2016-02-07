package testing;

import java.util.ArrayList;

/**
 * Sorting algorithms to be used for visualisation
 * @author tanya
 *
 */
public class SortAlgos {
	/**
	 * Implementation of bubble sort
	 * @param input ArrayList to be sorted
	 * @return An ArrayList of ArrayLists which is the steps of the 
	 * algorithm and the last element is the sorted input list
	 */
	public ArrayList<ArrayList<Integer>> Bubble(ArrayList<Integer> input){
		 
		int n=input.size(), i, j, swap;
		// Random randomnumber = new Random();
		// int[] array = new int[n];
		 ArrayList<Integer> array = new ArrayList<Integer>();
		 ArrayList<ArrayList<Integer>> steps = new ArrayList<ArrayList<Integer>>();
		 
		 //Fill with random integers
		 for(i = 0; i < n; i++)
		 {
			// array[i] = input[i]; //randomnumber.nextInt();
		//	 System.out.print(array[i] + " is " + input[i] + " || " );
			 array.add(input.get(i));
			 
		 }
		 //fillStepsArray(array);
		 steps.add(input);
		 for(i=0; i<(n-1); i++){
			 System.out.println("in i ");
			 for(j=0; j<(n-i-1); j++){
				 System.out.println("in j ");
				 if(array.get(j)>array.get(j+1)){
					 System.out.println("in if ");
					 swap = array.get(j);
					 array.set(j, array.get(j+1));
					 array.set((j+1), swap);
					 steps.add(array);
					 //fillStepsArray(array);
				 }
			 }
		 }
		 return steps;
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

	private void print2DArray(int[][] steps, int n) {
		for(int r = 0 ; r < n; r++ ){
			System.out.print("{ " );
			for(int c = 0; c < n; c++){
				System.out.print(steps[r][c] + ", " );
			}
			System.out.print(" }");
		}
		
	}
	*/
/**
 * Print out the content of an Array List
 * @param input The given array list
 */
	public void printArrayList(ArrayList<Integer> input){
		for(int i=0; i<input.size(); i++){
			System.out.print(input.get(i)+", ");
		}
	}
}
	
