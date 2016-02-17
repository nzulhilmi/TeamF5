package testing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class box extends JComponent {
	private Rectangle.Double box;
	private JLabel label = new JLabel();
	int xCoord;
	int yCoord;
	int size;
	String content;
	
	public box (int xCoord, int yCoord, int size, String content /*, String Colour*/){

		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.size = size;
		this.content = content;
		
		box = new Rectangle.Double(xCoord, yCoord, size, size);
		label.setText(content);
		label.setLabelFor(this);
		add(label);
	}

	public void draw(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.draw(box);
		label.paint(g);
		g.drawString(content, xCoord + (size/2)-4, yCoord + (size/2)+5);
	}
	
}
