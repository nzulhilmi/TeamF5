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

	public mainMenuPanel(mainMenu model) {
		// TODO Auto-generated constructor stub
	super();
	JButton bubble = new JButton("bubble");
	bubble.addActionListener(e -> model.setSort("bubble"));

	JButton placeholder1 = new JButton("PLACEHOLDER1");
	placeholder1.addActionListener(e -> model.setSort("PLACEHOLDER1"));
	
	ButtonGroup sorts = new ButtonGroup();
	sorts.add(bubble);
	sorts.add(placeholder1);
	
	add(bubble);
	add(placeholder1);
	}
}
