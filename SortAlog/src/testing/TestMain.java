package testing;

import java.util.ArrayList;

public class TestMain {

	/**A class to check if sort algorithms work
	 * @param args
	 */
	public static void main(String[] args) {
		SortAlgos sorts = new SortAlgos();
		//int[] arr = {1,1,1,1,2,2,3,4,1,2};
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(1);
		array.add(1);
		array.add(1);
		array.add(2);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(1);
		array.add(2);
		
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		
		sorted = sorts.Bubble(array);
		sorts.printArrayList(sorted);
	}

}
