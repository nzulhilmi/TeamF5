package javaFx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		
		//set the layout method to grid - table
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER); // location of the table
		grid.setHgap(10); // spacing
		grid.setVgap(10); // spacing
		grid.setPadding(new Insets(10, 10, 10, 10)); // padding aroung the whole table

		//create the scene
		Scene scene = new Scene(grid, 200, 200);
		
		//add objects to the pane
		grid.add(scenetitle, 0, 0, 2, 1);
		grid.add(bubble, 1, 1);
		grid.add(quick, 1, 2);
		grid.add(insertion, 1, 3);
		
		//add the scene to the pane
		stage.setScene(scene);
		stage.show();
	}
}
