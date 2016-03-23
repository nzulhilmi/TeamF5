package junitTesting;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import sortAlgoFX.SortAlgos;

/**
 * A JUnit testing of the algorithms
 * 
 * @author Tanya D., Simmi P.
 *
 */
public class SortAlgosTest {

	// no input\
	int[] expected1 = new int[1];
	int[] actual1 = new int[1];
	// {1}
	int[] expected2 = new int[] { 1 };
	int[] actual2 = new int[] { 1 };
	// {1,2}
	int[] expected3 = new int[] { 1, 2 };
	int[] actual3 = new int[] { 1, 2 };
	// {2,1}
	int[] expected4 = new int[] { 1, 2 };
	int[] actual4 = new int[] { 2, 1 };
	// {1,1}
	int[] expected5 = new int[] { 1, 1 };
	int[] actual5 = new int[] { 1, 1 };
	// {1,2,3}
	int[] expected6 = new int[] { 1, 2, 3 };
	int[] actual6 = new int[] { 1, 2, 3 };
	// {1,3,2}
	int[] expected7 = new int[] { 1, 2, 3 };
	int[] actual7 = new int[] { 1, 3, 2 };
	// {2,1,3}
	int[] expected8 = new int[] { 1, 2, 3 };
	int[] actual8 = new int[] { 2, 1, 3 };
	// {3,2,1}
	int[] expected9 = new int[] { 1, 2, 3 };
	int[] actual9 = new int[] { 3, 2, 1 };
	// {1,5,0,7,6,2,8,9,4,3}
	int[] expected10 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int[] actual10 = new int[] { 1, 5, 0, 7, 6, 2, 8, 9, 4, 3 };

