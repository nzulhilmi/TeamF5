package testing;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
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
	int[] expected7 = new int[] {1,3,2};
	int[] actual7 = new int[] {1,3,2};
	// {2,1,3}
	int[] expected8 = new int[] {2,1,3};
	int[] actual8 = new int[] {2,1,3};
	// {3,2,1}
	int[] expected9 = new int[] {3,2,1};
	int[] actual9 = new int[] {3,2,1};
	// {1,5,0,7,6,2,8,9,4,3}
	int[] expected10 = new int[] {1,5,0,7,6,2,8,9,4,3};
	int[] actual10 = new int[] {1,5,0,7,6,2,8,9,4,3};
	@Test
	public void BubbleSortEmptyLyst_ShouldReturnEmptyList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual1);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected1.equals(result));
	}
	@Test
	public void BubbleSortOneElement_ShouldReturnTheElement() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual2);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected2.equals(result));
	}
	@Test
	public void BubbleSortTwoElementsInOrder_ShouldReturnSameList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual3);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected3.equals(result));
	}
	@Test
	public void BubbleSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual4);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected4.equals(result));
	}
	@Test
	public void BubbleSortTwoEqualElements_ShouldReturnElementsInOrder() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual5);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected5.equals(result));
	}
	@Test
	public void BubbleSortThreeElementsInOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual6);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected6.equals(result));
	}
	@Test
	public void BubbleSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual7);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected7.equals(result));
	}
	@Test
	public void BubbleSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual8);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected8.equals(result));
	}
	@Test
	public void BubbleSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual9);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected9.equals(result));
	}
	@Test
	public void BubbleSortNElementsRandomOrder_ShouldReturnSortedList() {
		int[] result= new int[expected1.length];
		ArrayList<int[]> array = SortAlgos.Bubble(actual10);
		result = array.get(array.size()-1);
		Assert.assertTrue(expected10.equals(result));
	}
	

}
