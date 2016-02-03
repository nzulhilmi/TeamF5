package testing;

import java.util.Observable;
/**
 * Class which the Main Menu is built from
 * @author ElliottUpton
 *
 */
public class mainMenuModel extends Observable {
	private mainMenu menu;

	public mainMenuModel(mainMenu menu) {
		// TODO Auto-generated constructor stub
		super();
		this.menu = menu;
	}
	
	public void setSort(String sortType){
		menu.setSort(sortType);
	}
	
	public boolean getMenuType(){
		return menu.getMenuType();
	}
	
	public void setMenuType(Boolean b){
		menu.setMenuType(b);
	}
}