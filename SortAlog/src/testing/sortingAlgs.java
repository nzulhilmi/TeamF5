package testing;
/**
 * This class will hold all of the sorting class algorithms
 * 
 * @author ElliottUpton
 *
 */
public class sortingAlgs {
	public static String sortType;
	public sortingAlgs(String sortType){
		this.sortType = sortType;
		switch (sortType) {
		case "bubble":
			bubbleSort();
			break;
		case "PLACEHOLDER1" :
			break;
		default:
			break;
		}
	}
	public void bubbleSort(){

	}
	
	public static String getSortTypeString(){
		return sortType;
	}
	
}
