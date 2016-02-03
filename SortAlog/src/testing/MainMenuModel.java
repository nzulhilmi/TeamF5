package testing;

import java.util.Observable;
/**
 * Class which the Main Menu is built from
 * @author ElliottUpton
 *
 */
public class MainMenuModel extends Observable {
	private mainMenu menu;

	public MainMenuModel(mainMenu menu) {
		// TODO Auto-generated constructor stub
		super();
		this.menu = menu;
	}
	
	public void setSort(String sortType){
		menu.setSort(sortType);
	}
	
}