	/**
	 * Testing bubble sort with empty array
	 */
	@Test
	public void bubbleSortEmptyLyst_ShouldReturnEmptyList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual1);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected1, result));
	}

	/**
	 * Testing bubble sort with one element in the array
	 */
	@Test
	public void bubbleSortOneElement_ShouldReturnTheElement() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual2);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected2, result));
	}

	/**
	 * Testing bubble sort with two elements in order
	 */
	@Test
	public void bubbleSortTwoElementsInOrder_ShouldReturnSameList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual3);
		// Special case different from the common one
		result = array.get(array.size() - 2);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}

	/**
	 * Testing bubble sort with two elements in reverse order
	 */
	@Test
	public void bubbleSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual4);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}

	/**
	 * Testing bubble sort with two equal elements
	 */
	@Test
	public void bubbleSortTwoEqualElements_ShouldReturnElementsInOrder() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual5);
		// Special case different from the common one
		result = array.get(array.size() - 2);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}

	/**
	 * Testing bubble sort with three elements in order
	 */
	@Test
	public void bubbleSortThreeElementsInOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual6);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected6, result));
	}

	/**
	 * Testing bubble sort with three elements where the last two are swapped
	 */
	@Test
	public void bubbleSortThreeElementsLastTwoSwapped_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual7);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected7, result));
	}

	/**
	 * Testing bubble sort with three elements where the first two are swapped
	 */
	@Test
	public void bubbleSortThreeElementsFirstTwoSwapped_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual8);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected8, result));
	}

	/**
	 * Testing bubble sort with three elements in reverse order
	 */
	@Test
	public void bubbleSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual9);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected9, result));
	}

	/**
	 * Testing bubble sort with N elements in random order
	 */
	@Test
	public void bubbleSortNElementsRandomOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual10);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected10, result));
	}

	/**
	 * Testing quick sort with an empty array
	 */
	@Test
	public void quickSortEmptyLyst_ShouldReturnEmptyList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual1);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected1, result));
	}

	/**
	 * Testing quick sort with one element in the array
	 */
	@Test
	public void quickSortOneElement_ShouldReturnTheElement() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual2);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected2, result));
	}

	/**
	 * Testing quick sort with two elements in the array
	 */
	@Test
	public void quickSortTwoElementsInOrder_ShouldReturnSameList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual3);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}

	/**
	 * Testing quick sort with two elements in reverse order
	 */
	@Test
	public void quickSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual4);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}

	/**
	 * Testing quick sort with two equal elements
	 */
	@Test
	public void quickSortTwoEqualElements_ShouldReturnElementsInOrder() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual5);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}

	/**
	 * Testind quick sort with three elements in order
	 */
	@Test
	public void quickSortThreeElementsInOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual6);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected6, result));
	}

	/**
	 * Testing quick sort with three elements where the last two are swapped
	 */
	@Test
	public void quickSortThreeElementsLastTwoSwapped_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual7);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected7, result));
	}

	/**
	 * Testing quick sort with three elements where the first two are swapped
	 */
	@Test
	public void quickSortThreeElementsFirstTwoSwapped_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual8);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected8, result));
	}

	/**
	 * Testing quick sort with three elements in reverse order
	 */
	@Test
	public void quickSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual9);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected9, result));
	}

	/**
	 * Testing quick sort with N elements in random orded
	 */
	@Test
	public void quickSortNElementsRandomOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual10);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected10, result));
	}

	/**
	 * Testing insertion sort with empty array
	 */
	@Test
	public void insertionSortEmptyLyst_ShouldReturnEmptyList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual1);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected1, result));
	}

	/**
	 * Testing insertion sort with one element in the array
	 */
	@Test
	public void insertionSortOneElement_ShouldReturnTheElement() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual2);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected2, result));
	}

	/**
	 * Testing insertion sort with two elements in order
	 */
	@Test
	public void insertionSortTwoElementsInOrder_ShouldReturnSameList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual3);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}

	/**
	 * Testing insertion sort with two elements in reverse order
	 */
	@Test
	public void insertionSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual4);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}

	/**
	 * Testing insertion sort with two equal elements
	 */
	@Test
	public void insertionSortTwoEqualElements_ShouldReturnElementsInOrder() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual5);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}

	/**
	 * Testing insertion sort with three elements in order
	 */
	@Test
	public void insertionSortThreeElementsInOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual6);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected6, result));
	}

	/**
	 * Testing insertion sort with three elements where the last two are swapped
	 */
	@Test
	public void insertionSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual7);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected7, result));
	}

	/**
	 * Testing insertion sort with three elements where the first two are
	 * swapped
	 */
	@Test
	public void insertionSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual8);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected8, result));
	}

	/**
	 * Testing insertion sort with three elements in reverse order
	 */
	@Test
	public void insertionSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual9);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected9, result));
	}

	/**
	 * Testing insertion sort with N elements in random order
	 */
	@Test
	public void insertionSortNElementsRandomOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual10);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected10, result));
	}

	/**
	 * Testing selection sort with empty array
	 */
	@Test
	public void selectionSortEmptyLyst_ShouldReturnEmptyList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual1);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected1, result));
	}

	/**
	 * Testing selection sort with one element in the array
	 */
	@Test
	public void selectionSortOneElement_ShouldReturnTheElement() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual2);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected2, result));
	}

	/**
	 * Testing selection sort with two elements in order
	 */
	@Test
	public void selectionSortTwoElementsInOrder_ShouldReturnSameList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual3);
		result = array.get(array.size() - 2);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}

	/**
	 * Testing selection sort with two elements in reverse order
	 */
	@Test
	public void selectionSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual4);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}

	/**
	 * Testing selection sort with two equal elements
	 */
	@Test
	public void selectionSortTwoEqualElements_ShouldReturnElementsInOrder() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual5);
		result = array.get(array.size() - 2);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}

	/**
	 * Testing selection sort with three elements in order
	 */
	@Test
	public void selectionSortThreeElementsInOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual6);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected6, result));
	}

	/**
	 * Testing selection sort with three elements where the last two are swapped
	 */
	@Test
	public void selectionSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual7);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected7, result));
	}

	/**
	 * Testing selection sort with three elements where the first two are
	 * swapped
	 */
	@Test
	public void selectionSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual8);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected8, result));
	}

	/**
	 * Testing selection sort with three elements in reverse order
	 */
	@Test
	public void selectionSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual9);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected9, result));
	}

	/**
	 * Testing selection sort with N elements in random order
	 */
	@Test
	public void selectionSortNElementsRandomOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.selectionSort(actual10);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected10, result));
	}
}
