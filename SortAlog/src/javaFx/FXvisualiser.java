package javaFx;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
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

	public FXvisualiser(algModel model) {//pass the model
		this.model = model;
		int numBoxes = model.getSize();
		//System.out.println("model size = "+ model.getSize());

		Text panetitle = new Text(model.getSortTypeString() + " Sort"); // dynamically set the title
		System.err.println(model.getSortTypeString());
		panetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		Pane pane = new Pane(); //visualiser

		this.setStyle("-fx-background-color: WHITE;"); //background
		//this.setPrefSize(400, 250); //size if you remove this it will give you the smallest panel possible
		/*
		Circle circle = new Circle(50, Color.BLUE); //draw shape
		circle.relocate(20, 20);*/

		rectList = new Rectangle[numBoxes];
		textList = new Text[numBoxes];
		for(int i=0;i<numBoxes;i++){
			rectList[i] = new Rectangle (40, 40, Color.ORANGE);
			rectList[i].setArcHeight(15);
			rectList[i].setArcWidth(15);
			rectList[i].relocate(50+50*i, 50);
			//rectList[i].
			textList[i] = new Text(model.getCurrentBoxContent(i));
			textList[i].setBoundsType(TextBoundsType.VISUAL);
			textList[i].relocate(50+50*i, 50);
			textList[i].translateXProperty().set(20);
			textList[i].translateYProperty().set(25);
		}
		pane.getChildren().addAll(rectList); //add the sqares
		pane.getChildren().addAll(textList); //add the text
		FXcontrolPane controls = new FXcontrolPane(model);//add the controls to the pane
		//set out the pain++
		this.setTop(panetitle);
		this.setCenter(pane);
		this.setBottom(controls);
	}
	public void animation(Rectangle rect, Text text){
		Path path = new Path();
		path.getElements().add(new MoveTo(20,20));
		path.getElements().add(new ArcTo(50, 50, 50, 220, 20, false, false));
		//path.getElements().add(new CubicCurveTo(20, 100, 20, 200, 20, 200));
		//path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
		//path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(2000));
		PathTransition pathTransition2 =new PathTransition();
		pathTransition2.setDuration(Duration.millis(2000));
		pathTransition.setPath(path);
		pathTransition2.setPath(path);
		pathTransition.setNode(rect);
		pathTransition2.setNode(text);
		//pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(Timeline.INDEFINITE);
		pathTransition.setAutoReverse(true);
		//pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition2.setCycleCount(Timeline.INDEFINITE);
		pathTransition2.setAutoReverse(true);
		pathTransition.play();
		pathTransition2.play();
	}

	//public void setCurrentIndex(int current) {}
}