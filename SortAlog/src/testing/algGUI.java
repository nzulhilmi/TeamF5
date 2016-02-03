package testing;

import javax.swing.JFrame;
/**
 * This is the main GUI class for the algorithms
 *
 * @author ElliottUpton
 *
 */
public class algGUI {
	public algGUI()
	{
		JFrame frame = new JFrame("NAME OF SORT");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		sortingAlgs sorts = new sortingAlgs();
		//sortingAlgsComponent comp = new sortingAlgsComponent(mainMenu); NOT MADE YET
		
		//frame.add(comp);
		frame.setVisible(true);	
	}

}
