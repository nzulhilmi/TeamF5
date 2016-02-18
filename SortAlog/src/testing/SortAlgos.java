package testing;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sorting algorithms to be used for visualisation
 * @author Tanya
 *
 */
public class SortAlgos {
	/**
	 * Bubble sort method
	 * @param input An array that is to be sorted
	 * @return An array list with the sorting process step by step
	 */
	public static ArrayList<int[]> bubbleSort(int[] input){
		 int n = input.length, 
			 i,
			 j,
			 swap;
		 //ArrayList of each step
		 ArrayList<int[]> array = new ArrayList<int[]>();
		 int[] currentStep = new int[n];
		 currentStep = input;
		 array.add(input.clone());
		 
		 for(i=0; i<(n-1); i++){
			 for(j=0; j<(n-i-1); j++){
				 if(currentStep[j]>currentStep[j+1]){
					 swap = currentStep[j];
					 currentStep[j] = currentStep[j+1];
					 currentStep[j+1] = swap;
					 array.add(currentStep.clone());
				 }
			 }
		 }
		 return array;
	}
	/**
	 * Choosing the next pivot and swapping places
	 * @param input
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	static int partition(int input[],ArrayList<int[]> array, int left, int right)
	{
      int i = left, j = right;
      int tmp;
      int pivot = input[(left + right) / 2];
     
      while (i <= j) {
            while (input[i] < pivot)
                  i++;
            while (input[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp = input[i];
                  input[i] = input[j];
                  input[j] = tmp;
                  i++;
                  j--;
                  array.add(input.clone());
            }
      };
     
      return i;
	 }
    /**
     * 
     * @param input
     * @param array
     * @param left
     * @param right
     */
	public static void quickSortHelper(int input[],ArrayList<int[]> array, int left, int right) {
      int index = partition(input, array, left, right);
      if (left < index - 1)
            quickSortHelper(input, array, left, index - 1);
      if (index < right)
            quickSortHelper(input, array, index, right);
	}
	/**
	 * Quick sort method
	 * @param input An array that is to be sorted
	 * @return An array list with the sorting process step by step
	 */
	public static ArrayList<int[]> quickSort(int[] input){
		 int n = input.length;
		//ArrayList of each step
		 ArrayList<int[]> array = new ArrayList<int[]>();
		 int[] currentStep = new int[n];
		 currentStep = input;
		 array.add(input.clone());
		 quickSortHelper(input,array,0,input.length-1);
		 
		
		 return array;
	}

	/**
	 * Prints the passed Array List.
	 * @param sorted the array list
	 */
	public void printArrayList(ArrayList<int[]> sorted){
		for(int i=0; i<sorted.size(); i++){
			System.out.print(sorted.get(i)+", ");
		}
	}

	

	/**
	 * Insertion sort algorithm.
	 * @param input
	 * @return ArrayList<int[]> steps. Returns step
	 * by step array list.
	 */
	public static ArrayList<int[]> insertionSort(int[] input) {
		
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
		for(int i = 0; i < steps.size(); i++){
			System.out.println(Arrays.toString(steps.get(i)));
		}
		
		return steps;
	}
}