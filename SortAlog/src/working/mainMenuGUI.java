package working;

import javax.swing.JFrame;

public class mainMenuGUI extends JFrame {
	/**
	 * Create the frame.
	 * @return 
	*/
	
	public mainMenuGUI()
	{
		JFrame frame = new JFrame("SortAlgo Main Menu");
		frame.setSize(200, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainMenu mainMenu = new mainMenu();
		mainMenuComponent comp = new mainMenuComponent(mainMenu);
		
		frame.add(comp);
		frame.setVisible(true);	
	}
}
