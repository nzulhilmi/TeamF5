package javaFx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Runs the GUI for sortAlgo
 * extends application.
 * @author ElliottUpton
 *
 */
public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * starts the GUI
	 */
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		FXmainMenuGUI FXmainMenuGUI = new FXmainMenuGUI(primaryStage);
		//primaryStage.setOnCloseRequest();
	}
}