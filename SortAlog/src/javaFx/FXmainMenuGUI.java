package javaFx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/***
 * Create the Main Menu of the Application.
 *
 * @author ElliottUpton, Kiril N.
 *
 */
public class FXmainMenuGUI extends Application {
	/**
	 * Create the Main Menu of the Application.
	 *
	 * @return
	 */
	public FXmainMenuGUI(Stage stage) {
		start(stage);
	}

	public int numOfSortsOnScreen = 0;
	// new border pane so that the title is in the center
	BorderPane borderTop = new BorderPane();

	//Secondary title for when a sort is opened
	Label scenetitle = new Label("SortAlgo Main Menu");

	@Override
	public void start(Stage stage) {
		mainMenu menu = new mainMenu(); // the core code
		int[] testInput = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//algModel algModel = new algModel(null, null, null); // model


		BorderPane border = new BorderPane(); // sets the top level to a border layout
		FlowPane flowPane = new FlowPane(); // FlowPane's for the sorts to be added dynamically
		flowPane.setPrefWrapLength(100); // This line stops the main menu being huge
	    flowPane.setPadding(new Insets(10)); //padding 20 because of scroll bars
		flowPane.setColumnHalignment(HPos.LEFT); // align labels on left

		ScrollPane scrollPane = new ScrollPane(); // ScrollPane holds the flow pane so that it is scrollable
	    scrollPane.setStyle("-fx-background-color:transparent;"); //no border
		scrollPane.setContent(flowPane); // adds to the scroll panel
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED); // show the scroll bars as and when required

		border.setCenter(scrollPane); // set the position of the scrollPane to the centre of the border


		// button creation
		Button bubble = new Button();
		bubble.setText("Bubble"); //set test
		bubble.setMaxWidth(Double.MAX_VALUE); //Makes the buttons all have the same size
		bubble.setOnAction(e -> {
			//will need to pass the model as it contains all the variables
			algModel algModel = new algModel(testInput.clone(),"bubble");
			FXvisualiser vis = new FXvisualiser(algModel);
			//model.setSort("bubble");// this line might not be needed
			algModel.setVis(vis);
			flowPane.getChildren().add(vis); //makes the flow pane
			scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			scenetitle.setText("SortAlgo Visualising " + (numOfSortsOnScreen+1) + " Algorithms");

			//This stops the screen resizing past visible.
			numOfSortsOnScreen++;
			if(numOfSortsOnScreen <= 3)
				stage.sizeToScene();
		});

		Button quick = new Button("Quick");
		quick.setMaxWidth(Double.MAX_VALUE);
		quick.setOnAction(e -> System.out.println("quick")/*model.setSort("quick")*/);

		Button insertion = new Button("Insertion");
		insertion.setMaxWidth(Double.MAX_VALUE);
		insertion.setOnAction(e -> System.out.println("insertion") /*model.setSort("insertion")*/);

		// Title Creation
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // font selection

		// new border pane so that the title is in the center
//		BorderPane borderTop = new BorderPane();

		//Main Menu
		// set the layout method to grid - table
		GridPane gridMenu = new GridPane();
		gridMenu.setAlignment(Pos.TOP_LEFT); // location of the table
		gridMenu.setHgap(10); // spacing
		gridMenu.setVgap(10); // spacing
		gridMenu.setPadding(new Insets(10, 10, 10, 10)); // padding around the table

		// add objects to the grid pane
		gridMenu.add(scenetitle, 0, 0, 2, 1);
		gridMenu.add(bubble, 1, 1);
		gridMenu.add(quick, 1, 2);
		gridMenu.add(insertion, 1, 3);

		borderTop.setCenter(scenetitle); //add the title to the center
		border.setTop(borderTop); //add the center to the top
		border.setLeft(gridMenu); //add the main menu

		Scene menuScene = new Scene(border); //create the scene
		// add the scene to the pane
		stage.setScene(menuScene);
		stage.setTitle("SortAlgo");
		stage.show(); //show the stage
	}
}
