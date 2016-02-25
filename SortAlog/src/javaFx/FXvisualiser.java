package javaFx;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import javafx.scene.layout.FlowPane;
import testing.algModel;
import testing.box;

public class FXvisualiser extends FlowPane{
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
	public FXvisualiser(algModel model/*,ArrayList<int[]> sorted, int currentIndex*/){
		super();
		this.model = model;
		this.sorted = sorted;
		this.currentIndex = currentIndex;
		
		
		
		System.out.println(getCurrentList()[0] +" "+ getCurrentList()[1] +" "+ getCurrentList()[2]);
		this.numBoxes = sorted.get(sorted.size()-1).length;//sorted.get(currentIndex).length;
		this.boxes = new box[numBoxes];
		//temp values
		panelWidth = 800;
		panelHeight = 400;
		
		xCoord = panelWidth/10;
		System.out.print(xCoord);
		yCoord = panelHeight/4;
	}
	
	public void paintComponent(Graphics g)
	{
		int xCur = xCoord;
		for(int i = 0; i < numBoxes; i++)
		{
			xCur = xCur + boxSize + (boxSize/5);
			boxes[i] = new box(xCur, yCoord, boxSize, String.valueOf(getCurrentList()[i])); //haneg content values
		}
		
		Graphics2D g2 = (Graphics2D)g;
		for(int i = 0; i < boxes.length; i++){
			boxes[i].draw(g2);
		}
	}

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
}



