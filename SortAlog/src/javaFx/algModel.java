package javaFx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import javafx.scene.shape.Rectangle;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import swing.sortingAlgs;
import swing.visualiser;
/**
 * The .....
 * @author Kiril N. Elliott Upton
 *
 */
public class algModel extends Observable{
	private int current;
	private ArrayList<int[]> steps;
	private FXvisualiser visualiser;
	private boolean loop;
	private int n;
	public String type;
	private int intID;
	private Text[] texts;
	private Rectangle[] rects;
	//private Boolean btnState =false;
	/**
	 * Instantiates a new algorithm model.
	 *
	 * @param steps the steps
	 * @param vis the visualizer
	 */
	public algModel(int[] input, String type, int m) {
		super();
		SortAlgos alg = new SortAlgos(type, input);
		this.type = type;
		this.current = 0;
		this.steps = alg.getSortedList();

		System.out.println( +steps.get(0)[0] +" "+ steps.get(0)[1]+" "+ steps.get(0)[2]);
		//this.visualiser = vis;
		this.loop = false;
		this.n = 20;
		this.intID = m;
	}

	public void goBack(){
		if(current > 0){
			//current--;
			visualiser.resetRectColor();
			if (steps.get(current).length!=2){
				current--;
				//getting the left and right indexes
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				//fix properties
				fixTranslate(rects[left]);
				fixTranslate(rects[right]);
				fixTranslateText(texts[left]);
				fixTranslateText(texts[right]);
				//animation
				visualiser.animationBotRight(rects[left], texts[left],right - left);
				visualiser.animationTopLeft(rects[right], texts[right],right- left);
				//change the index
				changeIndex(left, right);
			}else{
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				visualiser.animationComparison(rect, rect2);
				current--;
			}

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
			visualiser.resetRectColor();
			if (steps.get(current).length!=2){
				//getting the left and right indexes
				int left = steps.get(current-1)[0];
				int right = steps.get(current-1)[1];
				//fix properties
				fixTranslate(rects[left]);
				fixTranslate(rects[right]);
				fixTranslateText(texts[left]);
				fixTranslateText(texts[right]);
				//animation
				visualiser.animationBotRight(rects[left], texts[left],right - left);
				visualiser.animationTopLeft(rects[right], texts[right],right- left);
				//change the index
				changeIndex(left, right);

			}else{
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				visualiser.animationComparison(rect, rect2);
			}
		}
		System.out.println("Current step: "+ (current+1));
	}
	private void fixTranslate(Rectangle rectangle) {
		double newLayoutX = rectangle.getTranslateX() + rectangle.getLayoutX();
		rectangle.setTranslateX(0);
		rectangle.setLayoutX(newLayoutX);
	}
	private void fixTranslateText(Text Text) {
		double x = Text.getTranslateX() + Text.getLayoutX();// -13.53125;
		Text.setTranslateX(0);
		Text.setTranslateY(0);
		if(Text.getText().compareTo("10")==0){
			Text.setLayoutX(x+6);
		}else{
			Text.setLayoutX(x +3.5);
		}

		Text.setLayoutY(77.94921875-4.96875);
		System.out.println("Text xL: "+Text.getLayoutX() +"yL:"+Text.getLayoutY());

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
		int numberEl = getSize();
		this.rects = new Rectangle[numberEl];
		this.texts = new Text[numberEl];
		for(int i=0;i<numberEl;i++){
			rects[i] = ((Rectangle) ((Pane) visualiser.getChildren().get(1)).getChildren().get(i));
			texts[i] = ((Text) ((Pane) visualiser.getChildren().get(1)).getChildren().get(i+numberEl));
		}
	}
	public void changeIndex(int n1, int n2) {
		Rectangle swapR1 = this.rects[n1];
		Rectangle swapR2 = this.rects[n2];
		this.rects[n1] = swapR2;
		this.rects[n2] = swapR1;
		Text swapT1 = this.texts[n1];
		Text swapT2 = this.texts[n2];
		this.texts[n1] = swapT2;
		this.texts[n2] = swapT1;
	}

	public String getSortTypeString() {
		//String sort = sortingAlgs.getSortTypeString();
		return type;
	}
	public int getBound() {
		return steps.size() -1;
	}
	public int getSize() {
		int[] p = steps.get(0);
		return p.length;
	}

	public String getCurrentBoxContent(int i) {
		int res= 0;
		res = getCurrentList()[i];
		return String.valueOf(res);
	}
	public Rectangle getRect(int n) {
		return this.rects[n];
	}
	public Text getText(int n) {
		return this.texts[n];
	}
	public int getID() {
		return this.intID;
	}

}
