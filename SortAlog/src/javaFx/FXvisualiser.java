package javaFx;

import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * this class is where the visualisation panels will be made Each sort is made
 * in a new panel.
 *
 * @author Kiril N., ElliottUpton
 */
public class FXvisualiser extends BorderPane {

	/** The model. */
	algModel model;

	/** The rectangle list. */
	private Rectangle[] rectList;

	/** The text list. */
	private Text[] textList;

	/** The number of boxes. */
	private int numBoxes;

	/** The pane. */
	private Pane pane;

	/** The timer on. */
	private boolean timerON = false;

	/** The log text. */
	private TextArea logText = new TextArea();

	/** The screen msg. */
	private Label screenMsg = new Label("");

	/** The controls. */
	private FXcontrolPane controls;

	/** The speed. */
	private double speed;

	/**
	 * Instantiates a new visualiser.
	 *
	 * @param model
	 *            the model
	 * @param n
	 *            the ID number
	 */
	public FXvisualiser(algModel model, int n) {
		// set the model
		this.model = model;
		// set the number of boxes
		this.numBoxes = model.getSize();
		// set the minimum size of the instance
		this.setMinSize(580, 250);
		// create a new border pane
		BorderPane bottomLayout = new BorderPane();
		// create a new text pane with the name of the sort
		Text panetitle = new Text(model.getSortTypeString() + " Sort");
		// set the styling
		panetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		screenMsg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		// set the pane
		this.pane = new Pane();
		// set the background style
		this.setStyle("-fx-background-color: WHITE;");
		// get the ID
		String stringID = Integer.toString(n);
		// set the ID
		this.setId(stringID);
		// create new lists of boxes and text's
		rectList = new Rectangle[this.numBoxes];
		textList = new Text[numBoxes];
		// populate the boxes and texts list
		for (int i = 0; i < numBoxes; i++) {
			// new rectangle with size 40 by 40 and color orange
			rectList[i] = new Rectangle(40, 40, Color.ORANGE);
			// arched corners
			rectList[i].setArcHeight(15);
			rectList[i].setArcWidth(15);
			// set border black
			rectList[i].setStroke(Color.BLACK);
			// set the location of the rectangle
			rectList[i].relocate(50 + (50 * i), 50);
			// make the text
			textList[i] = new Text(model.getCurrentBoxContent(i));
			// set the location of the text
			textList[i].relocate(65 + (50 * i), 65);
		}
		// set all the children of the pane to nothing
		pane.getChildren().setAll();
		// add the rectangle list to the pane
		pane.getChildren().addAll(rectList);
		// add the text's to the pane
		pane.getChildren().addAll(textList);
		// set the minimum width to 500
		pane.setMinWidth(500);
		// make a new control pane and set it
		controls = new FXcontrolPane(model, logText);
		// get the initial speed
		speed = controls.getSpeed();
		// make the show/hide log buttons
		Button closeLog = new Button("Hide log");
		Button log = new Button("Show log");
		// set their properties
		log.setOnAction(e -> {
			// add message to the log
			logAddMsg("--------------------------");
			logAddMsg("The log will show a written representation of the animation");
			// set properties
			logText.setMinSize(200, 100);
			logText.setPrefSize(200, 100);
			logText.setWrapText(true);
			logText.setStyle("-fx-background-color: transparent");
			this.setMinWidth(780);
			this.setRight(logText);
			bottomLayout.setRight(closeLog);
		});
		closeLog.setOnAction(e -> {
			// hide the log
			this.setRight(null);
			// set properties
			this.setMinWidth(580);
			bottomLayout.setRight(log);
		});
		// set alignment of the border pane
		BorderPane.setAlignment(log, Pos.CENTER_RIGHT);
		BorderPane.setAlignment(closeLog, Pos.CENTER_RIGHT);
		BorderPane.setAlignment(screenMsg, Pos.TOP_CENTER);
		// set out the pane
		bottomLayout.setTop(screenMsg);
		bottomLayout.setLeft(controls);
		bottomLayout.setRight(log);
		// set the title pane and layout
		this.setTop(panetitle);
		this.setCenter(pane);
		this.setBottom(bottomLayout);

	}

