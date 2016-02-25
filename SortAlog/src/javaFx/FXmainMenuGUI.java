package javaFx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/***
 * Create the Main Menu of the Application.
 * @author Elliott Upton
 *
 */
public class FXmainMenuGUI extends Application {
	/**
	 * Create the Main Menu of the Application.
	 * @return 
	 */
	public FXmainMenuGUI(Stage stage)
	{
		start(stage);
	}

	@Override
	public void start(Stage stage){
		mainMenu menu = new mainMenu(); //the core code
		mainMenuModel model = new mainMenuModel(menu); //model
		
		//button creation
		Button bubble = new Button();
		bubble.setText("Bubble");
		bubble.setOnAction(e -> model.setSort("bubble"));

		Button quick = new Button("Quick");
		quick.setOnAction(e -> model.setSort("quick"));

		Button insertion = new Button("Insertion");
		insertion.setOnAction(e -> model.setSort("insertion"));
		
		//Title Creation
		Text scenetitle = new Text("SortAlgo Main Menu");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		Label scenetitle1 = new Label("SortAlgo Main Menu");
		scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		BorderPane border = new BorderPane();
		BorderPane borderTop = new BorderPane();
		/*
		 * the panes are where the the visulisation will run 
		 * surronded by a scroll panel which will make it work.
		 * will need to make an exit button too otherwise it will add endlessly
		 */
		//FXvisualiser pane = new FXvisualiser();
		//FlowPane pane2  = new FlowPane();
		
		GridPane gridCenter = new GridPane(); 
	    gridCenter.setStyle("-fx-background-color: red;-fx-padding: 10px;");
		gridCenter.setHgap(10); // spacing
		gridCenter.setVgap(10); // spacing
		gridCenter.setPadding(new Insets(10, 10, 10, 10));
		
		//set the layout method to grid - table
		GridPane gridMenu = new GridPane();
		gridMenu.setAlignment(Pos.TOP_LEFT); // location of the table
		gridMenu.setHgap(10); // spacing
		gridMenu.setVgap(10); // spacing
		gridMenu.setPadding(new Insets(10, 10, 10, 10)); // padding aroung the whole table
		
		gridCenter.add(scenetitle1, 0, 0, 2, 1);

		
		//add objects to the pane
		gridMenu.add(scenetitle, 0, 0, 2, 1);
		gridMenu.add(bubble, 1, 1);
		gridMenu.add(quick, 1, 2);
		gridMenu.add(insertion, 1, 3);
			
		borderTop.setCenter(scenetitle);
		border.setTop(borderTop);
		border.setLeft(gridMenu);
		border.setCenter(gridCenter);
		
		Scene menuScene = new Scene(border, 200, 200);
		//add the scene to the pane
		stage.setScene(menuScene);
		stage.setTitle("SortAlgo");
		stage.show();
	}
}
