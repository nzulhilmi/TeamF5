package testing;
import static org.junit.Assert.*;

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
	

}
