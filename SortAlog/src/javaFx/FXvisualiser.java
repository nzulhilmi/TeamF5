package javaFx;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;


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

		Text panetitle = new Text(/* SortType + */"Sort"); // dynamically set the title
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
			textList[i] = new Text(model.getCurrentBoxContent(i));
			textList[i].setBoundsType(TextBoundsType.VISUAL);
			textList[i].relocate(65+50*i, 65);
		}
		pane.getChildren().addAll(rectList); //add the sqares
		pane.getChildren().addAll(textList); //add the text
		FXcontrolPane controls = new FXcontrolPane(model);//add the controls to the pane
		//set out the pain
		this.setTop(panetitle);
		this.setCenter(pane);
		this.setBottom(controls);
	}

	//public void setCurrentIndex(int current) {}
}