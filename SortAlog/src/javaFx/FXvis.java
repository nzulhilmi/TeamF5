package javaFx;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import testing.algModel;
import testing.box;

public class FXvis extends JPanel{
	algModel model;
	private int panelWidth;
	private int panelHeight;
	private	int xCoord;
	private	int yCoord;
	private int boxSize = 50;
	private int numBoxes;
	private box[] boxes;
	private ArrayList<int[]> sorted;
	private int currentIndex;
	//private int[] currentList;
	//private int[] currentList; 

	//can't seem to work out the middle dynamically for now will set statically
	public FXvis(algModel model, int x, int y,ArrayList<int[]> sorted, int currentIndex){
		super();
		this.model = model;
		this.sorted = sorted;
		this.currentIndex = currentIndex;
		//this.currentList = sorted.get(currentIndex);
		System.out.println(getCurrentList()[0] +" "+ getCurrentList()[1] +" "+ getCurrentList()[2]);
		this.numBoxes = sorted.get(sorted.size()-1).length;//sorted.get(currentIndex).length;
		this.boxes = new box[numBoxes];
		//temp values
		panelWidth = 800;
		panelHeight = 400;
		
		//this.boxes = new box[numBoxes];
		
		xCoord = panelWidth/10;
		//xCoord = 80;
		System.out.print(xCoord);
		yCoord = panelHeight/4;
		//xCoord = 25;
		
		//xCoord, yCoord, Size, Content
		//boxes[1] = new box(xCoord, yCoord, boxSize, "1");
		
		/*
		for(int i = 0; i < numBoxes; i++)
		{
			if(i > 0)
			{
				xCoord = xCoord + boxSize + (boxSize/5);
			}
			 boxes[i] = new box(xCoord, yCoord, boxSize, String.valueOf(currentList[i])); //haneg content values
		}*/
	}
	
	public void paintComponent(Graphics g)
	{
		int xCur = xCoord;
		for(int i = 0; i < numBoxes; i++)
		{
			/*
			if(i > 0)
			{
				xCur = xCur + boxSize + (boxSize/5);
			}*/
			xCur = xCur + boxSize + (boxSize/5);
			boxes[i] = new box(xCur, yCoord, boxSize, String.valueOf(getCurrentList()[i])); //haneg content values
		}
		
		Graphics2D g2 = (Graphics2D)g;
		for(int i = 0; i < boxes.length; i++){
			boxes[i].draw(g2);
		}
		//System.out.println(getCurrentList()[0] +" "+ getCurrentList()[1] +" "+ getCurrentList()[2]);
	}
	/*
	public int getIndexAtPosition(int n){
		return sorted.get(currentIndex);
	}*/

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	public int[] getCurrentList() {
		return sorted.get(currentIndex);
	}

	public ArrayList<int[]> getSorted() {
		return sorted;
	}

	public void setSorted(ArrayList<int[]> sorted) {
		this.sorted = sorted;
	}

	public void forceRepaint() {
		
		//this.updateUI();
		//this.setVisible(false);
		this.revalidate();
		this.repaint(50);
		this.setVisible(false);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(true);
		
		//this.revalidate();
		//this.repaint(50);
		
	}





}



