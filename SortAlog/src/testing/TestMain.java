package testing;

import java.util.ArrayList;

public class TestMain {

	/**A main class to check if sort algorithms works
	 * @param args
	 */
	public static void main(String[] args) {
		SortAlgos sorts = new SortAlgos();
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
		
		ArrayList<ArrayList<Integer>> sorted = new ArrayList<ArrayList<Integer>>();
		
		sorted = sorts.Bubble(array);
		sorts.printArrayList(sorted.get(sorted.size()-1));
		//Print the arraylist of arraylists
		System.out.println();
		for(ArrayList<Integer> innerList : sorted) {
		    for(Integer number : innerList) {
		        System.out.print(number + ", ");
		    }
		    System.out.println();
		}
	}

}
