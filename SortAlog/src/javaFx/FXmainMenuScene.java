package javaFx;

import javafx.scene.Parent;
import javafx.scene.Scene;
//NOT WORKING ELLIOTT UPTON
public class FXmainMenuScene extends Scene{

	public FXmainMenuScene(mainMenu mainMenu, Parent group) {
		super(group);
			mainMenuModel model = new mainMenuModel(mainMenu);
			FXmainMenuPanel panel = new FXmainMenuPanel(model,group);
			
			//setLayout(new BorderLayout());
			//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			//JLabel title = new JLabel("SortAlgo Main Menu");
			//title.setHorizontalAlignment(getWidth()/2);
			//title.setFont(new Font("Helvetica", Font.BOLD, 20));
			
			//add(title, BorderLayout.NORTH);
			//add(panel, BorderLayout.WEST);

		}
}
