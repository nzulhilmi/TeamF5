package javaFx;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import testing.algModel;

/**
 * this class is where the visualisation panels will be made Each sort is made
 * in a new panel
 * 
 * @author ElliottUpton
 *
 */
public class FXvisualiser extends BorderPane {
	algModel model;

	public FXvisualiser() {//pass the model
		this.model = model;
		int numBoxes = 10;

		Text panetitle = new Text(/* SortType + */"Sort"); // dynamically set the title
		panetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		Pane pane = new Pane(); //visualiser
		
		this.setStyle("-fx-background-color: WHITE;"); //background
		//this.setPrefSize(400, 250); //size if you remove this it will give you the smallest panel possible
		Circle circle = new Circle(50, Color.BLUE); //draw shape
		circle.relocate(20, 20);
		Rectangle rectangle = new Rectangle(100, 100, Color.RED);
		rectangle.relocate(70, 70);
		pane.getChildren().addAll(circle, rectangle); //add everything to the pane
		
		FXcontrolPane controls = new FXcontrolPane();//add the controls to the pane
		//set out the pain
		this.setTop(panetitle);
		this.setCenter(pane);
		this.setBottom(controls);
	}
}