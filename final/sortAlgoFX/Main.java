package sortAlgoFX;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Runs the GUI for sortAlgo extends application.
 *
 * @author Elliott Upton
 *
 */
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * starts the GUI
	 */
	@Override
	public void start(Stage primaryStage) {
		FXmainMenuGUI FXmainMenuGUI = new FXmainMenuGUI(primaryStage);
	}
}