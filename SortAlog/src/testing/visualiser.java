package testing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.Array;

import javax.swing.JPanel;

public class visualiser extends JPanel{
	algModel model;
	private int panelWidth;
	private int panelHeight;
	private	int xCoord;
	private	int yCoord;
	private	int Size = 100;
	private int boxSize = 30;
	private int numBoxes = 10;//this is temp normally get from array length.
	private box[] boxes = new box[numBoxes];;

	//can't seem to work out the middle dynamically for now will set statically
	public visualiser(algModel model, int x, int y/*,ArrayList<int[]> sorted*/){
		super();
		this.model = model;
		panelWidth = 275;
		panelHeight = 250;
		
		//this.boxes = new box[numBoxes];
		
		xCoord = panelWidth/2;
		yCoord = panelHeight/2;
		
		//xCoord, yCoord, Size, Content
		//boxes[1] = new box(xCoord, yCoord, boxSize, "1");
		
		
		for(int i = 0; i < numBoxes; i++)
		{
			if(i > 0)
			{
				xCoord = xCoord + Size;
			}
			 boxes[i] = new box(xCoord, yCoord, boxSize, "1");
		}
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		for(int i = 0; i < boxes.length; i++)
			boxes[i].draw(g2);
	}




}



