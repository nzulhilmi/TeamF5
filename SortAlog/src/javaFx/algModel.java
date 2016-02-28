/*
 *
 */
package javaFx;

import java.util.ArrayList;
import java.util.Observable;

import testing.sortingAlgs;
import testing.visualiser;
/**
 * The .....
 * @author Kiril N.
 *
 */
public class algModel extends Observable{
	private int current;
	private ArrayList<int[]> steps;
	private FXvisualiser visualiser;
	private boolean loop;
	private int n;

	/**
	 * Instantiates a new algorithm model.
	 *
	 * @param steps the steps
	 * @param vis the visualizer
	 */
	public algModel(int[] input, FXvisualiser vis,String type) {
		super();
		SortAlgos alg = new SortAlgos(type, input);
		this.current = 0;
		this.steps = alg.getSortedList();
		System.out.println(steps.get(0).length);
		this.visualiser = vis;
		this.loop = false;
		this.n = 20;

	}

	public algModel(int[] input, String type) {
		super();
		SortAlgos alg = new SortAlgos(type, input);
		this.current = 0;
		this.steps = alg.getSortedList();
		System.out.println(steps.get(0)[0] +" "+ steps.get(0)[1]+" "+ steps.get(0)[2]);
		//this.visualiser = vis;
		this.loop = false;
		this.n = 20;

	}

	public void goBack(){
		if(current > 0){
			current--;
			//visualiser.setCurrentIndex(current);
			//visualiser.forceRepaint();
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
			
			//visualiser.setCurrentIndex(current);
			//visualiser.forceRepaint();
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
	public void setVis(FXvisualiser vis) {
		this.visualiser = vis;

	}

	public String getSortTypeString() {
		String sort = sortingAlgs.getSortTypeString();
		return sort;
	}
	public int getBound() {
		return steps.size() -1;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		int[] p = steps.get(0);
		return p.length;
	}

	public String getCurrentBoxContent(int i) {
		int res= 0;
		res = getCurrentList()[i];
		return String.valueOf(res);
	}
}
