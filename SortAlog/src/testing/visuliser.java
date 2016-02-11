package testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class visuliser extends JPanel{
	algModel model;
	int boxWidth = 10;
	
	public Rectangle.Double house;
	public Rectangle.Double door;
	public Rectangle.Double window1;
	public Rectangle.Double window2;
	public Rectangle.Double window3;
	public Line2D.Double roof;
	public Line2D.Double roof1;
	private	int xCoord = getHeight()/2+200;
	private	int yCoord = getWidth()/2+200;
	private	int Size = 100;
	
	public visuliser(algModel model){
		super();
		this.model = model;
		House(xCoord, yCoord, Size);
	}

		/**
		Creation of a House
		@param xCoord x coordinate of the house
		@param yCoord y coordinate of the house
		@param Size size of the house
		*/

		public void House (int xCoord, int yCoord, int Size)
		{
			house = new Rectangle.Double(xCoord, yCoord, Size, Size); //main building

			door = new Rectangle.Double(xCoord + Size - (Size / 3) - (Size/10), yCoord + Size - (Size / 2), Size/3, Size/2);
			
			window1 = new Rectangle.Double( xCoord + (Size/10), yCoord + (Size/10), Size/3, Size/3.5); //top left

			window2 = new Rectangle.Double( xCoord + Size - (Size/3) - (Size/10), yCoord + (Size/10), Size/3, Size/3.5); //top right
			
			window3 = new Rectangle.Double( xCoord + (Size/10), yCoord + Size - (Size/3.5) - (Size/6), Size/3, Size/3.5); //bottom left

			roof = new Line2D.Double(xCoord, yCoord, xCoord + Size/2, yCoord - Size/4); //right side

			roof1 = new Line2D.Double(xCoord + Size, yCoord, xCoord + Size/2, yCoord - Size/4); //left side
		}

		public void draw(Graphics2D g)
		{
			g.setColor(Color.BLACK);
			g.draw(house);
			g.draw(door);

			g.draw(window1);
			g.draw(window2);
			g.draw(window3);
			g.draw(roof);
			g.draw(roof1);
		}
		

		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D)g;
			
			draw(g2);
		}
		
	
}


	
