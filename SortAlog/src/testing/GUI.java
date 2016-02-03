package testing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI extends JFrame {
	private int width;
	private int height;
	private JFrame frame;
	/**
	 * Create the frame.
	 */
	public GUI() {
		frame = new JFrame("main Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 249, 421);
		
		width = frame.getWidth();
		height = frame.getHeight();
		
		JLabel lblSortalgoMainMenu = new JLabel("SortAlgo Main Menu");
		lblSortalgoMainMenu.setVerticalAlignment(SwingConstants.TOP);
		lblSortalgoMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblSortalgoMainMenu);
		
		
		lblSortalgoMainMenu.setVisible(true);
		frame.setVisible(true);
	}
}
