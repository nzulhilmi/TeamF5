package testing;

import java.util.ArrayList;

/**
 * Sorting algorithms to be used for visualisation
 * @author tanya
 *
 */
public class SortAlgos {
	
	public ArrayList<int[]> Bubble(int[] input){
		 int n = input.length, 
			 i,
			 j,
			 swap;
		 // Random randomnumber = new Random();
		 // int[] array = new int[n];
		 ArrayList<int[]> array = new ArrayList<int[]>();
		 int[] currentStep = new int[n];
		 currentStep = input;
		 array.set(0, currentStep);
		 
		 //Fill with random integers
		 /*for(i = 0; i < n; i++)
		 {
			 // array[i] = input[i]; //randomnumber.nextInt();
			 // System.out.print(array[i] + " is " + input[i] + " || " );
			 array.add(input.get(i));
			 
		 }*/
		 //fillStepsArray(array);
		 for(i=0; i<(n-1); i++){
			 //System.out.println("in i ");
			 for(j=0; j<(n-i-1); j++){
				 //System.out.println("in j ");
				 if(currentStep[j]>currentStep[j+1]){
					 //System.out.println("in if ");
					 swap = currentStep[j];
					 currentStep[j] = currentStep[j+1];
					 currentStep[j+1] = swap;
					 array.add(currentStep);
					 //fillStepsArray(array);
				 }
			 }
		 }
		 return array;
	}
private void addStep(ArrayList<Integer> array, ArrayList<Integer> steps) {
		
		
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

	public void printArrayList(ArrayList<int[]> sorted){
		for(int i=0; i<sorted.size(); i++){
			System.out.print(sorted.get(i)+", ");
		}
	}
}
	
