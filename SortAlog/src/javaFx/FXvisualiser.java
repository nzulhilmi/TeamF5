package javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXvisualiser extends Application{
	public FXvisualiser(String sort) {
		// TODO Auto-generated constructor stub
		Stage stage = new Stage();
		start(stage);
	}
	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		
		Text scenetitle = new Text("SortAlgo Main Menu");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		System.err.println("here");

		
		BorderPane border = new BorderPane();
		border.setTop(scenetitle);
		//border.setLeft(addVBox());
		//addStackPane(hbox);         // Add stack to HBox in top region

		//border.setCenter(addGridPane());
		//border.setRight(addFlowPane());
		
		//create the scene
		Scene scene = new Scene(border, 200, 200);
		
		stage.show();
		
	}
}
