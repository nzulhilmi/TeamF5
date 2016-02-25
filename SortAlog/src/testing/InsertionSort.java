package testing;

import java.util.ArrayList;

/**
 * Implementation of Insertion Sort algorithm.
 * @author nik
 *
 */
public class InsertionSort {
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = {7, 4, 40, 50, 2, 13, 27, 1, 38, 6};
		// [7, 4, 40, 50, 2, 13, 27, 1, 38, 6]
		// result = [1, 2, 4, 6, 7, 13, 27, 38, 50, 70]
		algorithm(test);
	}
	
	/**
	 * Insertion sort algorithm.
	 * @param input
	 * @return ArrayList<int[]> steps. Returns step
	 * by step array list.
	 */
	public static ArrayList<int[]> algorithm(int[] input) {
		
		ArrayList<int[]> steps = new ArrayList<int[]>();
		steps.add(input.clone()); //add the input array to steps
		
		//the algorithm for insertion sort
		int n = input.length;
		for(int i = 1; i < n; i++) {
						
			int key = input[i]; //element to be compared
			
			int j = i - 1;
			while( (j > -1) && (input[j] > key)) {
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = key;
			
			//add to steps array list
			steps.add(input.clone());
		}
		
		return steps;
	}
}
