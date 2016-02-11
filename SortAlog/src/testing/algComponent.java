package testing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class algComponent extends JPanel
{
	public algComponent(sortingAlgs sort)
	{	
		algModel model = new algModel(sort);
		controlsPanel controlspanel = new controlsPanel(model);
		setLayout(new BorderLayout());
		
		System.out.println(sort);
		JLabel title =  new JLabel();
		String sortType = model.getSortTypeString();
		title.setText(sortType);
		
		add(title, BorderLayout.NORTH);
		add(controlspanel, BorderLayout.SOUTH);

	}
}
