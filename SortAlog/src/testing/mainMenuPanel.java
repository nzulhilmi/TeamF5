package testing;

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
		super();
		this.model = model;
		menuType = model.getMenuType();

		JButton bubble = new JButton("Bubble");
		bubble.addActionListener(e -> model.setSort("bubble"));

		JButton quick = new JButton("Quick");
		quick.addActionListener(e -> model.setSort("quick"));
		
		JButton insertion = new JButton("Insertion");
		insertion.addActionListener(e -> model.setSort("insertion"));

		//can someone make this dynamic??????
		//i'm out of ideas
		if(!model.getMenuType()){
			menuButtonType = new JButton("Standard");
			menuButtonType.addActionListener(e -> {model.setMenuType(true); invalidate();});
			menuButtonType = new JButton("Advanced");
			menuButtonType.addActionListener(e -> {model.setMenuType(false); invalidate();});
		}

		ButtonGroup sorts = new ButtonGroup();
		sorts.add(bubble);
		sorts.add(quick);
		sorts.add(insertion);
		
		add(bubble);
		add(quick);
		add(insertion);
		add(menuButtonType);
	}
}
