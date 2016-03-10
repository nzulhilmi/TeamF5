package javaFx;

import java.util.Arrays;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
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

	BorderPane advancedPane = new BorderPane();

	private BorderPane border = new BorderPane(); // sets the top level to a border layout
	private ScrollPane scrollPane = new ScrollPane(); // ScrollPane holds the flowpane so that it is scrollable

	private int[] testInput = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

	static Stage stage;

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
		bubble.setMaxWidth(Double.MAX_VALUE); // Makes the buttons all have the same size
		bubble.setOnAction(e -> onClickVisulisation("Bubble")); //calls the code to create a new visualization

		Button quick = new Button("Quick");
		quick.setMaxWidth(Double.MAX_VALUE);
		quick.setOnAction(e -> System.out.println("Quick"));

		Button insertion = new Button("Insertion");
		insertion.setMaxWidth(Double.MAX_VALUE);
		insertion.setOnAction(e -> onClickVisulisation("Insertion"));

		Button merge = new Button("Merge");
		merge.setMaxWidth(Double.MAX_VALUE);
		merge.setOnAction(e -> onClickVisulisation("Merge"));

		// Title Creation
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // font
		// selection

		// new border pane so that the title is in the center
		// BorderPane borderTop = new BorderPane();

		TilePane advancedTop = new TilePane();
		advancedTop.setPadding(new Insets(2, 10, 2, 10));
		advancedTop.setVgap(5);
		advancedTop.setHgap(5);
		advancedTop.setAlignment(Pos.CENTER);

		GridPane advancedBottom = new GridPane();
		advancedBottom.setPadding(new Insets(2, 10, 2, 10));
		advancedBottom.setVgap(5);
		advancedBottom.setHgap(5);
		advancedBottom.setAlignment(Pos.CENTER);

		Label advancedLabel = new Label("Choose input: ");

		TextArea customInput = new TextArea(); //text area to fill custom inputs
		customInput.setPrefSize(200, 10);
		customInput.setMaxHeight(10);

		ToggleGroup group = new ToggleGroup();

		//buttons for custom inputs
		RadioButton sorted = new RadioButton("Sorted");
		sorted.setToggleGroup(group);
		//sorted.setSelected(true);
		sorted.setOnAction(e -> {
			testInput = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			customInput.setText("1,2,3,4,5,6,7,8,9,10");
			System.out.println("sorted input");
		});

		RadioButton random = new RadioButton("Random");
		random.setToggleGroup(group);
		random.setOnAction(e -> {
			System.out.println("random input");
			shuffleArray(testInput); //shuffle the array
			String s = Arrays.toString(testInput); //convert array to string
			s = s.replaceAll("\\s+", ""); //remove all the white spaces
			s = s.substring(1, s.length()-1); //remove the '[' and ']'
			customInput.setText(s);
		});

		RadioButton reverse = new RadioButton("Reversed");
		reverse.setToggleGroup(group);
		reverse.setOnAction(e -> {
			testInput = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
			customInput.setText("10,9,8,7,6,5,4,3,2,1");
			System.out.println("reversed input");
		});

		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			String getInput = customInput.getText(); //get input from text area
			getInput = getInput.replaceAll("\\s+", ""); //remove all the white spaces
			String s = getInput.replaceAll(",", "");
			String regex = "[0-9]+";
			String[] split = getInput.split(","); //split the string into elements separated by ','
			boolean b1 = true;
			for(int i = 0; i < getInput.length()-2; i++) { //check if there's two commas side by side
				if(getInput.charAt(i) == ',' && getInput.charAt(i+1) == ',') {
					b1 = false;
				}
			}
			if(s.matches(regex) && split.length == 10 && b1 && getInput.charAt(0) != ',') {
				int[] output = new int[10];
				for(int i = 0; i < split.length; i++) {
					output[i] = Integer.parseInt(split[i]); //copy the elements into another array
				}
				testInput = output;
			}
			else {
				customInput.setText("Invalid input. Try again.");
			}
		});

		Label customInputLabel = new Label("Insert custom input. e.g 1,2,3,4,5,6,7,8,9,10");

		Button closeAdv = new Button("Close");
		closeAdv.setOnAction(e -> {
			removeAdvanced();
			resizeStage();
		});

		//add all the button and labels for advanced menu feature
		advancedTop.getChildren().add(advancedLabel);
		advancedTop.getChildren().add(sorted);
		advancedTop.getChildren().add(reverse);
		advancedTop.getChildren().add(random);
		advancedBottom.add(customInputLabel, 0, 0);
		advancedBottom.add(customInput, 0, 1);
		advancedBottom.add(submit, 1, 1);
		advancedBottom.add(closeAdv, 2, 1);

		//add the two panes to border pane
		advancedPane.setId("advanced");
		advancedPane.setTop(advancedTop);
		advancedPane.setCenter(advancedBottom);

		Button advanced = new Button("Advanced Menu");
		advanced.setMaxWidth(Double.MAX_VALUE);
		advanced.setOnAction(e -> {
			border.setBottom(advancedPane); //add the border pane to the parent border pane
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
		gridMenu.add(merge, 1, 4);
		gridMenu.add(advanced, 1, 5);

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

	public void removeAdvanced() {
		border.getChildren().remove(border.lookup("#advanced"));
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
	/**
	 * This method creates the visulisation based on the passed sortType paramater.
	 * Configures the model and generates a flowpane
	 * 
	 * @param sort The sort type
	 * 
	 */
	public void onClickVisulisation(String sort){
		numOfSortsOnScreen++;
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

}