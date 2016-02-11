import java.util.ArrayList;

/**
 * Implementation of Insertion Sort algorithm.
 * @author nik
 *
 */
public class InsertionSort {
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(70);
		test.add(4);
		test.add(40);
		test.add(50);
		test.add(2);
		test.add(13);
		test.add(27);
		test.add(1);
		test.add(38);
		test.add(6);
		// [7, 4, 40, 50, 2, 13, 27, 1, 38, 6]
		// result = [1, 2, 4, 6, 7, 13, 27, 38, 50, 70]
		algorithm(test);
		
		int n = algorithm(test).size() - 1;
		System.out.println(algorithm(test).get(n));
	}
	
	/**
	 * Insertion sort algorithm.
	 * @param a
	 * @return ArrayList<ArrayList<Integer>> steps. Returns step
	 * by step array list.
	 */
	public static ArrayList<ArrayList<Integer>> algorithm(ArrayList<Integer> a) {
		
		ArrayList<ArrayList<Integer>> steps = new ArrayList<ArrayList<Integer>>();
		steps.add(a);
		
		//the algorithm for insertion sort
		int n = a.size();
		for(int i = 1; i < n; i++) {
			ArrayList<Integer> temporary = new ArrayList<Integer>();
			
			int key = a.get(i); //element to be compared
			
			int j = i - 1;
			while( (j > -1) && (a.get(j) > key)) {
				a.set(j+1, a.get(j));
				j--;
			}
			a.set(j+1, key);
			
			//add a to temporary list
			for(int k = 0; k < a.size(); k++) {
				temporary.add(a.get(k));
			}
			
			//add to steps array list
			steps.add(temporary);
		}
		return steps;
	}
}s
