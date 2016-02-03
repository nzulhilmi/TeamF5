package testing;
/**
 * The code which supports the building of the model.
 * 
 * @author ElliottUpton
 *
 */
public class mainMenu {
	public mainMenu() {
	
	}

	public void setSort(String sort) {
		switch (sort) {
		case "bubble":
			System.out.println("bubble sort selected");
			break;
		case "PLACEHOLDER1":
			System.out.println("PlaceHolder selected");
			break;
		default:
			break;
		}
		
	}
}
