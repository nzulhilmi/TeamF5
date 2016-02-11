package testing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class algComponent extends JPanel
{
	public algComponent(sortingAlgs sort)
	{	
		algModel model = new algModel(sort);
		controlsPanel controlspanel = new controlsPanel(model);
		setLayout(new BorderLayout());

		JLabel title =  new JLabel();
		String sortType = model.getSortTypeString();
		//Capitalises first letter.
		String sortType1 = sortType.substring(0, 1).toUpperCase() + sortType.substring(1);
		title.setText("Visulising : " + sortType1 + " Sort");
		title.setHorizontalAlignment(getWidth()/2);
		title.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		visuliser vis = new visuliser(model);
		
		add(title, BorderLayout.NORTH);
		add(controlspanel, BorderLayout.SOUTH);
		add(vis, BorderLayout.CENTER);
	}
}
