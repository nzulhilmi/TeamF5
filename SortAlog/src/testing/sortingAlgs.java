package testing;

import java.util.ArrayList;

/**
 * This class will hold all of the sorting class algorithms
 * 
 * @author ElliottUpton
 *
 */
public class sortingAlgs {
	public static String sortType;
	public static int[] toBesorted;
	public static ArrayList<int[]> sorted;
	public sortingAlgs(String sortType, int[] toBesorted){
		this.sortType = sortType;
		this.toBesorted = toBesorted;
		
		switch (sortType) {
		
		case "bubble":
			this.sorted = SortAlgos.bubbleSort(toBesorted);
			break;
		case "quick" :
			this.sorted = SortAlgos.quickSort(toBesorted);
			break;
		case "insertion" :
			this.sorted = SortAlgos.insertionSort(toBesorted);
			break;
		default:
			break;
		}
	}

	public static String getSortTypeString(){
		return sortType;
	}
	
}
