package testing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class box {
	private Rectangle.Double box;
	public box (int xCoord, int yCoord, int Size, String Content /*String Colour*/){

		box = new Rectangle.Double(xCoord, yCoord, Size, Size);
	}

	public void draw(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.draw(box);
	}
}
