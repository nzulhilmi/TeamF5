package testing;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import org.junit.Assert;

import org.junit.Test;


public class SortAlgosTest {
	SortAlgos SortAlgos = new SortAlgos();
	ArrayList<Integer> expected1 = new ArrayList<Integer>();
	ArrayList<Integer> actual1 = new ArrayList<Integer>();
	ArrayList<Integer> expected2 = (ArrayList<Integer>) asList(1);
	ArrayList<Integer> actual2 = (ArrayList<Integer>) asList(1);
	ArrayList<Integer> expected3 = (ArrayList<Integer>) asList(1,2);
	ArrayList<Integer> actual3 = (ArrayList<Integer>) asList(1,2);
	ArrayList<Integer> expected4 = (ArrayList<Integer>) asList(1,2);
	ArrayList<Integer> actual4 = (ArrayList<Integer>) asList(2,1);
	ArrayList<Integer> expected5 = (ArrayList<Integer>) asList(1,1);
	ArrayList<Integer> actual5 = (ArrayList<Integer>) asList(1,1);
	ArrayList<Integer> expected6 = (ArrayList<Integer>) asList(1,2,3);
	ArrayList<Integer> actual6 = (ArrayList<Integer>) asList(1,2,3);
	ArrayList<Integer> expected7 = (ArrayList<Integer>) asList(1,2,3);
	ArrayList<Integer> actual7 = (ArrayList<Integer>) asList(1,3,2);
	ArrayList<Integer> expected8 = (ArrayList<Integer>) asList(1,2,3);
	ArrayList<Integer> actual8 = (ArrayList<Integer>) asList(2,1,3);
	ArrayList<Integer> expected9 = (ArrayList<Integer>) asList(1,2,3);
	ArrayList<Integer> actual9 = (ArrayList<Integer>) asList(3,2,1);
	ArrayList<Integer> expected10 = (ArrayList<Integer>) asList(0,1,2,3,4,5,6,7,8,9);
	ArrayList<Integer> actual10 = (ArrayList<Integer>) asList(1,5,0,7,6,2,8,9,4,3);
	@Test
	public void BubbleSortEmptyLyst_ShouldReturnEmptyList() {
		Assert.assertTrue(expected1.equals(SortAlgos.Bubble(actual1)));
	}
	@Test
	public void BubbleSortOneElement_ShouldReturnTheElement() {
		Assert.assertTrue(expected2.equals(SortAlgos.Bubble(actual2)));
	}
	@Test
	public void BubbleSortTwoElementsInOrder_ShouldReturnSameList() {
		Assert.assertTrue(expected3.equals(SortAlgos.Bubble(actual3)));
	}
	@Test
	public void BubbleSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		Assert.assertTrue(expected4.equals(SortAlgos.Bubble(actual4)));
	}
	@Test
	public void BubbleSortTwoEqualElements_ShouldReturnElementsInOrder() {
		Assert.assertTrue(expected5.equals(SortAlgos.Bubble(actual5)));
	}
	@Test
	public void BubbleSortThreeElementsInOrder_ShouldReturnSortedList() {
		Assert.assertTrue(expected6.equals(SortAlgos.Bubble(actual6)));
	}
	@Test
	public void BubbleSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		Assert.assertTrue(expected7.equals(SortAlgos.Bubble(actual7)));
	}
	@Test
	public void BubbleSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		Assert.assertTrue(expected8.equals(SortAlgos.Bubble(actual8)));
	}
	@Test
	public void BubbleSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		Assert.assertTrue(expected9.equals(SortAlgos.Bubble(actual9)));
	}
	@Test
	public void BubbleSortNElementsRandomOrder_ShouldReturnSortedList() {
		Assert.assertTrue(expected10.equals(SortAlgos.Bubble(actual10)));
	}
	

}
