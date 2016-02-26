package testing;

import java.util.ArrayList;

public class TestMain {

	/**A main class to check if sort algorithms works
	 * @param args
	 */
	public static void main(String[] args) {
		SortAlgos sorts = new SortAlgos();
		int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int[] array = new int[] {5, 7, 20, 13, 8, 2, 6, 19, 10, 17};
		//int[] array = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		ArrayList<int[]> steps = new ArrayList<int[]>();
		ArrayList<int[]> sorted = new ArrayList<int[]>();
		sorted = sorts.bubbleSort(array);
		//sorted = sorts.quickSort(array);
		//sorted = sorts.insertionSort(array);
		//sorted = sorts.SelectionSort(steps,array);
		int[] result= sorted.get(sorted.size()-1);
		
		//Print the arraylist of arraylists
		//System.out.println(Arrays.toString(result));
		int rotCount = 0;
		for(int[] innerList : sorted) {
		    for(Integer number : innerList) {
		        System.out.print(number + ", ");
		    }
		    rotCount++;
		    System.out.println();
		}
		System.out.println(rotCount);
	}

}
