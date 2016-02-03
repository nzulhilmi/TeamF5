package core;

public class TestMain {

	/**A class to check if sort algorithms work
	 * @param args
	 */
	public static void main(String[] args) {
		SortAlgos sorts = new SortAlgos();
		int array[] = {1,1,1,1,2,2,3,4,1,2};
		int sorted[] = new int[10];
		
		sorted = sorts.Bubble(array);
		sorts.printArray(sorted);
	}

}
