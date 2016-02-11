package testing;

import java.util.ArrayList;

/**
 * Sorting algorithms to be used for visualisation
 * @author tanya
 *
 */
public class SortAlgos {
	/**
	 * Bubble sort method
	 * @param input An array that is to be sorted
	 * @return An array list with the sorting process step by step
	 */
	public ArrayList<int[]> bubbleSort(int[] input){
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
	int partition(int input[],ArrayList<int[]> array, int left, int right)
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
	public void quickSortHelper(int input[],ArrayList<int[]> array, int left, int right) {
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
	public ArrayList<int[]> quickSort(int[] input){
		 int n = input.length;
		//ArrayList of each step
		 ArrayList<int[]> array = new ArrayList<int[]>();
		 int[] currentStep = new int[n];
		 currentStep = input;
		 array.add(input.clone());
		 quickSortHelper(input,array,0,input.length-1);
		 
		
		 return array;
	}

	public void printArrayList(ArrayList<int[]> sorted){
		for(int i=0; i<sorted.size(); i++){
			System.out.print(sorted.get(i)+", ");
		}
	}
}
	
