package javaFx;
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
			//FXvisualiser bubble = new FXvisualiser();
			break;
		case "quick":
			System.out.println("quick sort selected");
			//algGUI quick = new algGUI("quick");
			break;
		case "insertion":
			System.out.println("insertion sort selected");
			//algGUI insertion = new algGUI("insertion");
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
