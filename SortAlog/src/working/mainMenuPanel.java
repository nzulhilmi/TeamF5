package working;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Class containing all of the buttons for the main menu and relevant actions.
 * 
 * @author ElliottUpton
 *
 */
public class mainMenuPanel extends JPanel{
	private boolean menuType;
	JButton menuButtonType;
	mainMenuModel model;

	public mainMenuPanel(mainMenuModel model) {
		// TODO Auto-generated constructor stub
	super();
	this.model = model;
	menuType = model.getMenuType();
	
	JButton bubble = new JButton("bubble");
	bubble.addActionListener(e -> model.setSort("bubble"));

	JButton placeholder1 = new JButton("PLACEHOLDER1");
	placeholder1.addActionListener(e -> model.setSort("PLACEHOLDER1"));
	
	if(!model.getMenuType()){
		//Kiril Can you make this dynamic?
		// i have tried making this class an observer with an update method repaiting but i can't make it work for now
		//
		
		menuButtonType = new JButton("Normal");
		menuButtonType.addActionListener(e -> model.setMenuType(true));
	}else {
		menuButtonType = new JButton("Advanced");
		menuButtonType.addActionListener(e -> model.setMenuType(false));
	}
	
	ButtonGroup sorts = new ButtonGroup();
	sorts.add(bubble);
	sorts.add(placeholder1);
	
	add(bubble);
	add(placeholder1);
	add(menuButtonType);
	}
}
