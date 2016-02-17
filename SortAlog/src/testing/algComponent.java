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
		steps.add(new int[] {1,1,1,1,1});
		ArrayList<int[]> steps1 = new ArrayList<int[]>();
		steps1.add(new int[] {5,4,3,2,1});
		steps1.add(new int[] {4,5,3,2,1});
		steps1.add(new int[] {3,4,5,2,1});
		steps1.add(new int[] {2,3,4,5,1});
		steps1.add(new int[] {1,2,3,4,5});
		
		algModel model = new algModel(sort, steps, null);
		controlsPanel controlspanel = new controlsPanel(model);
		setLayout(new BorderLayout());

		JLabel title =  new JLabel();
		String sortType = model.getSortTypeString();
		//Caps first letter.
		String sortType1 = sortType.substring(0, 1).toUpperCase() + sortType.substring(1);
		title.setText("Visualising : " + sortType1 + " Sort");
		title.setHorizontalAlignment(getWidth()/2);
		title.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		visualiser vis = new visualiser(model, getWidth(), getHeight(), steps, 0);
		model.setVis(vis);
		add(title, BorderLayout.NORTH);
		add(controlspanel, BorderLayout.SOUTH);
		add(vis, BorderLayout.CENTER);
		//model.addObserver(e->);
		model.setCurrentList(steps1);
		vis.setSorted(steps1);
		vis.setCurrentIndex(1);
		//vis.setCurrentList(steps1.get(1));
		
		vis.revalidate();
		vis.repaint();
		System.out.println("end");
	}
}
