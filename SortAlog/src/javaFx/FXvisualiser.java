package javaFx;

import java.util.Timer;

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
 * in a new panel
 *
 * @author Kiril N., ElliottUpton
 *
 */
public class FXvisualiser extends BorderPane {
	algModel model;
	private int currentIndex;
	private Rectangle[] rectList;
	private Text[] textList;
	private int numBoxes;
	private Pane pane;
	private boolean timerON = false;
	private TextArea logText = new TextArea();
	private Label screenMsg = new Label("");
	private FXcontrolPane controls;
	private Timer time;
	private BorderPane logBtnPos = new BorderPane();
	private double speed;
	private boolean animating = false;

	public FXvisualiser(algModel model, int n) {// pass the model
		this.model = model;
		this.numBoxes = model.getSize();
		this.setMinSize(580, 250);// DO NOT CHANGE THIS LINE OR BOXES GET
									// REMOVED 780

		BorderPane bottomLayout = new BorderPane();
		// System.out.println("model size = "+ model.getSize());

		Text panetitle = new Text(model.getSortTypeString() + " Sort"); // dynamically
																		// set
																		// the
																		// title
		System.err.println(model.getSortTypeString());
		panetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		screenMsg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		this.pane = new Pane(); // visualiser

		this.setStyle("-fx-background-color: WHITE;"); // background
		// this.setPrefSize(800, 250); //size if you remove this it will give
		// you the smallest panel possible

		String stringID = Integer.toString(n);
		this.setId(stringID);

		// setStage();
		rectList = new Rectangle[this.numBoxes];
		textList = new Text[numBoxes];
		for (int i = 0; i < numBoxes; i++) {
			rectList[i] = new Rectangle(40, 40, Color.ORANGE);
			rectList[i].setArcHeight(15);
			rectList[i].setArcWidth(15);
			rectList[i].setStroke(Color.BLACK);
			rectList[i].relocate(50 + (50 * i), 50);
			textList[i] = new Text(model.getCurrentBoxContent(i));
			textList[i].relocate(65 + (50 * i), 65);

		}
		pane.getChildren().setAll();
		pane.getChildren().addAll(rectList); // add the sqares
		pane.getChildren().addAll(textList); // add the text
		pane.setMinWidth(500);

		controls = new FXcontrolPane(model, logText);// add the controls to the
														// pane
		speed = controls.getSpeed();

		Button closeLog = new Button("Hide log");
		Button log = new Button("Show log");
		log.setOnAction(e -> {
			logAddMsg("--------------------------");
			logAddMsg("The log will show a written representation of the animation");
			logText.setMinSize(200, 100);
			logText.setPrefSize(200, 100);
			logText.setWrapText(true);
			logText.setStyle("-fx-background-color: transparent");
			this.setMinWidth(780);
			this.setRight(logText);
			bottomLayout.setRight(closeLog);
		});
		closeLog.setOnAction(e -> {
			this.setRight(null);
			this.setMinWidth(580);
			bottomLayout.setRight(log);
		});
		BorderPane.setAlignment(log, Pos.CENTER_RIGHT);
		BorderPane.setAlignment(closeLog, Pos.CENTER_RIGHT);
		BorderPane.setAlignment(screenMsg, Pos.TOP_CENTER);
		// set out the pain
		bottomLayout.setTop(screenMsg);
		bottomLayout.setLeft(controls);
		bottomLayout.setRight(log);

		// bottomLayout.setBackground(new Background(new
		// BackgroundFill(Color.RED,CornerRadii.EMPTY, Insets.EMPTY)));
		// this.setAlignment(panetitle, Pos.CENTER);
		this.setTop(panetitle);
		this.setCenter(pane);
		this.setBottom(bottomLayout);

	}

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
		// on finish do this:
		pathTransition.setOnFinished(e -> {
			if (timerON) {
			} else {
				controls.enableBack();
				controls.enableForward();
			}
		});
		pathTransition2.setOnFinished(e -> {
			if (timerON) {
			} else {
				controls.enableBack();
				controls.enableForward();
			}
		});

	}

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
		// on finish do this:
		pathTransition.setOnFinished(e -> {
			if (timerON) {
			} else {
				controls.enableBack();
				controls.enableForward();
			}
			model.setAnimating(false);
		});
		pathTransition2.setOnFinished(e -> {
			if (timerON) {
			} else {
				controls.enableBack();
				controls.enableForward();
			}
			model.setAnimating(false);
		});

	}

	public void animationRightInsertion(Rectangle[] rects, Text[] texts, int n, int speed) {
		for (int i = 0; i < texts.length; i++) {
			animationRight(rects[i], texts[i], speed);
		}

	}

	public void animationleftInsertion(Rectangle[] rects, Text[] texts, int n, int speed) {
		for (int i = 0; i < texts.length; i++) {
			animationLeft(rects[i], texts[i], speed);
		}

	}

	public void animationLeft(Rectangle rect, Text text, int speed) {
		Path path = new Path();
		path.getElements().add(new MoveTo(20, 20));
		path.getElements().add(new LineTo(20 - 50, 20));
		Path pathText = new Path();
		pathText.getElements().add(new MoveTo(0, 0));
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
		// play the animation
		pathTransition.play();
		pathTransitionText.play();
	}

	public void animationRight(Rectangle rect, Text text, int speed) {
		Path path = new Path();
		path.getElements().add(new MoveTo(20, 20));
		path.getElements().add(new LineTo(20 + 50, 20));
		Path pathText = new Path();
		pathText.getElements().add(new MoveTo(0, 0));
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
		// play the animation
		pathTransition.play();
		pathTransitionText.play();
	}

	// public void setCurrentIndex(int current) {}
	public void animationComparison(Rectangle rect, Rectangle rect2, int speed) {
		// make the rectangles YELLOW
		//controls.disableForward();
		//controls.disableBack();
		model.setAnimating(true);
		rect.setFill(Color.YELLOW);
		rect2.setFill(Color.YELLOW);
		animateNothing(rect, speed);
		if(timerON){

		}else{
			controls.enableForward();
			controls.enableBack();
		}

		//
		// pathTransition2.setOnFinished(e->{controls.enableBtn();
		// model.setAnimating(false);});
		// model.setAnimating(false);
		// controls.enableBtn();
	}

	private void animateNothing(Rectangle rect, int speed) {
		// make a new path
		model.setAnimating(true);
		Path path = new Path();
		path.getElements().add(new MoveTo(20, 20));
		path.getElements().add(new LineTo(20, 20.0001));
		path.getElements().add(new LineTo(20, 20));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(speed));
		// set the paths and the elements
		pathTransition.setPath(path);
		pathTransition.setNode(rect);
		// play the animation
		pathTransition.play();
		pathTransition.setOnFinished(e -> {
			model.setAnimating(false);
		});

	}

	public void resetRectColor() {
		// resets the colour to ORANGE
		Rectangle colorR;
		model.setAnimating(false);
		for (int i = 0; i < numBoxes; i++) {
			colorR = (Rectangle) (pane.getChildren().get(i));
			colorR.setFill(Color.ORANGE);
		}
	}

	public void changeColor(Rectangle rect) {
		rect.setFill(Color.CORNFLOWERBLUE);
	}

	public void logAddMsg(String msg) {
		logText.appendText("\n" + msg);
	}

	public void screenMsg(String msg) {
		screenMsg.setText(msg);
	}

	public void clickPlay() {
		controls.clickPlay();
	}

	public void clickStop() {
		controls.clickStop();
	}

	public void clickClose() {
		controls.clickClose();
	}

	public void disableBack() {
		controls.disableBack();
	}

	public void disableForward() {
		controls.disableForward();
	}

	public double getspeed() {
		speed = controls.getSpeed();
		return controls.getSpeed();
	}

	public void enableForward() {
		controls.enableForward();
	}

	public void enableBack() {
		controls.enableBack();
	}
	public void timerSet(Boolean b) {
		timerON = b;
	}

	public void enablePlay() {
		controls.enablePlay();

	}
	public void disablePlay() {
		controls.disablePlay();

	}
}