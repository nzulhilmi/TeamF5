package javaFx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Controls panel for the visualisation
 *
 * @author ElliottUpton
 *
 */

public class FXcontrolPane extends GridPane {
	algModel model;
	private int period;
	public Boolean btnDisabled = false;
	private Button forward = new Button();
	private Button back = new Button();
	private Button play = new Button();
	public FXcontrolPane(algModel model, TextArea logText) { //pass the model so it acts on the same thing
		this.model = model;
		this.period = 1000;
		//this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,CornerRadii.EMPTY, Insets.EMPTY)));
		//make the slider, needs an action listener
		Slider slider = new Slider();
		slider.setSnapToTicks(true);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMin(0);
		slider.setMax(2);
		slider.setValue(1);
		slider.setMajorTickUnit(.5);

		//buttons creation
		back = new Button("|<<");
		back.setOnAction(e -> {
			if(btnDisabled){
				logText.appendText("\n Please wait for the action to complete before starting another");
				System.out.println("Please wait for the action to complete before starting another");
			}else {
				disableBtn();
				back.setDisable(btnDisabled);
				model.goBack();
			}
			back.setDisable(btnDisabled);
		});
		play = new Button("play");
		play.setOnAction(e ->{
			System.out.println("play");
			logText.appendText("\n play");
			//timer.start();
		});

		Button pause = new Button("pause");
		pause.setOnAction(e ->{
			System.out.println("pause");
			logText.appendText("\n pause");
			//timer.stop();});
		});

		forward = new Button(">>|");
		forward.setOnAction( e ->{
			if(btnDisabled){
				logText.appendText("\n Please wait for the action to complete before starting another");
				System.out.println("Please wait for the action to complete before starting another");
			}else {
				disableBtn();
				forward.setDisable(btnDisabled);
				model.goForward();
			}
			forward.setDisable(btnDisabled);
		});

		//isn't working would be nice to get this working
		Button close = new Button("Close");
		close.setOnAction(e->{
			int intID = this.model.getID();
			String stringID = Integer.toString(intID);
			String ID = "#" + stringID;
			//System.out.println("close");
			logText.appendText("\n Close");
			FXmainMenuGUI.removeVis(ID);
		});

		//speed label
		Text speed = new Text("Speed");
		speed.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		//add all the controls into the grid
		this.add(speed, 0, 1);
		this.add(slider, 0, 2);
		this.add(back, 1, 2);
		this.add(play, 2, 2);
		this.add(pause, 3, 2);
		this.add(forward, 4, 2);
		this.add(close, 6, 2);
	}
	public void enableBtn(){
		btnDisabled = false;
		forward.setDisable(false);
		back.setDisable(false);
	}
	public void disableBtn(){
		btnDisabled = true;
		forward.setDisable(true);
		back.setDisable(true);
	}

	public void clickPlay() {
	    //forward.fire() //just to test if it works
	    play.fire();
	}
}
