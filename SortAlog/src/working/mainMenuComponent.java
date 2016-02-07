package working;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainMenuComponent extends JPanel
{
	public mainMenuComponent(mainMenu menu)
	{
		mainMenuModel model = new mainMenuModel(menu);
		mainMenuPanel panel = new mainMenuPanel(model);
		setLayout(new BorderLayout());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("SortAlgo Main Menu");
		title.setHorizontalAlignment(getWidth()/2);
		title.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		add(title, BorderLayout.NORTH);
		add(panel, BorderLayout.WEST);

	}
}
