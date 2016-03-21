package javaFx;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * This class is used as a central base for each unique visualisation to be
 * built from.
 *
 * @author Kiril N. Elliott Upton
 *
 */
public class algModel extends Observable {
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
	private double speed = 1000;
	private boolean playing = false;

	// private Boolean btnState =false;
	/**
	 * Instantiates a new algorithm model.
	 *
	 * @param steps
	 *            the steps
	 * @param vis
	 *            the visualizer
	 */
	public algModel(int[] input, String type, int m) {
		super();
		SortAlgos alg = new SortAlgos(type, input);
		this.type = type;
		this.current = 0;
		this.steps = alg.getSortedList();

		System.out.println(+steps.get(0)[0] + " " + steps.get(0)[1] + " " + steps.get(0)[2]);
		// this.visualiser = vis;
		this.loop = false;
		this.n = 20;
		this.intID = m;

		// System.err.println(speed);
	}
	/**
	 * This method implements the backwards animation when the backwards button is clicked.
	 */
	public void goBack() {
		updateSpeed();
		// System.out.println(speed);
		// if(type.compareTo("Insertion")==0){
		visualiser.enablePlay();
		if (current == 0) {
			visualiser.resetRectColor();
			//visualiser.enableForward();
			visualiser.disableBack();
		} else if (current > 0) {
			// log the step
			visualiser.logAddMsg("--------------------------");
			visualiser.logAddMsg("Step Back");
			visualiser.logAddMsg("Current step: " + (current + 1));
			// current--;
			// reset the colours
			visualiser.resetRectColor();
			// check if the current is 2 or 3 elements
			if (steps.get(current).length == 2) {

				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				visualiser.animationComparison(rect, rect2, (int) speed);
				fixTranslate(rect);
				fixTranslate(rect2);
				visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				current--;
			} else if (steps.get(current).length == 3) {

				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				int third = steps.get(current)[2];
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				visualiser.animationComparison(rect, rect2, (int) speed);
				fixTranslate(rect);
				fixTranslate(rect2);
				visualiser.changeColor(getRect(third));
				if (type.compareTo("Quick") == 0) {
					visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + "pivot");
					visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + "pivot");
				} else {
					visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
					visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				}
				current--;
			} else {

				// getting the left and right indexes
				int left = steps.get(current - 1)[0];
				int right = steps.get(current - 1)[1];
				if (type.compareTo("Insertion") == 0) {
					// fix properties
					for (int i = 0; i <= right - left; i++) {
						fixTranslate(rects[left + i]);
						fixTranslateTextBack(texts[left + i]);
					}
					// animation
					// group the boxes/texts
					Rectangle[] rectlist = new Rectangle[right - left];
					Text[] textlist = new Text[right - left];
					for (int i = 0; i < right - left; i++) {
						rectlist[i] = rects[left + 1 + i];
						textlist[i] = texts[left + 1 + i];
					}
					visualiser.animationleftInsertion(rectlist, textlist, right - left, (int) speed);
					visualiser.animationBotRight(rects[left], texts[left], right - left, (int) speed);
					// change the index
					changeIndexInsertionBack(left, right);
					visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
					visualiser.screenMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
				} else {

					// fix properties
					fixTranslate(rects[left]);
					fixTranslate(rects[right]);
					fixTranslateTextBack(texts[left]);
					fixTranslateTextBack(texts[right]);
					// animation
					visualiser.animationBotRight(rects[left], texts[left], right - left, (int) speed);
					visualiser.animationTopLeft(rects[right], texts[right], right - left, (int) speed);
					// change the index
					changeIndex(left, right);
					visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
					visualiser.screenMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
				}
				current--;
			}
		}
		// System.out.println("Current step: "+ (current+1));
	}
	
	/**
	 * This returns the number of the current step.
	 * @return The number of the current step
	 */
	public int getCurrent() {
		return current;
	}
	
	/**
	 * This returns the array of the current step.
	 * @return The array of the current step
	 */
	public int[] getCurrentList() {
		return steps.get(current);
	}

	/**
	 * This method implements the forwards animation when the forward button is clicked.
	 */
	public void goForward() {
		updateSpeed();
		// System.out.println(speed);
		// if(type.compareTo("Insertion")==0){
		if (current == steps.size() - 1) {
			visualiser.resetRectColor();
			visualiser.disableForward();
			//visualiser.enableBack();
		} else if (current < steps.size() - 1) {
			// log the step
			visualiser.disableForward();
			visualiser.disableBack();
			visualiser.logAddMsg("--------------------------");
			visualiser.logAddMsg("Step Forward");
			visualiser.logAddMsg("Current step: " + (current + 1));
			current++;
			// reset the colours
			visualiser.resetRectColor();
			// check if the current is 2 or 3 elements
			if (steps.get(current).length == 2) {

				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				visualiser.animationComparison(rect, rect2, (int) speed);
				fixTranslate(rect);
				fixTranslate(rect2);
				visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
			} else if (steps.get(current).length == 3) {
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				int third = steps.get(current)[2];
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				visualiser.animationComparison(rect, rect2, (int) speed);
				fixTranslate(rect);
				fixTranslate(rect2);
				visualiser.changeColor(getRect(third));
				if (type.compareTo("Quick") == 0) {
					visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + "pivot" + "("
							+ texts[third].getText() + ")");
					visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + "pivot" + "("
							+ texts[third].getText() + ")");
				} else {
					visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
					visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				}
			} else {
				// getting the left and right indexes
				int left = steps.get(current - 1)[0];
				int right = steps.get(current - 1)[1];
				if (type.compareTo("Insertion") == 0) {
					// fix properties
					for (int i = 0; i <= right - left; i++) {
						fixTranslate(rects[left + i]);
						fixTranslateText(texts[left + i]);
					}
					// animation
					// group the boxes/texts
					Rectangle[] rectlist = new Rectangle[right - left];
					Text[] textlist = new Text[right - left];
					for (int i = 0; i < right - left; i++) {
						rectlist[i] = rects[left + i];
						textlist[i] = texts[left + i];
					}
					visualiser.animationRightInsertion(rectlist, textlist, right - left, (int) speed);
					visualiser.animationTopLeft(rects[right], texts[right], right - left, (int) speed);
					// change the index
					changeIndexInsertion(left, right);
					visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
					visualiser.screenMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
				} else {
					// fix properties
					fixTranslate(rects[left]);
					fixTranslate(rects[right]);
					fixTranslateText(texts[left]);
					fixTranslateText(texts[right]);
					// animation
					visualiser.animationBotRight(rects[left], texts[left], right - left, (int) speed);
					visualiser.animationTopLeft(rects[right], texts[right], right - left, (int) speed);
					// change the index
					changeIndex(left, right);
					visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
					visualiser.screenMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
				}
			}
		}
	}

	/**
	 * This fixes the translation of the rectangle
	 * @param rectangle The rectangle
	 */
	private void fixTranslate(Rectangle rectangle) {
		double newLayoutX = rectangle.getTranslateX() + rectangle.getLayoutX();
		rectangle.setTranslateX(0);
		rectangle.setLayoutX(newLayoutX);
	}

	/**
	 * This fixes the text in the translated rectangle
	 * @param Text The text in the translated rectangle
	 */
	private void fixTranslateText(Text Text) {
		double x = Text.getTranslateX() + Text.getLayoutX();// -13.53125;
		Text.setTranslateX(0);
		Text.setTranslateY(0);
		if (Text.getText().compareTo("10") == 0) {
			Text.setLayoutX(x + 6.1);
		} else {
			Text.setLayoutX(x + 3.5);
		}

		Text.setLayoutY(77.94921875 - 4.96875);

	}

	/**
	 * This fixes the text in the backwards translation of the rectangle
	 * @param Text The text in the translated rectangle
	 */
	private void fixTranslateTextBack(Text Text) {
		double x = Text.getTranslateX() + Text.getLayoutX();// -13.53125;
		Text.setTranslateX(0);
		Text.setTranslateY(0);
		if (Text.getText().compareTo("10") == 0) {
			Text.setLayoutX(x + 6.7);
		} else {
			Text.setLayoutX(x + 3.6);
		}

		Text.setLayoutY(77.94921875 - 4.96875);

	}

	/**
	 * This method implements the stop functionality over the animation called by the Stop button.
	 */
	public void stop() {
		try {
			time.cancel();
			visualiser.timerSet(false);
			visualiser.enableBack();
			visualiser.enableForward();
			visualiser.enablePlay();
			System.out.println("stop");
		} catch (NullPointerException e) {
			System.out.println("Nothing to stop");
		}
		// this.loop = false;
		// System.err.println("pause the annimation");
	}

	/**
	 * This method implements the play functionality over the animation called by the Play button
	 */
	public void play() {
		System.out.println("Timer start");
		stop();
		// if(!playing){
		// updateSpeed();
		visualiser.timerSet(true);
		visualiser.disablePlay();
		time = new Timer();
		time.scheduleAtFixedRate((new TimerTask() {
			@Override
			public void run() {
				// System.out.println("Timer exec");
				Platform.runLater(() -> {
					if(current==steps.size()-1){
						this.cancel();
						visualiser.timerSet(false);
						visualiser.enableBack();
						visualiser.disableStop();
						//System.out.println("last");
					}
					if (animating) {
						// do nothing
					} else {

						goForward();
					}
				});
			}
		}), 0, 100);

	}

	// while(this.loop==true){
	//
	// if(current < steps.size()-1){
	// current++;
	// vis.setCurrentIndex(current);
	// vis.forceRepaint();
	// }else{
	// this.loop = false;
	// }
	// System.out.println("working");
	// }
	//
	// System.out.println("end");
	// public void moveCircle(Circle circle, Scene scene) {
	// Timer timer = new Timer();
	// timer.scheduleAtFixedRate(new TimerTask() {
	// @Override
	// public void run() {
	// Platform.runLater(() -> {
	// circle.setCenterX(random((int) scene.getX()));
	// circle.setCenterY(random((int) scene.getY()));
	// });
	// }
	// }, 1000, 1000);
	// }

	/**
	 * This method sets the visualiser
	 * @param vis The visualiser
	 */
	public void setVis(FXvisualiser vis) {
		this.visualiser = vis;
		int numberEl = getSize();
		this.rects = new Rectangle[numberEl];
		this.texts = new Text[numberEl];
		for (int i = 0; i < numberEl; i++) {
			rects[i] = ((Rectangle) ((Pane) visualiser.getChildren().get(1)).getChildren().get(i));
			texts[i] = ((Text) ((Pane) visualiser.getChildren().get(1)).getChildren().get(i + numberEl));
		}
	}

	/**
	 * Changes the indexes of the two elements that have been swapped
	 * @param n1 Index of the first element
	 * @param n2 Index of the second element
	 */
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

	/**
	 * This changes the indexes of all the elements that have to be moved during the Insertion algorithm
	 * @param left The left most element
	 * @param right The right most element
	 */
	public void changeIndexInsertion(int left, int right) {
		for (int i = right; i > left; i--) {
			changeIndex(i - 1, i);
		}
	}

	/**
	 * This changes the indexes of all the elements that have to be moved during the Insertion algorithm
	 * for the backwards animation
	 * @param left
	 * @param right
	 */
	public void changeIndexInsertionBack(int left, int right) {
		for (int i = left; i < right; i++) {
			changeIndex(i, i + 1);
		}
	}

	/**
	 * Returns the name of the sort currently selected
	 * @return The name of the sort
	 */
	public String getSortTypeString() {
		// String sort = sortingAlgs.getSortTypeString();
		return type;
	}

	/**
	 * This returns the end of the array of steps
	 * @return The end of the array of steps
	 */
	public int getBound() {
		return steps.size() - 1;
	}

	/**
	 * This returns the size of the array to be sorted
	 * @return The size of the array to be sorted
	 */
	public int getSize() {
		int[] p = steps.get(0);
		return p.length;
	}

	/**
	 * This returns the content of the current box (the number)
	 * @param i The index of the box
	 * @return The value/number in the box 
	 */
	public String getCurrentBoxContent(int i) {
		int res = 0;
		res = getCurrentList()[i];
		return String.valueOf(res);
	}

	/**
	 * This returns the rectangle at a given position
	 * @param n The position
	 * @return The rectangle
	 */
	public Rectangle getRect(int n) {
		return this.rects[n];
	}

	/**
	 * This returns the text at a given position
	 * @param n The position
	 * @return The text
	 */
	public Text getText(int n) {
		return this.texts[n];
	}

	/**
	 * Returns the ID of the model
	 * @return The ID of the model
	 */
	public int getID() {
		return this.intID;
	}

	/**
	 * This updates the speed of the animation
	 */	
	public void updateSpeed() {
		speed = 50 + visualiser.getspeed() * 1000 ;
	}

	public boolean animating = false;

	/**
	 * This method sets the flag whether the animation is running or not
	 * @param b The new flag
	 */
	public void setAnimating(boolean b) {
		// TODO Auto-generated method stub
		animating = b;
	}
}
