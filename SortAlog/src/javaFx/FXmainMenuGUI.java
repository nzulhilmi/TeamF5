package javaFx;

import java.util.Random;

import org.junit.experimental.max.MaxCore;

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
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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

	int intID = 0; // to set the id of each visualisation pane (to be converted
	// to string)
	static FlowPane flowPane = new FlowPane(); // FlowPane's for the sorts to be
	// added dynamically

	private int[] testInput = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	
	static Stage stage;

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		mainMenu menu = new mainMenu(); // the core code
		// algModel algModel = new algModel(null, null, null); // model

		BorderPane border = new BorderPane(); // sets the top level to a border
		// layout

		flowPane.setPrefWrapLength(100); // This line stops the main menu being
		// huge
		flowPane.setPadding(new Insets(10)); // padding 20 because of scroll
		// bars
		flowPane.setColumnHalignment(HPos.LEFT); // align labels on left

		ScrollPane scrollPane = new ScrollPane(); // ScrollPane holds the flow
		// pane so that it is
		// scrollable
		scrollPane.setStyle("-fx-background-color:transparent;"); // no border
		scrollPane.setContent(flowPane); // adds to the scroll panel
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED); // show the scroll
		// bars as and
		// when required

		border.setCenter(scrollPane); // set the position of the scrollPane to
		// the centre of the border

		// button creation
		Button bubble = new Button();
		bubble.setText("Bubble"); // set test
		bubble.setMaxWidth(Double.MAX_VALUE); // Makes the buttons all have the
		// same size
		bubble.setOnAction(e -> {
			numOfSortsOnScreen++;
			// will need to pass the model as it contains all the variables
			algModel algModel = new algModel(testInput.clone(), "bubble", intID);
			FXvisualiser vis = new FXvisualiser(algModel, intID);
			// model.setSort("bubble");// this line might not be needed
			algModel.setVis(vis);
			flowPane.getChildren().add(vis); // makes the flow pane
			scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			scenetitle.setText("SortAlgo Visualising " + (numOfSortsOnScreen) + " Algorithms");

			// This stops the screen resizing past visible.
			if (numOfSortsOnScreen <= 3)
				stage.sizeToScene();

			// increment intID so each pane will have unique ID
			intID++;
		});

		Button quick = new Button("Quick");
		quick.setMaxWidth(Double.MAX_VALUE);
		quick.setOnAction(e -> System.out.println("quick")/* model.setSort("quick") */);

		Button insertion = new Button("Insertion");
		insertion.setMaxWidth(Double.MAX_VALUE);
		insertion.setOnAction(e -> System.out.println("insertion") /* model.setSort("insertion") */);

		// Title Creation
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // font
		// selection

		// new border pane so that the title is in the center
		// BorderPane borderTop = new BorderPane();
		
		GridPane advancedTop = new GridPane();
		GridPane advancedBottom = new GridPane();
		
		Label advancedLabel = new Label("Choose input: ");
		//buttons for custom inputs
		
		Button sorted = new Button("Sorted");
		sorted.setMaxWidth(Double.MAX_VALUE);
		sorted.setOnAction(e -> {
			testInput = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			System.out.println("sorted input");
		});
		
		Button random = new Button("Random");
		random.setMaxWidth(Double.MAX_VALUE);
		random.setOnAction(e -> {
			System.out.println("random input");
			shuffleArray(testInput); //shuffle the array
		});
		
		Button reverse = new Button("Reversed");
		reverse.setMaxWidth(Double.MAX_VALUE);
		reverse.setOnAction(e -> {
			testInput = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
			System.out.println("reversed input");
		});
		
		TextArea customInput = new TextArea(); //text area to fill custom inputs
		customInput.setPrefSize(200, 50);
		
		Button submit = new Button("Submit");
		submit.setMaxWidth(Double.MAX_VALUE);
		submit.setOnAction(e -> {
			String getInput = customInput.getText(); //get input from text area
			String[] split = getInput.split(","); //split the string into elements separated by ','
			int[] output = new int[10]; 
			for(int i = 0; i < split.length; i++) {
				output[i] = Integer.parseInt(split[i]); //copy the elements into another array
			}
			testInput = output;
		});
		
		Label customInputLabel = new Label("Insert custom input. e.g 1,2,3,4,5,6,7,8,9,10");
		
		//add all the button and labels for advanced menu feature
		advancedTop.add(advancedLabel, 1, 0);
		advancedTop.add(sorted, 1, 2);
		advancedTop.add(reverse, 2, 2);
		advancedTop.add(random, 3, 2);
		advancedBottom.add(customInputLabel, 0, 0);
		advancedBottom.add(customInput, 0, 1);
		advancedBottom.add(submit, 1, 1);
		
		//add the two panes to border pane
		BorderPane advancedPane = new BorderPane();
		advancedPane.setLeft(advancedTop);
		advancedPane.setCenter(advancedBottom);
		
		border.setBottom(advancedPane); //add the border pane to the parent border pane
		advancedPane.setVisible(false);
		
		Button advanced = new Button("Advanced Menu");
		advanced.setMaxWidth(Double.MAX_VALUE);
		advanced.setOnAction(e -> {
			if(advancedPane.isVisible()) {
				advancedPane.setVisible(false);
			}
			else {
				advancedPane.setVisible(true);
			}
			resizeStage();
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
		gridMenu.add(bubble, 1, 1);
		gridMenu.add(quick, 1, 2);
		gridMenu.add(insertion, 1, 3);
		gridMenu.add(advanced, 1, 4);

		borderTop.setCenter(scenetitle); // add the title to the center
		border.setTop(borderTop); // add the center to the top
		border.setLeft(gridMenu); // add the main menu

		Scene menuScene = new Scene(border); // create the scene
		// add the scene to the pane
		stage.setScene(menuScene);
		stage.setTitle("SortAlgo");
		stage.show(); // show the stage

		flowPane.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth,
					Number newSceneWidth) {
				resizeStage();
				// scrollPane.set;
			}
		});

	}

	public static void removeVis(String s) {
		flowPane.getChildren().remove(flowPane.lookup(s));
		numOfSortsOnScreen--;
		
		scenetitle.setText("SortAlgo Visualising " + (numOfSortsOnScreen) + " Algorithms");
		
		if(numOfSortsOnScreen == 0) {
			scenetitle.setText("SortAlgo Main Menu");
		}
		resizeStage();
		
	}

	public static void resizeStage() {
		stage.sizeToScene();
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

}