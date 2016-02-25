package javaFx;

import java.util.ArrayList;
import java.util.Observable;

import testing.sortingAlgs;
import testing.visualiser;

public class algModel extends Observable{
	private int current;
	private ArrayList<int[]> steps;
	private visualiser vis;
	private boolean loop;
	private int n;
	public algModel(sortingAlgs alg,ArrayList<int[]> steps, visualiser vis) {
		super();
		this.current = 0;
		this.steps = steps;
		this.vis = vis;
		this.loop = false;
		this.n = 20;

	}

	public void goBack(){
		if(current > 0){
			current--;
			vis.setCurrentIndex(current);
			//vis.validate();
			vis.forceRepaint();
		}
		System.out.println("Current step: "+ (current+1));
	}
	
	public int getCurrent(){
		return current;
	}
	
	public int[] getCurrentList(){
		return steps.get(current);
	}
	
	public void setCurrentList(ArrayList<int[]> theNewArray){
		steps = theNewArray;
		current = 0;
	}

	public void goForward(){
		if(current < steps.size()-1){
			current++;
			vis.setCurrentIndex(current);
			vis.forceRepaint();
		}
		System.out.println("Current step: "+ (current+1));
	}
	/*
	public void pause(){
		this.loop = false;
		//System.err.println("pause the annimation");
	}
	
	public void play(){
		this.loop = true;
		Timer time = new Timer(current, null);
			while(this.loop==true){
				
				if(current < steps.size()-1){
					current++;
					vis.setCurrentIndex(current);
					vis.forceRepaint();
				}else{
					this.loop = false;
				}
				System.out.println("working");
			}
		
		System.out.println("end");
	}
	*/
	public void setSpeed(int value) {
		System.err.println("set the speed");
		
	}
	public void setVis(visualiser vis) {
		this.vis = vis;
		
	}
	
	public String getSortTypeString() {
		String sort = sortingAlgs.getSortTypeString();
		return sort;
	}
	public int getBound() {
		return steps.size() -1;
	}
}
