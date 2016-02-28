package testing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class algComponent extends JPanel
{
	public algComponent(sortingAlgs sort)
	{	
		ArrayList<int[]> steps = new ArrayList<int[]>();	
		
		//31, 56, 87, 12, 98, 22, 43, 131, 76, 5
		int[]input = {31, 56, 87, 12, 98, 22, 43, 131, 76, 5};
		
		steps = sort.sorted;
		
		
		algModel model = new algModel(sort, steps, null); //------------steps
		controlsPanel controlspanel = new controlsPanel(model);
		setLayout(new BorderLayout());

		JLabel title =  new JLabel();
		String sortType = model.getSortTypeString();
		//Caps first letter.
		String sortType1 = sortType.substring(0, 1).toUpperCase() + sortType.substring(1);
		title.setText("Visualising : " + sortType1 + " Sort");
		title.setHorizontalAlignment(getWidth()/2);
		title.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		visualiser vis = new visualiser(model, getWidth(), getHeight(), steps, 0); //------------steps
		model.setVis(vis);
		add(title, BorderLayout.NORTH);
		add(controlspanel, BorderLayout.SOUTH);
		add(vis, BorderLayout.CENTER);
		//model.addObserver(e->);
		model.setCurrentList(steps); //----------steps1
		vis.setSorted(steps); //----------------steps1
		vis.setCurrentIndex(1);
		//vis.setCurrentList(steps1.get(1));
		
		vis.revalidate();
		vis.repaint();
		System.out.println("end");
	}
}
