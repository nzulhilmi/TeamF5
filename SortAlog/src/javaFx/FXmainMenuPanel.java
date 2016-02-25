package javaFx;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * Class containing all of the buttons for the main menu and relevant actions.
 * USELESS
 * @author ElliottUpton
 *
 */
public class FXmainMenuPanel extends Scene{
	private boolean menuType;
	mainMenuModel model;

	public FXmainMenuPanel(mainMenuModel model, Parent group) {
		super(group);
		this.model = model;
		menuType = model.getMenuType();
		
		
		Button bubble = new Button("Bubble");
		bubble.setOnAction(e -> model.setSort("bubble"));

		Button quick = new Button("Quick");
		quick.setOnAction(e -> model.setSort("quick"));
		
		Button insertion = new Button("Insertion");
		insertion.setOnAction(e -> model.setSort("insertion"));

		/* TODO
		//can someone make this dynamic??????
		//i'm out of ideas
		if(!model.getMenuType()){
			menuButtonType = new JButton("Standard");
			menuButtonType.addActionListener(e -> {model.setMenuType(true); invalidate();});
			menuButtonType = new JButton("Advanced");
			menuButtonType.addActionListener(e -> {model.setMenuType(false); invalidate();});
		}
		 */
		VerticalButtonBar bar = new VerticalButtonBar();
		bar.addButton(bubble);
		bar.addButton(quick);
		bar.addButton(insertion);
	}
}
