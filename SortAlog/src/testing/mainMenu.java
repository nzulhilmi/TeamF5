package testing;
/**
 * The code which supports the building of the model.
 * 
 * @author ElliottUpton
 *
 */
public class mainMenu {
	private boolean menuType = false; //True == advanced False == normal.
	public mainMenu() {
	
	}

	public void setSort(String sort) {
		switch (sort) {
		case "bubble":
			System.out.println("bubble sort selected");
			algGUI bubble = new algGUI(sort);
			break;
		case "PLACEHOLDER1":
			System.out.println("PlaceHolder selected");
			algGUI PLACEHOLDERGUI = new algGUI(sort);
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * @returns True if advanced menu is active
	 * @returns False if normal menu is active
	 */
	public boolean getMenuType(){
		return menuType;
	}
	
	public void setMenuType(Boolean b) {
		menuType = b;
		System.err.println(menuType);
		System.err.println("ignore this button it is broken. \n idea is to expan the main menu when clicked to allow for more options");
	}
}