	/**
	 * The animation that goes down right and then up.
	 *
	 * @param rect
	 *            the Rectangle that will be animated
	 * @param text
	 *            the text that will be animated
	 * @param n
	 *            the number of box lengths that it needs to move
	 * @param speed
	 *            the speed
	 */
	public void animationBotRight(Rectangle rect, Text text, int n, int speed) {
		// make a new path
		Path path = new Path();
		// put elements of the path in it
		path.getElements().add(new MoveTo(20, 20));
		path.getElements().add(new LineTo(20, 70));
		path.getElements().add(new ArcTo(300, 50, 0, 20 + 50 * n, 70, false, false));
		path.getElements().add(new LineTo(20 + 50 * n, 20));
		// make a new path
		Path path2 = new Path();
		// put elements of the path in it
		path2.getElements().add(new MoveTo(0, 0));
		path2.getElements().add(new LineTo(0, 50));
		path2.getElements().add(new ArcTo(300, 50, 0, 50 * n, 50, false, false));
		LineTo testing = new LineTo(50 * n, 0);
		path2.getElements().add(testing);
		// new transitions and duration
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(speed));
		PathTransition pathTransition2 = new PathTransition();
		pathTransition2.setDuration(Duration.millis(speed));
		// set the paths and the elements
		pathTransition.setPath(path);
		pathTransition2.setPath(path2);
		pathTransition.setNode(rect);
		pathTransition2.setNode(text);
		// play the animation
		pathTransition.play();
		pathTransition2.play();
		// on finish enable buttons depending on the timer:
		pathTransition.setOnFinished(e -> {
			if (timerON) {
			} else {
				controls.enableBack();
				controls.enableForward();
				controls.enablePlay();
			}
		});
		pathTransition2.setOnFinished(e -> {
			if (timerON) {
			} else {
				controls.enableBack();
				controls.enableForward();
				controls.enablePlay();
			}
		});

	}

	/**
	 * The animation that goes up, left and then down.
	 *
	 * @param rect
	 *            the Rectangle that will be animated
	 * @param text
	 *            the text that will be animated
	 * @param n
	 *            the number of box lengths that it needs to move
	 * @param speed
	 *            the speed
	 */
	public void animationTopLeft(Rectangle rect, Text text, int n, int speed) {
		// make a new path
		Path path = new Path();
		// put elements of the path in it
		path.getElements().add(new MoveTo(20, 20));
		path.getElements().add(new LineTo(20, -30));
		path.getElements().add(new ArcTo(300, 50, 0, 20 - 50 * n, -30, false, false));
		path.getElements().add(new LineTo(20 - 50 * n, 20));
		// make a new path
		Path path2 = new Path();
		// put elements of the path in it
		path2.getElements().add(new MoveTo(0, 0));
		path2.getElements().add(new LineTo(0, -50));
		path2.getElements().add(new ArcTo(300, 50, 0, -50 * n, -50, false, false));
		path2.getElements().add(new LineTo(-50 * n, 0));
		// new transitions and duration
		model.setAnimating(true);
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(speed));
		PathTransition pathTransition2 = new PathTransition();
		pathTransition2.setDuration(Duration.millis(speed));
		// set the paths and the elements
		pathTransition.setPath(path);
		pathTransition2.setPath(path2);
		pathTransition.setNode(rect);
		pathTransition2.setNode(text);
		// play the animation
		pathTransition.play();
		pathTransition2.play();
		// on finish enable buttons depending on the timer:
		pathTransition.setOnFinished(e -> {
			if (timerON) {
			} else {
				controls.enableBack();
				controls.enableForward();
				controls.enablePlay();
			}
			model.setAnimating(false);
		});
		pathTransition2.setOnFinished(e -> {
			if (timerON) {
			} else {
				controls.enableBack();
				controls.enableForward();
				controls.enablePlay();
			}
			model.setAnimating(false);
		});

	}

	/**
	 * The custom animation for insertion sort
	 *
	 * @param rects
	 *            the Rectangles that will be animated
	 * @param texts
	 *            the texts that will be animated
	 * @param n
	 *            the number of box lengths that they need to move
	 * @param speed
	 *            the speed
	 */
	public void animationRightInsertion(Rectangle[] rects, Text[] texts, int n, int speed) {
		// for every element move to the right 1 slot
		for (int i = 0; i < texts.length; i++) {
			animationRight(rects[i], texts[i], speed);
		}

	}

	/**
	 * The custom animation for insertion sort backwards
	 *
	 * @param rects
	 *            the Rectangles that will be animated
	 * @param texts
	 *            the texts that will be animated
	 * @param n
	 *            the number of box lengths that they need to move
	 * @param speed
	 *            the speed
	 */
	public void animationleftInsertion(Rectangle[] rects, Text[] texts, int n, int speed) {
		// for every element move to the left 1 slot
		for (int i = 0; i < texts.length; i++) {
			animationLeft(rects[i], texts[i], speed);
		}

	}

	/**
	 * Animation that moves one slot to the left.
	 *
	 * @param rect
	 *            the rectangle that will be animated
	 * @param text
	 *            the text that will be animated
	 * @param speed
	 *            the speed
	 */
	public void animationLeft(Rectangle rect, Text text, int speed) {
		// make a new path
		Path path = new Path();
		// add the initial position
		path.getElements().add(new MoveTo(20, 20));
		// add a line to 50px left
		path.getElements().add(new LineTo(20 - 50, 20));
		// make a new path for the text
		Path pathText = new Path();
		// add the initial position
		pathText.getElements().add(new MoveTo(0, 0));
		// add a line to 50 px left
		pathText.getElements().add(new LineTo(-50, 0));
		// new transitions and duration
		PathTransition pathTransition = new PathTransition();
		PathTransition pathTransitionText = new PathTransition();
		pathTransition.setDuration(Duration.millis(speed));
		pathTransitionText.setDuration(Duration.millis(speed));
		// set the paths and the elements
		pathTransition.setPath(path);
		pathTransitionText.setPath(pathText);
		pathTransition.setNode(rect);
		pathTransitionText.setNode(text);
		// play the animations
		pathTransition.play();
		pathTransitionText.play();
	}

	/**
	 * Animation that moves one slot to the right.
	 *
	 * @param rect
	 *            the rectangle that will be animated
	 * @param text
	 *            the text that will be animated
	 * @param speed
	 *            the speed
	 */
	public void animationRight(Rectangle rect, Text text, int speed) {
		// make a new path
		Path path = new Path();
		// add the initial position
		path.getElements().add(new MoveTo(20, 20));
		// add a line to 50px right
		path.getElements().add(new LineTo(20 + 50, 20));
		// make a new path for the text
		Path pathText = new Path();
		// add the initial position
		pathText.getElements().add(new MoveTo(0, 0));
		// add a line to 50 px right
		pathText.getElements().add(new LineTo(50, 0));
		// new transitions and duration
		PathTransition pathTransition = new PathTransition();
		PathTransition pathTransitionText = new PathTransition();
		pathTransition.setDuration(Duration.millis(speed));
		pathTransitionText.setDuration(Duration.millis(speed));
		// set the paths and the elements
		pathTransition.setPath(path);
		pathTransitionText.setPath(pathText);
		pathTransition.setNode(rect);
		pathTransitionText.setNode(text);
		// play the animations
		pathTransition.play();
		pathTransitionText.play();
	}

	/**
	 * Animation for the comparison comparison.
	 *
	 * @param rect
	 *            the first rectangle
	 * @param rect2
	 *            the second rectangle
	 * @param speed
	 *            the speed
	 */
	// public void setCurrentIndex(int current) {}
	public void animationComparison(Rectangle rect, Rectangle rect2, int speed) {
		// set the animating property to true
		model.setAnimating(true);
		// make the 2 rectangles yellow
		rect.setFill(Color.YELLOW);
		rect2.setFill(Color.YELLOW);
		// enable the buttons only if the timer is not running
		if (timerON) {
			// make a animation that last speed
			animateNothing(rect, speed);
		} else {
			controls.enableForward();
			controls.enableBack();
		}
	}

	/**
	 * Animate nothing.
	 *
	 * @param rect
	 *            the rectangle
	 * @param speed
	 *            the speed
	 */
	private void animateNothing(Rectangle rect, int speed) {
		// set the animating flag to true
		model.setAnimating(true);
		// make a new path
		Path path = new Path();
		// starting point
		path.getElements().add(new MoveTo(20, 20));
		// move 1/10000 of a pixel down
		path.getElements().add(new LineTo(20, 20.0001));
		// move 1/10000 of a pixel up
		path.getElements().add(new LineTo(20, 20));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(speed));
		// set the paths and the elements
		pathTransition.setPath(path);
		pathTransition.setNode(rect);
		// play the animation
		pathTransition.play();
		// after the animation has completed set the animating flag to false
		pathTransition.setOnFinished(e -> {
			model.setAnimating(false);
		});

	}

	/**
	 * Reset the rectangles back to orange.
	 */
	public void resetRectColor() {
		// make a new rectangle
		Rectangle colorR;
		// set the animation flag to false
		model.setAnimating(false);
		// for every box
		for (int i = 0; i < numBoxes; i++) {
			// set the color to ORANGE
			colorR = (Rectangle) (pane.getChildren().get(i));
			colorR.setFill(Color.ORANGE);
		}
	}

	/**
	 * Change the color of all rectangles to CHARTREUSE.
	 */
	public void RectColorSorted() {
		Rectangle colorR;
		// set the animation flag to false
		model.setAnimating(false);
		// for every rectangle
		for (int i = 0; i < numBoxes; i++) {
			// make the rectangle CHARTREUSE
			colorR = (Rectangle) (pane.getChildren().get(i));
			colorR.setFill(Color.CHARTREUSE);
		}
	}

	/**
	 * Change color for the pivot/third element.
	 *
	 * @param rect
	 *            the rectangle
	 */
	public void changeColor(Rectangle rect) {
		rect.setFill(Color.DODGERBLUE);
	}

	/**
	 * Log add message
	 *
	 * @param msg
	 *            the message
	 */
	public void logAddMsg(String msg) {
		logText.appendText("\n" + msg);
	}

	/**
	 * Screen msg.
	 *
	 * @param msg
	 *            the msg
	 */
	public void screenMsg(String msg) {
		screenMsg.setText(msg);
	}

	/**
	 * Click play.
	 */
	public void clickPlay() {
		// call the play function
		controls.clickPlay();
	}

	/**
	 * Click stop.
	 */
	public void clickStop() {
		// call the stop function
		controls.clickStop();
	}

	/**
	 * Click close.
	 */
	public void clickClose() {
		// call the close function
		controls.clickClose();
	}

	/**
	 * Disable back.
	 */
	public void disableBack() {
		controls.disableBack();
	}

	/**
	 * Disable forward.
	 */
	public void disableForward() {
		controls.disableForward();
	}

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public double getspeed() {
		speed = controls.getSpeed();
		return controls.getSpeed();
	}

	/**
	 * Enable forward.
	 */
	public void enableForward() {
		controls.enableForward();
	}

	/**
	 * Enable back.
	 */
	public void enableBack() {
		controls.enableBack();
	}

	/**
	 * Timer flag set.
	 *
	 * @param b
	 *            the new boolean flag
	 */
	public void timerSet(Boolean b) {
		timerON = b;
	}

	/**
	 * Enable play.
	 */
	public void enablePlay() {
		controls.enablePlay();

	}

	/**
	 * Disable play.
	 */
	public void disablePlay() {
		controls.disablePlay();
	}

	/**
	 * Disable stop.
	 */
	public void disableStop() {
		controls.disableStop();
	}
}