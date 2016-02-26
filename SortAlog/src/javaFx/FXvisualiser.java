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

	public FXvisualiser() {
		this.model = model;
		int numBoxes = 10;

		Text panetitle = new Text(/* SortType + */"Sort");
		panetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		Pane pane = new Pane();
		
		this.setStyle("-fx-background-color: WHITE;");
		this.setPrefSize(500, 300);
		Circle circle = new Circle(50, Color.BLUE);
		circle.relocate(20, 20);
		Rectangle rectangle = new Rectangle(100, 100, Color.RED);
		rectangle.relocate(70, 70);
		pane.getChildren().addAll(circle, rectangle);
		
		FXcontrolPane controls = new FXcontrolPane();
		this.setTop(panetitle);
		this.setCenter(pane);
		this.setBottom(controls);
	}
}