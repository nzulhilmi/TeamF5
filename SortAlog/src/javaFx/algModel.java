package javaFx;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * This class is used as a central base for each unique visualisation to be built from.
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
	private Timer time;
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
		visualiser.logAddMsg("--------------------------");
		visualiser.logAddMsg("Step backwards");
		if(current > 0){
			//current--;
			visualiser.resetRectColor();
			if (steps.get(current).length!=2){
				current--;
				visualiser.logAddMsg("Current step: "+ (current+1));
				//getting the left and right indexes
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				//fix properties
				fixTranslate(rects[left]);
				fixTranslate(rects[right]);
				fixTranslateTextBack(texts[left]);
				fixTranslateTextBack(texts[right]);
				//animation
				visualiser.animationBotRight(rects[left], texts[left],right - left,200);
				visualiser.animationTopLeft(rects[right], texts[right],right- left,200);
				//change the index
				changeIndex(left, right);
				visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
			}else{
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				visualiser.animationComparison(rect, rect2);
				current--;
				visualiser.logAddMsg("Current step: "+ (current+1));
				visualiser.logAddMsg(" Comparing " + texts[left].getText() + " with " + texts[right].getText());
			}

		}

//		System.out.println("Current step: "+ (current+1));
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
		visualiser.logAddMsg("--------------------------");
		visualiser.logAddMsg("Step Forward");
		visualiser.logAddMsg("Current step: "+ (current+1));
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
				visualiser.animationBotRight(rects[left], texts[left], right - left,200);
//				Rectangle[] rectlist = new Rectangle[right-left];
//				Text[] textlist = new Text[right-left];
//				for (int i = 0; i < right-left; i++) {
//					rectlist[i] = rects[left+i];
//					textlist[i] = texts[left+i];
//				}

				//visualiser.animationTopInsertion(rects[right], rectlist, texts[right], textlist, right-left, 2000);
				visualiser.animationTopLeft(rects[right], texts[right], right - left,200);
				//change the index
				changeIndex(left, right);
				visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
				visualiser.screenMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
			}else{
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				visualiser.animationComparison(rect, rect2);
				visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
			}
		}

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
			Text.setLayoutX(x+6.1);
		}else{
			Text.setLayoutX(x +3.5);
		}

		Text.setLayoutY(77.94921875-4.96875);

	}
	private void fixTranslateTextBack(Text Text) {
		double x = Text.getTranslateX() + Text.getLayoutX();// -13.53125;
		Text.setTranslateX(0);
		Text.setTranslateY(0);
		if(Text.getText().compareTo("10")==0){
			Text.setLayoutX(x+6.7);
		}else{
			Text.setLayoutX(x +3.6);
		}

		Text.setLayoutY(77.94921875-4.96875);

	}


	public void stop(){
		try{
			time.cancel();
			System.out.println("stop");
		}catch (NullPointerException e){
			System.out.println("Nothing to stop");
		}
		//this.loop = false;
		//System.err.println("pause the annimation");
	}

	public void play(){
		//
		System.out.println("Timer start");
		time = new Timer();
		time.scheduleAtFixedRate((new TimerTask(){
			@Override
			public void run(){
				System.out.println("Timer exec");
				  Platform.runLater(() -> {
					  goForward();
				  });
			}
		}), 500, 2000);
//			while(this.loop==true){
//
//				if(current < steps.size()-1){
//					current++;
//					vis.setCurrentIndex(current);
//					vis.forceRepaint();
//				}else{
//					this.loop = false;
//				}
//				System.out.println("working");
//			}
//
//		System.out.println("end");
//		public void moveCircle(Circle circle, Scene scene) {
//		    Timer timer = new Timer();
//		    timer.scheduleAtFixedRate(new TimerTask() {
//		        @Override
//		        public void run() {
//		            Platform.runLater(() -> {
//		                circle.setCenterX(random((int) scene.getX()));
//		                circle.setCenterY(random((int) scene.getY()));
//		            });
//		        }
//		    }, 1000, 1000);
//		}
	}

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
