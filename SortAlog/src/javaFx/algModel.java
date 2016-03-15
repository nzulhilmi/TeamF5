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
			current--;
			visualiser.resetRectColor();/*
			if (steps.get(current).length!=2){
				int right = steps.get(current+1)[0];
				int left = steps.get(current+1)[1];
				Text text = ((Text)((Pane) 				visualiser.getChildren().get(1)).getChildren().get(10+left));
				Rectangle rect = ((Rectangle) ((Pane) 	visualiser.getChildren().get(1)).getChildren().get(0+left));
				Text text2 = ((Text)((Pane) 			visualiser.getChildren().get(1)).getChildren().get(10+right));
				Rectangle rect2 = ((Rectangle) ((Pane) 	visualiser.getChildren().get(1)).getChildren().get(0+right));
				visualiser.animationBotRight(rect, text,right - left);
				visualiser.animationTopLeft(rect2, text2,right- left);
			}else{
				int right = steps.get(current)[0];
				int left = steps.get(current)[1];
				Rectangle rect = ((Rectangle) ((Pane) 	visualiser.getChildren().get(1)).getChildren().get(0+left));
				Rectangle rect2 = ((Rectangle) ((Pane) 	visualiser.getChildren().get(1)).getChildren().get(0+right));
				visualiser.animationComparison(rect, rect2);
			}*/

		}
			//System.out.println(visualiser.getChildren().get(1).toString());
			//((Rectangle) ((Pane) visualiser.getChildren().get(1)).getChildren().get(1)).setFill(Color.BLUE);
			//((Text) ((Pane) visualiser.getChildren().get(1)).getChildren().get(10)).setText("0");
			//visualiser.setCurrentIndex(current);
			//visualiser.forceRepaint();
			/*
			for(int i=10;i<20;i++){
			int a = steps.get(current)[i-10];
			((Text)((Pane) visualiser.getChildren().get(1)).getChildren().get(i)).setText(Integer.toString(a));
			*/
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
		//btnState = true;
		if(current < steps.size()-1){
			current++;
			visualiser.resetRectColor();
			if (steps.get(current).length!=2){
				//getting the left and right indexess
				int left = steps.get(current-1)[0];
				int right = steps.get(current-1)[1];
				System.out.println("Current left: "+left +"  right: "+right);

				//checking the translate layout and X Y properties
				System.out.println("Text Tanslate: X= " 	+ texts[left].getTranslateX()	+ " Y= " 	+ texts[left].getTranslateY());
				System.out.println("Text Layout:   X= " 	+ texts[left].getLayoutX()		+ " Y= " 	+ texts[left].getLayoutY());
				System.out.println("Text right Tanslate: X= " 	+ texts[right].getTranslateX()	+ " Y= " 	+ texts[right].getTranslateY());
				System.out.println("Text right Layout:   X= " 	+ texts[right].getLayoutX()		+ " Y= " 	+ texts[right].getLayoutY());
				//trying to fix them
				fixTranslate(rects[left]);
				fixTranslate(rects[right]);
				fixTranslateText(texts[left]);
				fixTranslateText(texts[right]);
				System.out.println("Text Tanslate: X= " 	+ texts[left].getTranslateX()	+ " Y= " 	+ texts[left].getTranslateY());
				System.out.println("Text Layout:   X= " 	+ texts[left].getLayoutX()		+ " Y= " 	+ texts[left].getLayoutY());
				System.out.println("Text right Tanslate: X= " 	+ texts[right].getTranslateX()	+ " Y= " 	+ texts[right].getTranslateY());
				System.out.println("Text right Layout:   X= " 	+ texts[right].getLayoutX()		+ " Y= " 	+ texts[right].getLayoutY());
				//checking if the fix worked
//				System.out.println("Tanslate: X= "+ texts[left].getTranslateX()+" Y= "+ texts[left].getTranslateY());
//				System.out.println("Layout:   X= "+ texts[left].getLayoutX()+   " Y= "+ texts[left].getLayoutY());
//				System.out.println("XY:   X= "+ texts[left].getX()+   " Y= "+ texts[left].getY());

				//System.out.println("Before: "+ rects[left].getTranslateX()+" Y= "+ rects[left].getTranslateY());
				//System.out.println("Before: X= "+ rects[left].getLayoutX()+" Y= "+ rects[left].getLayoutY());
				//System.out.println("Before: X= "+ rects[right].getLayoutX()+" Y= "+ rects[right].getLayoutY());
				visualiser.animationBotRight(rects[left], texts[left],right - left);
				visualiser.animationTopLeft(rects[right], texts[right],right- left);
				//fixTranslate(rects[left]);
				//fixTranslateText(texts[left]);
				changeIndex(left, right);
//				ObservableList<Node> workingCollection = ((Pane) (visualiser.getChildren().get(1))).getChildren();
//				((Pane) (visualiser.getChildren().get(1))).getChildren().removeAll(workingCollection);
//				Collections.swap(workingCollection, 0, 1);
//				((Pane) (visualiser.getChildren().get(1))).getChildren().setAll(workingCollection);
				//Collections.swap(((Pane) (visualiser.getChildren().get(1))).getChildren(), left, right);
				//Collections.swap(((Pane) (visualiser.getChildren().get(1))).getChildren(), left+10, right+10);
			}else{
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				visualiser.animationComparison(rect, rect2);
			}

			/*
			for(int i=10;i<20;i++){
				int a = steps.get(current)[i-10];
				((Text) ((Pane) visualiser.getChildren().get(1)).getChildren().get(i)).setText(Integer.toString(a));
			}*/

			//visualiser.setCurrentIndex(current);
			//visualiser.forceRepaint();
			}
		//System.out.println("Current step: "+ (current+1));
		//btnState = false;
	}
	private void fixTranslate(Rectangle rectangle) {
		double newLayoutX = rectangle.getTranslateX() + rectangle.getLayoutX();
		//double newLayoutY = rectangle.getTranslateY() + rectangle.getLayoutY();
		//System.out.println("old translate x: "+rectangle.getLayoutX() );
		rectangle.setTranslateX(0);
		//rectangle.setTranslateY(0);
		rectangle.setLayoutX(newLayoutX);
		//rectangle.setLayoutY(newLayoutY);
		//rectangle.relocate(x, y);
		//System.out.println("new translate x: "+rectangle.getLayoutX() );
	}
	private void fixTranslateText(Text Text) {
		System.out.println("Text xT: "+Text.getTranslateX() +"yT:"+Text.getTranslateY());
		System.out.println("Text xL: "+Text.getLayoutX() +"yL:"+Text.getLayoutY());
		double x = Text.getTranslateX() + Text.getLayoutX();// -13.53125;
		//double y = Text.getTranslateY() + Text.getLayoutY();
		Text.setTranslateX(0);
		Text.setTranslateY(0);
		//Text.setTranslateY(0);
		Text.setLayoutX(x);
		//Text.setLayoutY(77.949221875);
		System.out.println("Text xL: "+Text.getLayoutX() +"yL:"+Text.getLayoutY());

		//Text.setLayoutY(y);
		//Text.relocate(x, y);
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
