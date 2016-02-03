package testing;
import static org.junit.Assert.*;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;


public class SortAlgosTest {
	SortAlgos SortAlgos = new SortAlgos();

	@Test
	public void BubbleSortEmptyLyst_ShouldReturnEmptyList() {
		Assert.assertTrue(Arrays.equals(new int[]{}, SortAlgos.Bubble(new int[]{})));
	}
	@Test
	public void BubbleSortOneElement_ShouldReturnTheElement() {
		Assert.assertTrue(Arrays.equals(new int[]{1}, SortAlgos.Bubble(new int[]{1})));
	}
	@Test
	public void BubbleSortTwoElementsInOrder_ShouldReturnSameList() {
		Assert.assertTrue(Arrays.equals(new int[]{1,2}, SortAlgos.Bubble(new int[]{1,2})));
	}
	@Test
	public void BubbleSortTwoElementsInReverseOrder_ShouldReturnSortedList() {
		Assert.assertTrue(Arrays.equals(new int[]{1, 2}, SortAlgos.Bubble(new int[]{2, 1})));
	}
	@Test
	public void BubbleSortTwoEqualElements_ShouldReturnElementsInOrder() {
		Assert.assertTrue(Arrays.equals(new int[]{1,1}, SortAlgos.Bubble(new int[]{1,1})));
	}
	@Test
	public void BubbleSortThreeElementsInOrder_ShouldReturnSortedList() {
		Assert.assertTrue(Arrays.equals(new int[]{1,2,3}, SortAlgos.Bubble(new int[]{1,2,3})));
	}
	@Test
	public void BubbleSortThreeElementsLastTwoSwaped_ShouldReturnSortedList() {
		Assert.assertTrue(Arrays.equals(new int[]{1,2,3}, SortAlgos.Bubble(new int[]{1,3,2})));
	}
	@Test
	public void BubbleSortThreeElementsFirstTwoSwaped_ShouldReturnSortedList() {
		Assert.assertTrue(Arrays.equals(new int[]{1,2,3}, SortAlgos.Bubble(new int[]{2,1,3})));
	}
	@Test
	public void BubbleSortThreeElementsInReverseOrder_ShouldReturnSortedList() {
		Assert.assertTrue(Arrays.equals(new int[]{1,2,3}, SortAlgos.Bubble(new int[]{3,2,1})));
	}
	@Test
	public void BubbleSortNElementsRandomOrder_ShouldReturnSortedList() {
		Assert.assertTrue(Arrays.equals(new int[]{0,1,2,3,4,5,6,7,8,9}, SortAlgos.Bubble(new int[]{1,5,0,7,6,2,8,9,4,3})));
	}
	

}
