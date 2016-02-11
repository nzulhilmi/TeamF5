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

		sortingAlgs sort = new sortingAlgs(sortType);
		algComponent comp = new algComponent(sort);
		
		frame.add(comp);
		frame.setVisible(true);
	}

}
