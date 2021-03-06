package working;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
	private Rectangle[] rects ;
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
		System.out.println(steps.get(0)[0] +" "+ steps.get(0)[1]+" "+ steps.get(0)[2]);
		//this.visualiser = vis;
		this.loop = false;
		this.n = 20;
		this.intID = m;
	}

	public void goBack(){
		if(current > 0){
			current--;
			visualiser.resetRectColor();
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
			}

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
		if(current < steps.size()-1){
			current++;
			visualiser.resetRectColor();
			if (steps.get(current).length!=2){

				int left = steps.get(current-1)[0];
				int right = steps.get(current-1)[1];
				/*
				Text text1 = ((Text)((Pane) 				visualiser.getChildren().get(1)).getChildren().get(10+left));
				Rectangle rect1 = ((Rectangle) ((Pane) 	visualiser.getChildren().get(1)).getChildren().get(0+left));
				Text text2 = ((Text)((Pane) 			visualiser.getChildren().get(1)).getChildren().get(10+right));
				Rectangle rect2 = ((Rectangle) ((Pane) 	visualiser.getChildren().get(1)).getChildren().get(0+right));
				*/
				Text text1 = this.texts[left];
				Text text2 = this.texts[right];
				System.out.println("Tanslate: X= "+ texts[left].getTranslateX()+" Y= "+ texts[left].getTranslateY());
				System.out.println("Layout:   X= "+ texts[left].getLayoutX()+   " Y= "+ texts[left].getLayoutY());
				System.out.println("XY:   X= "+ texts[left].getX()+   " Y= "+ texts[left].getY());
				fixTranslate(rects[left]);
				fixTranslateText(texts[left]);
				System.out.println("Tanslate: X= "+ texts[left].getTranslateX()+" Y= "+ texts[left].getTranslateY());
				System.out.println("Layout:   X= "+ texts[left].getLayoutX()+   " Y= "+ texts[left].getLayoutY());
				System.out.println("XY:   X= "+ texts[left].getX()+   " Y= "+ texts[left].getY());
				Rectangle rect1 = this.rects[left];
				Rectangle rect2 = this.rects[right];
				System.out.println("Left: "+left+" Right: " + right);
				//System.out.println("Before: "+ rects[left].getTranslateX()+" Y= "+ rects[left].getTranslateY());
				//System.out.println("Before: X= "+ rects[left].getLayoutX()+" Y= "+ rects[left].getLayoutY());
				//System.out.println("Before: X= "+ rects[right].getLayoutX()+" Y= "+ rects[right].getLayoutY());
				visualiser.animationBotRight(rect1, text1,right - left);
				visualiser.animationTopLeft(rect2, text2,right- left);
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
	}
	private void fixTranslate(Rectangle rectangle) {
		double x = rectangle.getTranslateX() + rectangle.getLayoutX();
		double y = rectangle.getTranslateY() + rectangle.getLayoutY();
		System.out.println(x +"  y="+y);
		rectangle.setTranslateX(0);
		rectangle.setTranslateY(0);
		rectangle.relocate(x, y);
	}
	private void fixTranslateText(Text Text) {

		double x = Text.getTranslateX() + Text.getLayoutX()- 12.5;
		double y = Text.getLayoutY() + Text.getTranslateY() -25;
		//Text.setTranslateX(20);
		//Text.setTranslateY(25);
		Text.relocate(x, y);
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
//		System.out.println("swapping "+n1+" to "+n2+".");
		Rectangle swapR1 = this.rects[n1];
		Rectangle swapR2 = this.rects[n2];
//		System.out.println("Before: X= "+ rects[n1].getLayoutX()+" Y= "+ rects[n1].getLayoutY());
//		System.out.println("Before: X= "+ rects[n2].getLayoutX()+" Y= "+ rects[n2].getLayoutY());
//		System.out.println("RECTs: X= "+ swapR1.getLayoutX()+" Y= "+ swapR1.getLayoutY());
//		System.out.println("RECTs: X= "+ swapR2.getLayoutX()+" Y= "+ swapR2.getLayoutY());
		this.rects[n1] = swapR2;
		this.rects[n2] = swapR1;
//		System.out.println("after: X= "+ rects[n1].getLayoutX()+" Y= "+ rects[n1].getLayoutY());
//		System.out.println("after: X= "+ rects[n2].getLayoutX()+" Y= "+ rects[n2].getLayoutY());
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
