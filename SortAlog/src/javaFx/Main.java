package javaFx;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
		System.out.println("sit");
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXmainMenuGUI FXmainMenuGUI = new FXmainMenuGUI(primaryStage);
	}
}