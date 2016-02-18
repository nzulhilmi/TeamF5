package testing;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
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
		frame.setSize(800, 300);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		int[]input = {31, 56, 87, 12, 98, 22, 43, 131, 76, 5};
		sortingAlgs sort = new sortingAlgs(sortType, input);
		algComponent comp = new algComponent(sort);
		
		frame.add(comp);
		frame.setVisible(true);
	}

}
