package junitTesting;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import swing.SortAlgos;

/**
 * A JUnit testing of the algorithms
 * 
 * @author Tanya D., Simmi P.
 *
 */
public class SortAlgosTest {
	SortAlgos SortAlgos = new SortAlgos();

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
	public void BubbleSortEmptyLyst_ShouldReturnEmptyList() {
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
	public void BubbleSortOneElement_ShouldReturnTheElement() {
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
	public void BubbleSortTwoElementsInOrder_ShouldReturnSameList() {
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
	public void BubbleSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual4);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}

	/**
	 * Testing bubble sort with two equal elements
	 */
	@Test
	public void BubbleSortTwoEqualElements_ShouldReturnElementsInOrder() {
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
	public void BubbleSortThreeElementsInOrder_ShouldReturnSortedList() {
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
	public void BubbleSortThreeElementsLastTwoSwapped_ShouldReturnSortedList() {
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
	public void BubbleSortThreeElementsFirstTwoSwapped_ShouldReturnSortedList() {
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
	public void BubbleSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
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
	public void BubbleSortNElementsRandomOrder_ShouldReturnSortedList() {
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
	public void InsertionSortEmptyLyst_ShouldReturnEmptyList() {
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
	public void InsertionSortOneElement_ShouldReturnTheElement() {
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
	public void InsertionSortTwoElementsInOrder_ShouldReturnSameList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual3);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}

	/**
	 * Testing insertion sort with two elements in reverse order
	 */
	@Test
	public void InsertionSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual4);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}

	/**
	 * Testing insertion sort with two equal elements
	 */
	@Test
	public void InsertionSortTwoEqualElements_ShouldReturnElementsInOrder() {
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual5);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}

	/**
	 * Testing insertion sort with three elements in order
	 */
	@Test
	public void InsertionSortThreeElementsInOrder_ShouldReturnSortedList() {
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
	public void InsertionSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
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
	 * Testing insertion sort with three elements where the first two are swapped
	 */
	@Test
	public void InsertionSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
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
	public void InsertionSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
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
	public void InsertionSortNElementsRandomOrder_ShouldReturnSortedList() {
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
	public void SelectionSortEmptyLyst_ShouldReturnEmptyList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual1);
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
	public void SelectionSortOneElement_ShouldReturnTheElement() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual2);
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
	public void SelectionSortTwoElementsInOrder_ShouldReturnSameList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual3);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}

	/**
	 * Testing selection sort with two elements in reverse order
	 */
	@Test
	public void SelectionSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual4);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}

	/**
	 * Testing selection sort with two equal elements
	 */
	@Test
	public void SelectionSortTwoEqualElements_ShouldReturnElementsInOrder() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual5);
		result = array.get(array.size() - 1);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}

	/**
	 * Testing selection sort with three elements in order 
	 */
	@Test
	public void SelectionSortThreeElementsInOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual6);
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
	public void SelectionSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual7);
		int j = array.size() - 1;

		while (array.get(j).length == 2) {
			j--;
		}

		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected7, result));
	}

	/**
	 * Testing selection sort with three elements where the first two are swapped
	 */
	@Test
	public void SelectionSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual8);
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
	public void SelectionSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual9);
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
	public void SelectionSortNElementsRandomOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result = new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual10);
		int j = array.size() - 1;
		while (array.get(j).length == 2) {
			j--;
		}
		result = array.get(j);
		Assert.assertTrue(Arrays.equals(expected10, result));
	}
}
