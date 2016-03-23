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
	private int n;
	public String type;
	private int intID;
	private Text[] texts;
	private Rectangle[] rects;
	private Timer time;
	private double speed = 1000;
	private boolean playing = false;
	public boolean animating = false;

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
		this.n = 20;
		this.intID = m;
	}

	/**
	 * This method does the back animation.
	 */
	public void goBack() {
		// first update the speed from the slider
		updateSpeed();
		// then enable the play button because we went back
		visualiser.enablePlay();
		// check if the index is the first index
		if (current == 0) {
			// reset the array
			visualiser.resetRectColor();
			// disable the back button
			visualiser.disableBack();
		} // otherwise check if the current is bigger than the first one
		else if (current > 0) {
			// insert information in the log
			visualiser.logAddMsg("--------------------------");
			visualiser.logAddMsg("Step Back");
			visualiser.logAddMsg("Current step: " + (current + 1));
			// reset the colors
			visualiser.resetRectColor();
			// check if the current array is 2 elements long
			if (steps.get(current).length == 2) {
				// get the left and right indexes
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				// get the rectangles at these indexes
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				// fix the translate property of the rectangles and call the
				// animation for comparison on these
				fixTranslate(rect);
				fixTranslate(rect2);
				visualiser.animationComparison(rect, rect2, (int) speed);
				// add the mesage for comparison in the log and in the lable
				visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				// make the current index smaller by one
				current--;
			} // check if the current array is 3 elements long
			else if (steps.get(current).length == 3) {
				// take the 3 indexes
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				int third = steps.get(current)[2];
				// get the rectangles in the first 2 indexes
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				// fix the translate of the rectangles and call the respective
				// animations
				fixTranslate(rect);
				fixTranslate(rect2);
				visualiser.animationComparison(rect, rect2, (int) speed);
				visualiser.changeColor(getRect(third));
				// if the type of the sorting is quick
				if (type.compareTo("Quick") == 0) {
					// add these messages
					visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + "pivot");
					visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + "pivot");
				} else {
					// add these messages
					visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
					visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				}
				// make the current smaller
				current--;
			} // if the length is not 2 or 3 it must be 10 which indicates a
				// change in the array
			else {
				// getting the left and right indexes
				int left = steps.get(current - 1)[0];
				int right = steps.get(current - 1)[1];
				// check if the type is Insertion for the custom animation
				if (type.compareTo("Insertion") == 0) {
					// fix properties of all the rectangles that are going to be
					// moved
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
					// call the animation for all the rectangles
					visualiser.animationleftInsertion(rectlist, textlist, right - left, (int) speed);
					visualiser.animationBotRight(rects[left], texts[left], right - left, (int) speed);
					// change the index for insertion sort
					changeIndexInsertionBack(left, right);
					// add these messages to the log
					visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
					visualiser.screenMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
				} // if the type is not insertion use the normal 2 element
					// animations
				else {
					// fix the properties of the rectangles and the text's
					fixTranslate(rects[left]);
					fixTranslate(rects[right]);
					fixTranslateTextBack(texts[left]);
					fixTranslateTextBack(texts[right]);
					// call the generic 2 element animations
					visualiser.animationBotRight(rects[left], texts[left], right - left, (int) speed);
					visualiser.animationTopLeft(rects[right], texts[right], right - left, (int) speed);
					// change the index for a generic algorithm
					changeIndex(left, right);
					// add the messages to the log
					visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
					visualiser.screenMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
				}
				// go back on the current
				current--;
			}
		}
	}

	/**
	 * This returns the number of the current step.
	 *
	 * @return The number of the current step
	 */
	public int getCurrent() {
		return current;
	}

	/**
	 * This returns the array of the current step.
	 *
	 * @return The array of the current step
	 */
	public int[] getCurrentList() {
		return steps.get(current);
	}

	/**
	 * This method does the forwards animation.
	 */
	public void goForward() {
		// first update the speed from the slider
		updateSpeed();
		// if the current step is not the last one
		if (current == steps.size() - 1) {
			// make the color the sorted color
			visualiser.RectColorSorted();
			// disable the forwards button as this is the last one
			visualiser.disableForward();
		} else if (current < steps.size() - 1) {
			// disable the forwards and back buttons until the animation is
			// complete
			visualiser.disableForward();
			visualiser.disableBack();
			// add the message to the log
			visualiser.logAddMsg("--------------------------");
			visualiser.logAddMsg("Step Forward");
			visualiser.logAddMsg("Current step: " + (current + 1));
			// add one to the current
			current++;
			// reset the colors
			visualiser.resetRectColor();
			// check if the current is 2 elements
			if (steps.get(current).length == 2) {
				// get the left and the right indexes
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				// get the corresponding rectangles
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				// fix their translate property
				fixTranslate(rect);
				fixTranslate(rect2);
				// call the comparison animation on them
				visualiser.animationComparison(rect, rect2, (int) speed);
				// add the messages to the log
				visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
			} // check if the current is 3 elements
			else if (steps.get(current).length == 3) {
				// get the three indexes
				int left = steps.get(current)[0];
				int right = steps.get(current)[1];
				int third = steps.get(current)[2];
				// get the rectangles on the first 2 indexes
				Rectangle rect = getRect(left);
				Rectangle rect2 = getRect(right);
				// fix their translate property
				fixTranslate(rect);
				fixTranslate(rect2);
				// call the animation for comparison
				visualiser.animationComparison(rect, rect2, (int) speed);
				// change the color of the third index rectangle
				visualiser.changeColor(getRect(third));
				// check if the type is quick
				if (type.compareTo("Quick") == 0) {
					// do the custom message for quick
					visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + "pivot" + "("
							+ texts[third].getText() + ")");
					visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + "pivot" + "("
							+ texts[third].getText() + ")");
				} else {
					// do the generic message
					visualiser.logAddMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
					visualiser.screenMsg(" Comparing " + texts[left].getText() + " and " + texts[right].getText());
				}
			} // if the length is not 2 or 3 it must be 10 which indicates a
				// change in the array
			else {
				// getting the left and right indexes
				int left = steps.get(current - 1)[0];
				int right = steps.get(current - 1)[1];
				// if the type is insertion do the custom animation
				if (type.compareTo("Insertion") == 0) {
					// fix properties
					for (int i = 0; i <= right - left; i++) {
						fixTranslate(rects[left + i]);
						fixTranslateText(texts[left + i]);
					}
					// animation
					// group the boxes and texts
					Rectangle[] rectlist = new Rectangle[right - left];
					Text[] textlist = new Text[right - left];
					for (int i = 0; i < right - left; i++) {
						rectlist[i] = rects[left + i];
						textlist[i] = texts[left + i];
					}
					// call the appropriate custom insertion animation
					visualiser.animationRightInsertion(rectlist, textlist, right - left, (int) speed);
					visualiser.animationTopLeft(rects[right], texts[right], right - left, (int) speed);
					// change the indexes for insertion
					changeIndexInsertion(left, right);
					// log the messages
					visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
					visualiser.screenMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
				} // if its not insertion do the generic animation for 2 element
					// swaps
				else {
					// fix the properties of the texts and rectangles
					fixTranslate(rects[left]);
					fixTranslate(rects[right]);
					fixTranslateText(texts[left]);
					fixTranslateText(texts[right]);
					// call the generic animations for 2 elements
					visualiser.animationBotRight(rects[left], texts[left], right - left, (int) speed);
					visualiser.animationTopLeft(rects[right], texts[right], right - left, (int) speed);
					// change the index of the 2 elements
					changeIndex(left, right);
					// log the messages
					visualiser.logAddMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
					visualiser.screenMsg(" Swapping " + texts[right].getText() + " and " + texts[left].getText());
				}
			}
		}
	}

	/**
	 * This fixes the Layout and Translation properties of the rectangle
	 *
	 * @param rectangle
	 *            The rectangle
	 */
	private void fixTranslate(Rectangle rectangle) {
		// get the old translate and layout properties
		double newLayoutX = rectangle.getTranslateX() + rectangle.getLayoutX();
		// set the current translate to 0
		rectangle.setTranslateX(0);
		// set the current layout to the old layout + the old translate
		rectangle.setLayoutX(newLayoutX);
	}

	/**
	 * This fixes the Layout and Translation properties of the text
	 *
	 * @param Text
	 *            The text
	 */
	private void fixTranslateText(Text Text) {
		// get the old translate and layout of the text
		double x = Text.getTranslateX() + Text.getLayoutX();
		// set the old translate to 0
		Text.setTranslateX(0);
		Text.setTranslateY(0);

		if (Text.getText().compareTo("10") == 0) {
			// if the text in the box is 10 fix more
			Text.setLayoutX(x + 6.1);
		} else {
			// if its not then fix this much
			Text.setLayoutX(x + 3.5);
		}
		// set the new layout Y which is a constant
		Text.setLayoutY(77.94921875 - 4.96875);

	}

	/**
	 * This fixes the Layout and Translation properties of the text before the
	 * back animation
	 *
	 * @param Text
	 *            The text
	 */
	private void fixTranslateTextBack(Text Text) {
		// get the old translate and layout of the text
		double x = Text.getTranslateX() + Text.getLayoutX();
		// set the old translate to 0
		Text.setTranslateX(0);
		Text.setTranslateY(0);
		if (Text.getText().compareTo("10") == 0) {
			// if the text in the box is 10 fix more
			Text.setLayoutX(x + 6.7);
		} else {
			// if its not then fix this much
			Text.setLayoutX(x + 3.6);
		}
		// set the new layout Y which is a constant
		Text.setLayoutY(77.94921875 - 4.96875);
	}

	/**
	 * This method stops the timer
	 */
	public void stop() {
		// if the timer exists
		try {
			// stop it
			time.cancel();
			// set the timerON flag to false
			visualiser.timerSet(false);
			// enable the back forward and play buttons
			visualiser.enableBack();
			visualiser.enableForward();
			visualiser.enablePlay();
		} catch (NullPointerException e) {
		}
	}

	/**
	 * This method starts the timer
	 */
	public void play() {
		// stop the timer to make sure of no duplicates
		stop();
		// set the flag timerON to true
		visualiser.timerSet(true);
		// disable the play button
		visualiser.disablePlay();
		// make a new timer
		time = new Timer();
		// Schedule the task
		time.scheduleAtFixedRate((new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					// if this is the the last step
					if (current == steps.size() - 1) {
						// cancel the timer
						this.cancel();
						// set the timerON flag to false
						visualiser.timerSet(false);
						// enable the Back button and disable the stop button
						visualiser.enableBack();
						visualiser.disableStop();
						// go forward one last time
						goForward();
					}
					// if its animating do nothing
					if (animating) {
						// do nothing
					} else {
						// go forward
						goForward();
					}
				});
			}
		}), 0, 100);
		// start immediately and run every 1/10 of a second

	}

	/**
	 * This method sets the visualiser
	 *
	 * @param vis
	 *            The visualiser
	 */
	public void setVis(FXvisualiser vis) {
		// set the visualiser
		this.visualiser = vis;
		// set the number of elements
		int numberEl = getSize();
		// make a new rectangle list
		this.rects = new Rectangle[numberEl];
		// and a new text list
		this.texts = new Text[numberEl];
		// populate the lists with the rectangles from the visualiser
		for (int i = 0; i < numberEl; i++) {
			rects[i] = ((Rectangle) ((Pane) visualiser.getChildren().get(1)).getChildren().get(i));
			texts[i] = ((Text) ((Pane) visualiser.getChildren().get(1)).getChildren().get(i + numberEl));
		}
	}

	/**
	 * Changes the contents of the 2 indexes given
	 *
	 * @param n1
	 *            the first index
	 * @param n2
	 *            the second index
	 */
	public void changeIndex(int n1, int n2) {
		// get the contents of the 2 indexes (rectangles)
		Rectangle swapR1 = this.rects[n1];
		Rectangle swapR2 = this.rects[n2];
		// swap the contents of the 2 indexes (rectangles)
		this.rects[n1] = swapR2;
		this.rects[n2] = swapR1;
		// get the contents of the 2 indexes (texts)
		Text swapT1 = this.texts[n1];
		Text swapT2 = this.texts[n2];
		// swap the contents of the 2 indexes (texts)
		this.texts[n1] = swapT2;
		this.texts[n2] = swapT1;
	}

	/**
	 * Changes the contents of the indexes between the 2 indexes given for
	 * insertion
	 *
	 * @param left
	 *            The left most index
	 * @param right
	 *            The right most index
	 */
	public void changeIndexInsertion(int left, int right) {
		for (int i = right; i > left; i--) {
			// change the current indexes
			changeIndex(i - 1, i);
		}
	}

	/**
	 * Changes the contents of the indexes between the 2 indexes given for
	 * insertion but backwards
	 *
	 * @param left
	 *            The left most index
	 * @param right
	 *            The right most index
	 */
	public void changeIndexInsertionBack(int left, int right) {
		for (int i = left; i < right; i++) {
			// change the current index
			changeIndex(i, i + 1);
		}
	}

	/**
	 * Returns the name of the sort currently selected
	 *
	 * @return The name of the sort
	 */
	public String getSortTypeString() {
		return type;
	}

	/**
	 * This returns the size of the answer
	 *
	 * @return the size of the steps ArrayList
	 */
	public int getBound() {
		return steps.size() - 1;
	}

	/**
	 * Returns the size of the array to be sorted
	 *
	 * @return The size of the array to be sorted
	 */
	public int getSize() {
		int[] p = steps.get(0);
		return p.length;
	}

	/**
	 * This returns the content of the current box (the number)
	 *
	 * @param i
	 *            The index of the box
	 * @return The number in the box
	 */
	public String getCurrentBoxContent(int i) {
		int res = 0;
		res = getCurrentList()[i];
		return String.valueOf(res);
	}

	/**
	 * Returns the rectangle at a given position
	 *
	 * @param n
	 *            The position
	 * @return The rectangle
	 */
	public Rectangle getRect(int n) {
		return this.rects[n];
	}

	/**
	 * Returns the text at a given position
	 *
	 * @param n
	 *            The position
	 * @return The text
	 */
	public Text getText(int n) {
		return this.texts[n];
	}

	/**
	 * Returns the ID of the model
	 *
	 * @return The ID of the model
	 */
	public int getID() {
		return this.intID;
	}

	/**
	 * Updates the speed of the animation
	 */
	public void updateSpeed() {
		// set the speed to the value of the slider multiply it to 1000 and add
		// the minimum speed
		speed = 50 + visualiser.getspeed() * 1000;
	}

	/**
	 * This method sets the flag whether the animation is running or not
	 *
	 * @param b
	 *            The new flag
	 */
	public void setAnimating(boolean b) {
		animating = b;
	}
}
