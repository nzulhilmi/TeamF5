package testing;

import javax.swing.JFrame;
/**
 * This is the main GUI class for the algorithms
 *
 * @author ElliottUpton
 *
 */
public class algGUI {
	private String sortType;
	public algGUI(String sortType)
	{
		this.sortType = sortType;
		JFrame frame = new JFrame("SortAlgo : " + sortType);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		sortingAlgs sort = new sortingAlgs(sortType);
		//sortingAlgsComponent comp = new sortingAlgsComponent(mainMenu); NOT MADE YET
		
		//frame.add(comp);
		frame.setVisible(true);	
	}

}
