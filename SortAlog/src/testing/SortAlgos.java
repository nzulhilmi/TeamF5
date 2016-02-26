package testing;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sorting algorithms to be used for visualisation
 * 
 * @author Tanya D., Simmi P., Nik Z., Kiril N.
 *
 */
public class SortAlgos {
	/**
	 * Bubble sort method
	 * 
	 * @param input
	 *            An array that is to be sorted
	 * @return An array list with the sorting process step by step
	 */
	public static ArrayList<int[]> bubbleSort(int[] input) {
		int n = input.length, i, j, swap;
		// ArrayList of each step
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] currentStep = new int[n];
		/*
		 * An array of the index of the two elements that are being compared
		 */
		int[] indexComparison = new int[2];
		currentStep = input;
		steps.add(input.clone());

		for (i = 0; i < (n - 1); i++) {
			for (j = 0; j < (n - i - 1); j++) {
				indexComparison[0] = j;
				indexComparison[1] = j + 1;
				steps.add(indexComparison.clone());
				if (currentStep[j] > currentStep[j + 1]) {
					swap = currentStep[j];
					currentStep[j] = currentStep[j + 1];
					currentStep[j + 1] = swap;
					steps.add(currentStep.clone());
				}
			}
		}
		return steps;
	}

	/**
	 * Choosing the next pivot and swapping places
	 * 
	 * @param input
	 *            The array to be sorted.
	 * @param array
	 *            The current steps.
	 * @param left
	 *            Left marker.
	 * @param right
	 *            Right marker.
	 * @return
	 */
	static int partition(int input[], ArrayList<int[]> array, int left, int right) {
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
		}
		;

		return i;
	}

	/**
	 * Putting the number on its right position.
	 * 
	 * @param input
	 *            The array to be sorted.
	 * @param array
	 *            The current steps.
	 * @param left
	 *            Left marker.
	 * @param right
	 *            Right marker.
	 */
	public static void quickSortHelper(int input[], ArrayList<int[]> array, int left, int right) {
		int index = partition(input, array, left, right);
		if (left < index - 1)
			quickSortHelper(input, array, left, index - 1);
		if (index < right)
			quickSortHelper(input, array, index, right);
	}

	/**
	 * Quick sort method
	 * 
	 * @param input
	 *            An array that is to be sorted
	 * @return An array list of comparisons and the order of the list at each
	 *         step.
	 */
	public static ArrayList<int[]> quickSort(int[] input) {
		int n = input.length;
		// ArrayList of each step
		ArrayList<int[]> array = new ArrayList<int[]>();
		int[] currentStep = new int[n];
		currentStep = input;
		array.add(input.clone());
		quickSortHelper(input, array, 0, input.length - 1);

		return array;
	}

	/**
	 * Prints the passed Array List.
	 * 
	 * @param sorted
	 *            the array list
	 */
	public void printArrayList(ArrayList<int[]> sorted) {
		for (int i = 0; i < sorted.size(); i++) {
			System.out.print(sorted.get(i) + ", ");
		}
	}

	/**
	 * Insertion sort algorithm.
	 * 
	 * @param input
	 * @return steps Array list of comparisons and the order of the list at each
	 *         step.
	 */
	public static ArrayList<int[]> insertionSort(int[] input) {

		ArrayList<int[]> steps = new ArrayList<int[]>();
		/*
		 * An array of the index of the two elements that are being compared
		 */
		int[] indexComparison = new int[2];

		steps.add(input.clone()); // add the input array to steps

		// the algorithm for insertion sort
		int n = input.length;
		for (int i = 1; i < n; i++) {

			int key = input[i]; // element to be compared

			int j = i - 1;

			indexComparison[0] = j;
			indexComparison[1] = i;
			steps.add(indexComparison.clone());

			while ((j > -1) && (input[j] > key)) {
				indexComparison[0] = j;
				indexComparison[1] = i;
				steps.add(indexComparison.clone());
				input[j + 1] = input[j];
				j--;
			}
			input[j + 1] = key;

			// add to steps array list
			steps.add(input.clone());
		}
		/*
		 * for(int i = 0; i < steps.size(); i++){
		 * System.out.println(Arrays.toString(steps.get(i))); }
		 */
		return steps;
	}

	/**
	 * Selection sort algorithm
	 * 
	 * @param steps
	 *            Array to keep track of the comparisons and the order of the
	 *            list at each step.
	 * @param input
	 * @return An arraylist of comparisons and the order of the list at each
	 *         step.
	 */
	public static ArrayList<int[]> SelectionSort(ArrayList<int[]> steps, int[] input) {
		// add the input as the first step
		steps.add(input.clone());
		/*
		 * An array of the index of the two elements that are being compared
		 */
		int[] indexComparison = new int[2];

		int length = input.length;

		for (int i = 0; i < length - 1; i++) {

			for (int j = i + 1; j < length; j++) {
				indexComparison[0] = i;
				indexComparison[1] = j;
				steps.add(indexComparison.clone());
				if (input[j] < input[i]) {

					int lower = input[j];
					int higher = input[i];

					input[i] = lower;
					input[j] = higher;

					// add current step to array list of steps
					steps.add(input.clone());
					SelectionSort(steps, input);
				}
			}
		}
		return steps;
	}
}