package testing;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMain {

	/**A main class to check if sort algorithms works
	 * @param args
	 */
	public static void main(String[] args) {
		SortAlgos sorts = new SortAlgos();
		int[] array = new int[] {5, 7, 20, 13, 8, 2, 6, 19, 10, 17};

		
		ArrayList<int[]> sorted = new ArrayList<int[]>();
		sorted = sorts.bubbleSort(array);
		int[] result= sorted.get(sorted.size()-1);
		
		//Print the arraylist of arraylists
		System.out.println(Arrays.toString(result));
		
		for(int[] innerList : sorted) {
		    for(Integer number : innerList) {
		        System.out.print(number + ", ");
		    }
		    System.out.println();
		}
	}

}
