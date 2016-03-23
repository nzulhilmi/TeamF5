package javaFx;

import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Create the Main Menu of the Application.
 *
 * @author ElliottUpton, Kiril N.
 *
 */
public class FXmainMenuGUI extends Application {
	/**
	 * Create the Main Menu of the Application.
	 */
	public FXmainMenuGUI(Stage stage) {
		start(stage);
		/*
		 * when the stage is closed all animations are stopped
		 */
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				stopAll();
			}
		});
	}

	/*
	 * numOfSortsOnScreen is the number of algorithms currently on the screen
	 *
	 * allowednumOfSortsOnScreen is the max number allowed on screen. This
	 * number changes depending on screen resolutions. max is 3
	 */
	public static int numOfSortsOnScreen = 0;
	public static int allowednumOfSortsOnScreen = 3;

	// new border pane so that the title is in the center
	private BorderPane borderTop = new BorderPane();

	// creates stop all button
	private Button stopAll = new Button("Stop All");

	// Title of the program. This changes based on the program state
	private static Label scenetitle = new Label("SortAlgo Main Menu");

	// to set the id of each visualisation pane (to be converted to string)
	private int intID = 0;
	// FlowPane's for the sorts to be added dynamically
	private static FlowPane flowPane = new FlowPane();
	// sets the top level to a border layout
	private BorderPane border = new BorderPane();
	// ScrollPane holds the flowpane so that it is scrollable
	private static ScrollPane scrollPane = new ScrollPane();
	// the input to be sorted
	private int[] input = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	// The stage is the whole window
	static Stage stage;
	// true if the advanced menu is open else false
	private static Boolean advancedBoolean = false;

	/***
	 * Starts running the Stage and program within it
	 *
	 */
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		// Gets the size of the users screen
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		// set Stage max boundaries to visible bounds of the main screen
		stage.setMaxHeight(primaryScreenBounds.getHeight());
		// prevent resizing by the user
		stage.resizableProperty().set(false);

		// set the font of the title
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		/*
		 * Each visulisation is held in its own flow pane, flow panes are
		 * dynamically added
		 *
		 */
		// padding 20 because of scrollbars
		flowPane.setPadding(new Insets(0, 20, 0, 0));
		flowPane.setColumnHalignment(HPos.LEFT); // align labels on left
		// after width of 10 the next pane is added bellow it
		flowPane.setPrefWrapLength(10);

		scrollPane.setStyle("-fx-background-color:transparent;"); // no border
		// adds the flow pane to the scroll panel
		scrollPane.setContent(flowPane);
		// show the scroll bars as and when required
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		// scroll pane should be the same size as its content
		scrollPane.fitToWidthProperty();

		/*
		 * if the users screen size greater than 750 then allow 3 algorithms on
		 * screen else only permit 2
		 *
		 */
		if (primaryScreenBounds.getHeight() >= 750) {
			allowednumOfSortsOnScreen = 3;
			scrollPane.setMaxHeight(750);
		} else {
			allowednumOfSortsOnScreen = 2;
			scrollPane.setMaxHeight(500);
		}
		/*
		 * set the position of the scrollPane to the center of the main border
		 * layout. Effectively the center of the entire window
		 *
		 */
		border.setCenter(scrollPane);

		/*
		 * All sort buttons call the same method with a different param
		 *
		 * Firstly create the button and set its text second set the width of
		 * the buttons to be the max and therefore equal thirdly set the
		 * listener to create a visualisation when clicked
		 *
		 */

		// Bubble button creation
		Button bubble = new Button();
		bubble.setText("Bubble"); // set text
		// Makes the buttons all have the same size
		bubble.setMaxWidth(Double.MAX_VALUE);
		// on click call the method which creates a visualisation
		bubble.setOnAction(e -> onClickVisulisation("Bubble"));

		// creates quick sorts button
		Button quick = new Button("Quick");
		quick.setMaxWidth(Double.MAX_VALUE);
		quick.setOnAction(e -> onClickVisulisation("Quick"));

		// creates quick sorts button
		Button insertion = new Button("Insertion");
		insertion.setMaxWidth(Double.MAX_VALUE);
		insertion.setOnAction(e -> onClickVisulisation("Insertion"));

		// creates quick sorts button
		Button selection = new Button("Selection");
		selection.getStyleClass().add("sortButtons");
		selection.setMaxWidth(Double.MAX_VALUE);
		selection.setOnAction(e -> onClickVisulisation("Selection"));

		/*
		 * creates the play all button play all button has a loop which causes
		 * all open algorithms to start playing
		 */
		Button playAll = new Button("Play All");
		playAll.setMaxWidth(Double.MAX_VALUE);
		playAll.setOnAction(e -> {
			if (flowPane.getChildren().size() > 0) {
				for (int i = 0; i < flowPane.getChildren().size(); i++) {
					// get all the children (all the algorithms)
					((FXvisualiser) flowPane.getChildren().get(i)).clickPlay();
				}
			} else {
				System.err.println("Error: no algorithms running");
			}
		});

		/*
		 * creates the stop all button stop all button has a loop which causes
		 * all open algorithms to stop playing
		 *
		 */
		stopAll = new Button("Stop All");
		stopAll.setMaxWidth(Double.MAX_VALUE);
		stopAll.setOnAction(e -> {
			if (flowPane.getChildren().size() > 0) {
				for (int i = 0; i < flowPane.getChildren().size(); i++) {
					// get all the children (all the algorithms)
					((FXvisualiser) flowPane.getChildren().get(i)).clickStop();
				}
			} else {
				System.err.println("Error: no algorithms running");
			}
		});

		/*
		 * creates the close all button close all button has a loop which causes
		 * all open algorithms to close themselves and remove them for the pane
		 */
		Button closeAll = new Button("Close All");
		closeAll.setMaxWidth(Double.MAX_VALUE);
		closeAll.setOnAction(e -> {
			if (flowPane.getChildren().size() > 0) {
				for (int i = flowPane.getChildren().size() - 1; i >= 0; i--) {
					// get all the children (all the algorithms)
					((FXvisualiser) flowPane.getChildren().get(i)).clickClose();
				}
			} else {
				System.err.println("Error: no algorithms running");
			}
		});

		// creates the advanced menu
		AdvancedMenu advancedMenu = new AdvancedMenu(stage, border);

		// Creates a button which adds the advanced menu to the stages
		Button advanced = new Button("Advanced Menu");
		advanced.setMaxWidth(Double.MAX_VALUE);
		advanced.setOnAction(e -> {
			// add the border pane to the parent border pane
			border.setBottom(advancedMenu);
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
		gridMenu.add(bubble, 1, 1);
		gridMenu.add(quick, 1, 2);
		gridMenu.add(insertion, 1, 3);
		gridMenu.add(selection, 1, 4);
		gridMenu.add(playAll, 1, 5);
		gridMenu.add(stopAll, 1, 6);
		gridMenu.add(closeAll, 1, 7);
		gridMenu.add(advanced, 1, 8);

		/*
		 *
		 * Creates an image viewer so the logo can be added to the GUI
		 * surrounded by try catch incase the logo cannot be loaded
		 *
		 */
		ImageView imgView = null;
		try {
			Image img = new Image("softwarelogoFinal2darkerLeadingPadding.png");
			imgView = new ImageView(img);
			imgView.setFitHeight(100);
			imgView.setFitWidth(240);
		} catch (IllegalArgumentException e) {
			System.err.println("logo failed to load");
		}
		// layout for the left hand side
		BorderPane borderLeft = new BorderPane();
		/*
		 * Creates the explanation pane which holds all of the written
		 * explanations of the algorithms. Passes the number of sorts allowed on
		 * screen as this allows the box size to be set so it doesn't go off
		 * screen
		 */
		ExplanationPane explanationPane = new ExplanationPane(allowednumOfSortsOnScreen);
		// Adds to the left hand border pane layout
		borderLeft.setTop(imgView);
		borderLeft.setCenter(gridMenu);
		borderLeft.setBottom(explanationPane);
		// adds the left hand layout to the overall stage layout
		border.setLeft(borderLeft);

		borderTop.setCenter(scenetitle); // add the title to the top center
		// add the topLayout to the top position of the main layout
		border.setTop(borderTop);

		// creates the scene from the main layout manager
		Scene menuScene = new Scene(border);
		// add the scene to the pane
		stage.setScene(menuScene);
		stage.setTitle("SortAlgo");
		stage.show(); // show the stage

		/*
		 * when the flow pane (algorithms pane) resizes change the size of the
		 * whole window and update the scroll bar size. Scroll bar needs
		 * manually updating as it functions differently on different operating
		 * systems.
		 */
		flowPane.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth,
					Number newSceneWidth) {
				resizeStage();
				updatescroll();
			}
		});
	}

	/**
	 * This method forces the scrollPane to automatically resize. This is
	 * required as the scrollPanes auto resize behaviour varies depending on
	 * operating system
	 */
	public void updatescroll() {
		stage.setWidth(stage.getWidth() + 1);
	}

	/**
	 * Removes a flow pane (visualisation) from the overall GUI. And updates the
	 * title and stage accordingly.
	 *
	 * @param s
	 *            The name of the pane to be deleted
	 */
	public static void removeVis(String s) {
		flowPane.getChildren().remove(flowPane.lookup(s));
		numOfSortsOnScreen--;
		scenetitle.setText("SortAlgo Visualising " + (numOfSortsOnScreen) + " Algorithms");
		if (numOfSortsOnScreen == 0) {
			scenetitle.setText("SortAlgo Main Menu");
			flowPane.setPrefWrapLength(10);
			resizeStage();
		} else if (numOfSortsOnScreen <= allowednumOfSortsOnScreen) {
			resizeStage();
		}

	}

	/**
	 * resizes the stage to the minimum size required for its content
	 */
	public static void resizeStage() {
		stage.sizeToScene();
	}

	/**
	 * This method creates the visualisation based on the passed sortType
	 * parameter. Configures the model and generates a flowpane
	 *
	 * @param sort
	 *            The sort type
	 *
	 */
	public void onClickVisulisation(String sort) {
		numOfSortsOnScreen++; // increment the number of algorithms on screen
		// if the advanced menu is open
		if (advancedBoolean) {
			// get the advanced menus input
			input = AdvancedMenu.getInput();
		} else {
			// else use a random input
			shuffleArray(input);
		}
		// create an instantiation of the model
		algModel algModel = new algModel(input.clone(), sort, intID);
		// creates the visualisation
		FXvisualiser vis = new FXvisualiser(algModel, intID);
		// joins the model and the visualisation
		algModel.setVis(vis);
		// adds the visualisation to the overall flow pane, like a list of panes
		flowPane.getChildren().add(vis);
		// allow the scroll pane to show scroll bars
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		// update the title
		scenetitle.setText("SortAlgo Visualising " + (numOfSortsOnScreen) + " Algorithms");

		// This stops the screen resizing past visible.
		if (numOfSortsOnScreen <= allowednumOfSortsOnScreen)
			stage.sizeToScene();
		// increment intID so each pane will have unique ID
		intID++;
	}

	/**
	 * generates a shuffled version of the input
	 *
	 * @param array
	 *            the array to be shuffled
	 */
	public void shuffleArray(int[] array) {
		int index;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			if (index != i) {
				array[index] ^= array[i];
				array[i] ^= array[index];
				array[index] ^= array[i];
			}
		}
	}

	/**
	 * Sets the boolean flag for the advanced menu
	 *
	 * @param b1
	 *            the flag state
	 */
	public static void setBoolean(Boolean b1) {
		advancedBoolean = b1;
	}

	/**
	 * creates an event on the stop button
	 */
	public void stopAll() {
		stopAll.fire();
	}
}