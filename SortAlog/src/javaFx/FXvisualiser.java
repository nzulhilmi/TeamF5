package javaFx;

import javafx.animation.PathTransition;
import javafx.scene.control.Button;
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
	private TextArea logText=  new TextArea();
	private FXcontrolPane controls;


	public FXvisualiser(algModel model, int n) {//pass the model
		this.model = model;
		this.numBoxes = model.getSize();
		this.setMinSize(615, 200);

		BorderPane bottomLayout = new BorderPane();
		//System.out.println("model size = "+ model.getSize());

		Text panetitle = new Text(model.getSortTypeString() + " Sort"); // dynamically set the title
		System.err.println(model.getSortTypeString());
		panetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

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
			//rectList[i].
			textList[i] = new Text(model.getCurrentBoxContent(i));
			//textList[i].setBoundsType(TextBoundsType.VISUAL);
			textList[i].relocate(65+(50*i), 65);
			//			System.out.println("textN: "+i+ " TA: "+textList[i].getY() +
			//											" Y: "+textList[i].getX() +
			//											" TX: "+textList[i].getTranslateX() +
			//											" TY: "+textList[i].getTranslateY() +
			//											" LX: "+textList[i].getLayoutX() +
			//											" LY: "+textList[i].getLayoutY()
			//											);
			//textList[i].translateXProperty().set(20);
			//textList[i].translateYProperty().set(25);
		}
		pane.getChildren().setAll();
		pane.getChildren().addAll(rectList); //add the sqares
		pane.getChildren().addAll(textList); //add the text

		controls = new FXcontrolPane(model,logText);//add the controls to the pane

		Button log = new Button("Show log");
		log.setOnAction(e -> {
			logText.setText("This is our log panel which the stage should auto resize to accomodate");
			logText.setPrefSize(200, 100);
			this.setRight(logText);
		});

		//set out the pain
		bottomLayout.setLeft(controls);
		bottomLayout.setRight(log);
		this.setTop(panetitle);
		this.setCenter(pane);
		this.setBottom(bottomLayout);

	}

	public void animationBotRight(Rectangle rect, Text text,int n){
		//System.out.println("bot rigt: "+rect.getLayoutX()+"  "+rect.getLayoutY()+" Text: "+ text.getText());
		Path path = new Path();
		path.getElements().add(new MoveTo(20,20));
		path.getElements().add(new LineTo(20, 70));
		path.getElements().add(new ArcTo(300, 50, 0, 20 + 50*n, 70, false, false));
		path.getElements().add(new LineTo(20 + 50*n, 20));
		Path path2 = new Path();
		path2.getElements().add(new MoveTo(0,0));
		path2.getElements().add(new LineTo(0, 50));
		path2.getElements().add(new ArcTo(300, 50, 0, 50*n, 50, false, false));
		path2.getElements().add(new LineTo(50*n, 0));
		//path.getElements().add(new CubicCurveTo(20, 100, 20, 200, 20, 200));
		//path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
		//path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(1000));
		PathTransition pathTransition2 =new PathTransition();
		pathTransition2.setDuration(Duration.millis(1000));
		pathTransition.setPath(path);
		pathTransition2.setPath(path2);
		pathTransition.setNode(rect);
		pathTransition2.setNode(text);
		//pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		//pathTransition.setCycleCount(Timeline.INDEFINITE);
		//pathTransition.setAutoReverse(true);
		//pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		//pathTransition2.setCycleCount(Timeline.INDEFINITE);
		//pathTransition2.setAutoReverse(true);

		pathTransition.play();
		pathTransition2.play();

		pathTransition.setOnFinished(e->{controls.enableBtn();});
		pathTransition2.setOnFinished(e->{controls.enableBtn();});
		
		//setStage();
		//resetR(rect, text);
	}
	public void animationTopLeft(Rectangle rect, Text text,int n){
		Path path = new Path();
		System.out.println("top Left:left: "+rect.getLayoutX()+"  "+rect.getLayoutY()+" Text: "+ text.getText());
		System.out.println("top Left:right: "+rect.getLayoutX()+"  "+rect.getLayoutY()+" Text: "+ text.getText());
		path.getElements().add(new MoveTo(20,20));
		path.getElements().add(new LineTo(20, -30));
		path.getElements().add(new ArcTo(300, 50, 0, 20 - 50*n, -30, false, false));
		path.getElements().add(new LineTo(20 - 50*n, 20));
		Path path2 = new Path();
		path2.getElements().add(new MoveTo(0,0));
		path2.getElements().add(new LineTo(0, -50));
		path2.getElements().add(new ArcTo(300, 50, 0, -50*n, -50, false, false));
		path2.getElements().add(new LineTo(-50*n, 0));
		//path.getElements().add(new CubicCurveTo(20, 100, 20, 200, 20, 200));
		//path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
		//path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(1000));
		PathTransition pathTransition2 =new PathTransition();
		pathTransition2.setDuration(Duration.millis(1000));
		pathTransition.setPath(path);
		pathTransition2.setPath(path2);
		pathTransition.setNode(rect);
		pathTransition2.setNode(text);
		//pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		//pathTransition.setCycleCount(Timeline.INDEFINITE);
		//pathTransition.setAutoReverse(true);
		//pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		//pathTransition2.setCycleCount(Timeline.INDEFINITE);
		//pathTransition2.setAutoReverse(true);

		pathTransition.play();
		pathTransition2.play();
		
		pathTransition.setOnFinished(e->{controls.enableBtn();});
		pathTransition2.setOnFinished(e->{controls.enableBtn();});
		//setStage();
		//resetR(rect, text);
	}
	//public void setCurrentIndex(int current) {}
	public void animationComparison(Rectangle rect, Rectangle rect2) {
		controls.disableBtn();
		rect.setFill(Color.YELLOW);
		rect2.setFill(Color.YELLOW);
		controls.enableBtn();
	}
	//	public void resetRectangles(){
	//		Rectangle rectangleMove;
	//		for(int i=0;i<numBoxes;i++){
	//			rectangleMove = (Rectangle) pane.getChildren().get(i);
	//			//System.out.println(rectangleMove.getX() + "   "+i);
	//			int n =i*50;
	//			rectangleMove.relocate(50+n, 50);
	//			//System.out.println(rectangleMove.getX() + "   "+i);
	//		}
	//	}
	public void resetRectColor() {
		Rectangle colorR;
		for(int i=0;i<numBoxes;i++){
			colorR = (Rectangle)(pane.getChildren().get(i));
			colorR.setFill(Color.ORANGE);
		}
	}
}