package javaFx;

import java.util.Random;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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

	public static int numOfSortsOnScreen = 0;
	// new border pane so that the title is in the center
	BorderPane borderTop = new BorderPane();

	// Secondary title for when a sort is opened
	static Label scenetitle = new Label("SortAlgo Main Menu");

	int intID = 0; // to set the id of each visualisation pane (to be converted to string)
	static FlowPane flowPane = new FlowPane(); // FlowPane's for the sorts to be added dynamically
	private BorderPane border = new BorderPane(); // sets the top level to a border layout
	private ScrollPane scrollPane = new ScrollPane(); // ScrollPane holds the flowpane so that it is scrollable

	private int[] testInput = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

	static Stage stage;

	private static Boolean advancedBoolean = false;

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		// algModel algModel = new algModel(null, null, null); // model
		flowPane.setPrefWrapLength(100); // This line stops the main menu being huge
		flowPane.setPadding(new Insets(20)); // padding 20 because of scroll bars
		flowPane.setColumnHalignment(HPos.LEFT); // align labels on left

		scrollPane.setStyle("-fx-background-color:transparent;"); // no border
		scrollPane.setContent(flowPane); // adds to the scroll panel
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED); // show the scroll bars as and when required
		
		border.setCenter(scrollPane); // set the position of the scrollPane to the centre of the border
		
		// button creation
		Button bubble = new Button();
		bubble.setText("Bubble"); // set test
		bubble.getStyleClass().add("sortButtons");
		bubble.setMaxWidth(Double.MAX_VALUE); // Makes the buttons all have the same size
		bubble.setOnAction(e -> onClickVisulisation("Bubble")); //calls the code to create a new visualization

		Button quick = new Button("Quick");
		quick.getStyleClass().add("sortButtons");
		quick.setMaxWidth(Double.MAX_VALUE);
		quick.setOnAction(e -> System.out.println("Quick"));

		Button insertion = new Button("Insertion");
		insertion.getStyleClass().add("sortButtons");
		insertion.setMaxWidth(Double.MAX_VALUE);
		insertion.setOnAction(e -> onClickVisulisation("Insertion"));

		Button selection = new Button("Selection");
		selection.getStyleClass().add("sortButtons");
		selection.setMaxWidth(Double.MAX_VALUE);
		selection.setOnAction(e -> onClickVisulisation("Selection"));

		// Title Creation
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // font
		// selection

		// new border pane so that the title is in the center
		// BorderPane borderTop = new BorderPane();

		AdvancedMenu advancedMenu = new AdvancedMenu(stage, border);
		

		Button advanced = new Button("Advanced Menu");
		advanced.setMaxWidth(Double.MAX_VALUE);
		advanced.setOnAction(e -> {
			border.setBottom(advancedMenu); //add the border pane to the parent border pane
			resizeStage();
			advancedBoolean = true;
		});

		// Main Menu
		// set the layout method to grid - table
		GridPane gridMenu = new GridPane();
		gridMenu.setAlignment(Pos.TOP_LEFT); // location of the table
		gridMenu.setHgap(10); // spacing
		gridMenu.setVgap(10); // spacing
		gridMenu.setPadding(new Insets(10, 10, 10, 10)); // padding around the

		// add objects to the grid pane
		gridMenu.add(scenetitle, 0, 0, 2, 1);
		gridMenu.add(bubble, 5, 10);
		gridMenu.add(quick, 5, 11);
		gridMenu.add(insertion, 5, 12);
		gridMenu.add(selection, 5, 13);
		gridMenu.add(advanced, 5, 14);
		
		/* Logo added and the menu buttons have been shifted a bit */
		Image img = new Image("softwarelogoFinal2darkerCropped300x100.png");
		ImageView imgView = new ImageView(img);
		imgView.getStyleClass().add("logo");
		imgView.setFitWidth(240);
		imgView.setX(30);
		imgView.setY(25);
		border.getChildren().add(imgView);
	    
		BorderPane borderLeft = new BorderPane();//layout for the left
		ExplanationPane explanationPane = new ExplanationPane();
		borderLeft.setTop(gridMenu);
		borderLeft.setCenter(explanationPane);

		borderTop.setCenter(scenetitle); // add the title to the center
		border.setTop(borderTop); // add the center to the top
		border.setLeft(borderLeft); // add the main menu
		//border.setStyle("-fx-background-color: #CD5C5C;");

		Scene menuScene = new Scene(border); // create the scene
		// add the scene to the pane
		menuScene.getStylesheets().add("menuDesign.css");
		stage.setScene(menuScene);
		stage.setTitle("SortAlgo");
		stage.show(); // show the stage

		flowPane.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
				resizeStage();
			}
		});
	}

	public static void removeVis(String s) {
		flowPane.getChildren().remove(flowPane.lookup(s));
		numOfSortsOnScreen--;

		scenetitle.setText("SortAlgo Visualising " + (numOfSortsOnScreen) + " Algorithms");

		if(numOfSortsOnScreen == 0) {
			scenetitle.setText("SortAlgo Main Menu");
			resizeStage();
		} else if (numOfSortsOnScreen <=3) {
			resizeStage();
		}

	}

	public static void resizeStage() {
		stage.sizeToScene();
	}
	/**
	 * This method creates the visulisation based on the passed sortType paramater.
	 * Configures the model and generates a flowpane
	 *
	 * @param sort The sort type
	 *
	 */
	public void onClickVisulisation(String sort){
		numOfSortsOnScreen++;
		if(advancedBoolean) {
			testInput = AdvancedMenu.getInput();
		}
		else {
			shuffleArray(testInput);
		}
		// will need to pass the model as it contains all the variables
		algModel algModel = new algModel(testInput.clone(), sort, intID);
		FXvisualiser vis = new FXvisualiser(algModel, intID);
		algModel.setVis(vis);
		flowPane.getChildren().add(vis); // makes the flow pane
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scenetitle.setText("SortAlgo Visualising " + (numOfSortsOnScreen) + " Algorithms");

		// This stops the screen resizing past visible.
		if (numOfSortsOnScreen <= 3)
			stage.sizeToScene();
		// increment intID so each pane will have unique ID
		intID++;
	}

	public void shuffleArray(int[] array)
	{
		int index;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--)
		{
			index = random.nextInt(i + 1);
			if (index != i)
			{
				array[index] ^= array[i];
				array[i] ^= array[index];
				array[index] ^= array[i];
			}
		}
	}

	public static void setBoolean(Boolean b1) {
		advancedBoolean = b1;
	}

}