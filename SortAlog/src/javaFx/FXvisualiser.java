package javaFx;

import java.util.Timer;
import javafx.animation.PathTransition;
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
	private TextArea logText =  new TextArea();
	private Label screenMsg = new Label("");
	private FXcontrolPane controls;
	private Timer time;


	public FXvisualiser(algModel model, int n) {//pass the model
		this.model = model;
		this.numBoxes = model.getSize();
		this.setMinSize(780, 250);//DO NOT CHANGE THIS LINE OR BOXES GET REMOVED 780

		BorderPane bottomLayout = new BorderPane();
		//System.out.println("model size = "+ model.getSize());

		Text panetitle = new Text(model.getSortTypeString() + " Sort"); // dynamically set the title
		System.err.println(model.getSortTypeString());
		panetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		screenMsg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		this.pane = new Pane(); //visualiser

		this.setStyle("-fx-background-color: WHITE;"); //background
		//this.setPrefSize(800, 250); //size if you remove this it will give you the smallest panel possible

		String stringID = Integer.toString(n);
		this.setId(stringID);

		//setStage();
		rectList = new Rectangle[this.numBoxes];
		textList = new Text[numBoxes];
		for(int i=0;i<numBoxes;i++){
			rectList[i] = new Rectangle (40, 40, Color.ORANGE);
			rectList[i].setArcHeight(15);
			rectList[i].setArcWidth(15);
			rectList[i].relocate(50+(50*i), 50);
			textList[i] = new Text(model.getCurrentBoxContent(i));
			textList[i].relocate(65+(50*i), 65);

		}
		pane.getChildren().setAll();
		pane.getChildren().addAll(rectList); //add the sqares
		pane.getChildren().addAll(textList); //add the text
		pane.setMinWidth(500);

		controls = new FXcontrolPane(model,logText);//add the controls to the pane

		Button log = new Button("Show log");
		log.setOnAction(e -> {
			logAddMsg("--------------------------");
			logAddMsg("The log will shows a written representation of the animation");
			logText.setMinSize(200, 100);
			logText.setPrefSize(200, 100);
			logText.setWrapText(true);
			logText.setStyle("-fx-background-color: transparent");
			this.setMinWidth(780);
			this.setRight(logText);
		});
		BorderPane logBtnPos = new BorderPane();
		BorderPane screenMsgPos = new BorderPane();
		//set out the pain
		screenMsgPos.setCenter(screenMsg);
		bottomLayout.setTop(screenMsgPos);
		bottomLayout.setLeft(controls);
		bottomLayout.setRight(logBtnPos);
		logBtnPos.setCenter(log);
		//bottomLayout.setBackground(new Background(new BackgroundFill(Color.RED,CornerRadii.EMPTY, Insets.EMPTY)));
		this.setTop(panetitle);
		this.setCenter(pane);
		this.setBottom(bottomLayout);

	}

	public void animationBotRight(Rectangle rect, Text text,int n,int speed){
		//make a new path
		Path path = new Path();
		//put elements of the path in it
		path.getElements().add(new MoveTo(20,20));
		path.getElements().add(new LineTo(20, 70));
		path.getElements().add(new ArcTo(300, 50, 0, 20 + 50*n, 70, false, false));
		path.getElements().add(new LineTo(20 + 50*n, 20));
		//make a new path
		Path path2 = new Path();
		//put elements of the path in it
		path2.getElements().add(new MoveTo(0,0));
		path2.getElements().add(new LineTo(0, 50));
		path2.getElements().add(new ArcTo(300, 50, 0, 50*n, 50, false, false));
		LineTo testing = new LineTo(50*n, 0);
		path2.getElements().add(testing);
		//new transitions and duration
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(speed));
		PathTransition pathTransition2 =new PathTransition();
		pathTransition2.setDuration(Duration.millis(speed));
		//set the paths and the elements
		pathTransition.setPath(path);
		pathTransition2.setPath(path2);
		pathTransition.setNode(rect);
		pathTransition2.setNode(text);
		//play the animation
		pathTransition.play();
		pathTransition2.play();
		//on finish do this:
		pathTransition.setOnFinished(e->{controls.enableBtn();});
		pathTransition2.setOnFinished(e->{controls.enableBtn();});

	}
	public void animationTopLeft(Rectangle rect, Text text,int n,int speed){
		//make a new path
		Path path = new Path();
		//put elements of the path in it
		path.getElements().add(new MoveTo(20,20));
		path.getElements().add(new LineTo(20, -30));
		path.getElements().add(new ArcTo(300, 50, 0, 20 - 50*n, -30, false, false));
		path.getElements().add(new LineTo(20 - 50*n, 20));
		//make a new path
		Path path2 = new Path();
		//put elements of the path in it
		path2.getElements().add(new MoveTo(0,0));
		path2.getElements().add(new LineTo(0, -50));
		path2.getElements().add(new ArcTo(300, 50, 0, -50*n, -50, false, false));
		path2.getElements().add(new LineTo(-50*n, 0));
		//new transitions and duration
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(speed));
		PathTransition pathTransition2 =new PathTransition();
		pathTransition2.setDuration(Duration.millis(speed));
		//set the paths and the elements
		pathTransition.setPath(path);
		pathTransition2.setPath(path2);
		pathTransition.setNode(rect);
		pathTransition2.setNode(text);
		//play the animation
		pathTransition.play();
		pathTransition2.play();
		//on finish do this:
		pathTransition.setOnFinished(e->{controls.enableBtn();});
		pathTransition2.setOnFinished(e->{controls.enableBtn();});

	}

	public void animationTopInsertion(Rectangle rect,Rectangle[] rects, Text text,Text[] texts,int n,int speed){
		//make a new path
		Path pathFirst = new Path();
		//put elements of the path in it
		pathFirst.getElements().add(new MoveTo(20,20));
		pathFirst.getElements().add(new LineTo(20, -30));
		pathFirst.getElements().add(new ArcTo(300, 50, 0, 20 - 50*n, -30, false, false));
		pathFirst.getElements().add(new LineTo(20 - 50*n, 20));
		//make a new path
		Path pathFirstText = new Path();
		//put elements of the path in it
		pathFirstText.getElements().add(new MoveTo(0,0));
		pathFirstText.getElements().add(new LineTo(0, -50));
		pathFirstText.getElements().add(new ArcTo(300, 50, 0, -50*n, -50, false, false));
		pathFirstText.getElements().add(new LineTo(-50*n, 0));
		//new transitions and duration
		PathTransition pathTransitionFirst = new PathTransition();
		PathTransition pathTransitionFirstText = new PathTransition();
		pathTransitionFirst.setDuration(Duration.millis(speed));
		pathTransitionFirstText.setDuration(Duration.millis(speed));
		//set the paths and the elements
		pathTransitionFirst.setPath(pathFirst);
		pathTransitionFirstText.setPath(pathFirstText);
		pathTransitionFirst.setNode(rect);
		pathTransitionFirstText.setNode(text);
		//play the animation
		pathTransitionFirst.play();
		pathTransitionFirstText.play();
		for (int i = 0; i < texts.length; i++) {
			Path pathN = new Path();
			pathN.getElements().add(new MoveTo(20,20));
			pathN.getElements().add(new LineTo(20 - 50*n, 20));
			Path pathNText = new Path();
			pathNText.getElements().add(new MoveTo(0,0));
			pathNText.getElements().add(new LineTo(-50*n, 0));
			//new transitions and duration
			PathTransition pathTransitionN = new PathTransition();
			PathTransition pathTransitionNText = new PathTransition();
			pathTransitionFirst.setDuration(Duration.millis(speed));
			pathTransitionFirstText.setDuration(Duration.millis(speed));
			//set the paths and the elements
			pathTransitionN.setPath(pathN);
			pathTransitionNText.setPath(pathNText);
			pathTransitionN.setNode(rects[i]);
			pathTransitionNText.setNode(texts[i]);
			//play the animation
			pathTransitionFirst.play();
			pathTransitionFirstText.play();
		}

		pathTransitionFirst.setOnFinished(e->{controls.enableBtn();});
		pathTransitionFirstText.setOnFinished(e->{controls.enableBtn();});

	}
	//public void setCurrentIndex(int current) {}
	public void animationComparison(Rectangle rect, Rectangle rect2) {
		//make the rectangles YELLOW
		controls.disableBtn();
		rect.setFill(Color.YELLOW);
		rect2.setFill(Color.YELLOW);
		controls.enableBtn();
	}

	public void resetRectColor() {
		//resets the colour to ORANGE
		Rectangle colorR;
		for(int i=0;i<numBoxes;i++){
			colorR = (Rectangle)(pane.getChildren().get(i));
			colorR.setFill(Color.ORANGE);
		}
	}
	public void logAddMsg(String msg){
		logText.appendText("\n"+ msg);
	}
	public void screenMsg(String msg){
		screenMsg.setText(msg);
	}

	public void clickPlay() {
		//		System.out.println("Timer start");
		//		time = new Timer();
		//		time.schedule(new TimerTask(){
		//			public void run(){
		//				System.out.println("Timer exec");
		//				goForward();
		//			}
		//		}, 0, 1000);
		controls.clickPlay();
	}

	public void clickStop() {
		controls.clickStop();
	}
}