package javaFx;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sorting algorithms to be used for visualisation
 *
 * @author Tanya D., Simmi P., Nik Z., Kiril N.
 *
 */
public class SortAlgos {
	public String sortType;
	public int[] toBesorted;
	public ArrayList<int[]> sorted;

	/**
	 * Instantiates a new sortAlgos which holds and uses the sorting algorythms.
	 *
	 * @param sortType the sort type
	 * @param toBesorted the to the array we want to sort
	 */
	public SortAlgos(String sortType, int[] toBesorted){
			this.sortType = sortType;
			this.toBesorted = toBesorted;

			switch (sortType) {

			case "bubble":
				this.sorted = SortAlgos.bubbleSort(toBesorted);
				break;
			case "quick" :
				this.sorted = SortAlgos.quickSort(toBesorted);
				break;
			case "insertion" :
				this.sorted = SortAlgos.insertionSort(toBesorted);
				break;
			default:
				break;
			}
		}

	public String getSortTypeString() {
		return sortType;
	}

	public ArrayList<int[]> getSortedList() {
		return sorted;
	}

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

		//  An array of the index of the two elements that are being compared
		int[] indexComparison = new int[2];
		currentStep = input;
		steps.add(input.clone());

		// The sorting loop
		for (i = 0; i < (n - 1); i++) {
			for (j = 0; j < (n - i - 1); j++) {
				indexComparison[0] = j;
				indexComparison[1] = j + 1;
				steps.add(indexComparison.clone());
				// The comparison
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

		int temp;
		for (int i = 0; i < length - 1; i++) {

			int min = input[i];
			int count = i;
			for (int j = i + 1; j < length; j++) {

				indexComparison[0] = i;
				indexComparison[1] = j;

				steps.add(indexComparison.clone());
				if (input[j] < min) {
					min = input[j];

					count++;
				}

			}
			temp = input[i];
			input[i] = min;
			input[count] = temp;
			steps.add(input.clone());

		}
		return steps;
	}
}