package javaFx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
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
 * @author ElliottUpton
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

	@Override
	public void start(Stage stage) {
		mainMenu menu = new mainMenu(); // the core code
		mainMenuModel model = new mainMenuModel(menu); // model
		
		BorderPane border = new BorderPane();
		FlowPane flowPane = new FlowPane();
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(flowPane);
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		border.setCenter(flowPane);
		FlowPane flow = new FlowPane(Orientation.VERTICAL);
		flow.setColumnHalignment(HPos.LEFT); // align labels on left
		flow.setPrefWrapLength(100); // preferred height = 200
		
		// button creation
		Button bubble = new Button();
		bubble.setText("Bubble");
		bubble.setMaxWidth(Double.MAX_VALUE);
		bubble.setOnAction(e -> {
			model.setSort("bubble");// this line might not be needed
			flowPane.getChildren().add(new FXvisualiser());
		});

		Button quick = new Button("Quick");
		quick.setMaxWidth(Double.MAX_VALUE);
		quick.setOnAction(e -> model.setSort("quick"));

		Button insertion = new Button("Insertion");
		insertion.setMaxWidth(Double.MAX_VALUE);
		insertion.setOnAction(e -> model.setSort("insertion"));

		// Title Creation
		Text scenetitle = new Text("SortAlgo Main Menu");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		Label scenetitle1 = new Label("SortAlgo");
		scenetitle1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		BorderPane borderTop = new BorderPane();

		// set the layout method to grid - table
		GridPane gridMenu = new GridPane();
		gridMenu.setAlignment(Pos.TOP_LEFT); // location of the table
		gridMenu.setHgap(10); // spacing
		gridMenu.setVgap(10); // spacing
		gridMenu.setPadding(new Insets(10, 10, 10, 10)); // padding aroung the
															// whole table

		// add objects to the pane
		gridMenu.add(scenetitle, 0, 0, 2, 1);
		gridMenu.add(bubble, 1, 1);
		gridMenu.add(quick, 1, 2);
		gridMenu.add(insertion, 1, 3);

		borderTop.setCenter(scenetitle);
		border.setTop(borderTop);
		border.setLeft(gridMenu);

		Scene menuScene = new Scene(border, 200, 200);
		// add the scene to the pane
		stage.setScene(menuScene);
		stage.setTitle("SortAlgo");
		stage.show();
	}
}
