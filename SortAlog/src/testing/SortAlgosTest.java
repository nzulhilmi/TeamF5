package testing;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class SortAlgosTest {
	SortAlgos SortAlgos = new SortAlgos();
	
	// no input\
	int[] expected1 = new int[1];
	int[] actual1 = new int[1];
	// {1}
	int[] expected2 = new int[] {1};
	int[] actual2 = new int[] {1};
	// {1,2}
	int[] expected3 = new int[] {1,2};
	int[] actual3 = new int[] {1,2};
	// {2,1}
	int[] expected4 = new int[] {1,2};
	int[] actual4 = new int[] {2,1};
	// {1,1}
	int[] expected5 = new int[] {1,1};
	int[] actual5 = new int[] {1,1};
	// {1,2,3}
	int[] expected6 = new int[] {1,2,3};
	int[] actual6 = new int[] {1,2,3};
	// {1,3,2}
	int[] expected7 = new int[] {1,2,3};
	int[] actual7 = new int[] {1,3,2};
	// {2,1,3}
	int[] expected8 = new int[] {1,2,3};
	int[] actual8 = new int[] {2,1,3};
	// {3,2,1}
	int[] expected9 = new int[] {1,2,3};
	int[] actual9 = new int[] {3,2,1};
	// {1,5,0,7,6,2,8,9,4,3}
	int[] expected10 = new int[] {0,1,2,3,4,5,6,7,8,9};
	int[] actual10 = new int[] {1,5,0,7,6,2,8,9,4,3};
	@Test
	public void BubbleSortEmptyLyst_ShouldReturnEmptyList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual1);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected1, result)); //(expected1, result)) expected1.equals(result));
	}
	@Test
	public void BubbleSortOneElement_ShouldReturnTheElement() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual2);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected2, result));
	}
	@Test
	public void BubbleSortTwoElementsInOrder_ShouldReturnSameList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual3);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}
	@Test
	public void BubbleSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual4);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}
	@Test
	public void BubbleSortTwoEqualElements_ShouldReturnElementsInOrder() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual5);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}
	@Test
	public void BubbleSortThreeElementsInOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual6);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected6, result));
	}
	@Test
	public void BubbleSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual7);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected7, result));
	}
	@Test
	public void BubbleSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual8);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected8, result));
	}
	@Test
	public void BubbleSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual9);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected9, result));
	}
	@Test
	public void BubbleSortNElementsRandomOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.bubbleSort(actual10);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected10, result));
	}
	@Test
	public void quickSortEmptyLyst_ShouldReturnEmptyList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual1);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected1, result)); //(expected1, result)) expected1.equals(result));
	}
	@Test
	public void quickSortOneElement_ShouldReturnTheElement() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual2);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected2, result));
	}
	@Test
	public void quickSortTwoElementsInOrder_ShouldReturnSameList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual3);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}
	@Test
	public void quickSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual4);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}
	@Test
	public void quickSortTwoEqualElements_ShouldReturnElementsInOrder() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual5);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}
	@Test
	public void quickSortThreeElementsInOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual6);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected6, result));
	}
	@Test
	public void quickSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual7);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected7, result));
	}
	@Test
	public void quickSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual8);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected8, result));
	}
	@Test
	public void quickSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual9);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected9, result));
	}
	@Test
	public void quickSortNElementsRandomOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.quickSort(actual10);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected10, result));
	}
	
	//insertion sort test methods
	@Test
	public void InsertionSortEmptyLyst_ShouldReturnEmptyList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual1);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected1, result));
	}
	
	@Test
	public void InsertionSortOneElement_ShouldReturnTheElement() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual2);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected2, result));
	}
	
	@Test
	public void InsertionSortTwoElementsInOrder_ShouldReturnSameList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual3);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}
	
	@Test
	public void InsertionSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual4);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}
	
	@Test
	public void InsertionSortTwoEqualElements_ShouldReturnElementsInOrder() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual5);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}
	
	@Test
	public void InsertionSortThreeElementsInOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual6);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected6, result));
	}
	
	@Test
	public void InsertionSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual7);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected7, result));
	}
	
	@Test
	public void InsertionSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual8);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected8, result));
	}
	
	@Test
	public void InsertionSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual9);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected9, result));
	}
	
	@Test
	public void InsertionSortNElementsRandomOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.insertionSort(actual10);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected10, result));
	}
	
	//test methods for selection sort algorithm
	@Test
	public void SelectionSortEmptyLyst_ShouldReturnEmptyList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual1);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected1, result));
	}
	
	@Test
	public void SelectionSortOneElement_ShouldReturnTheElement() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual2);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected2, result));
	}
	
	@Test
	public void SelectionSortTwoElementsInOrder_ShouldReturnSameList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual3);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected3, result));
	}
	
	@Test
	public void SelectionSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual4);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected4, result));
	}
	
	@Test
	public void SelectionSortTwoEqualElements_ShouldReturnElementsInOrder() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual5);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected5, result));
	}
	
	@Test
	public void SelectionSortThreeElementsInOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual6);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected6, result));
	}
	
	@Test
	public void SelectionSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual7);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected7, result));
	}
	
	@Test
	public void SelectionSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual8);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected8, result));
	}
	
	@Test
	public void SelectionSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual9);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected9, result));
	}
	
	@Test
	public void SelectionSortNElementsRandomOrder_ShouldReturnSortedList() {
		ArrayList<int[]> steps = new ArrayList<int[]>();
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.SelectionSort(steps, actual10);
		result = array.get(array.size()-1);
		Assert.assertTrue(Arrays.equals(expected10, result));
	}
}
