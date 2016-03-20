package javaFx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
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
	public Boolean btnDisabledPlay = false;
	public Boolean btnDisabledStop = false;
	public Boolean btnDisabledForw = false;
	public Boolean btnDisabledBack = false;
	private Button forward = new Button();
	private Button back = new Button();
	private Button play = new Button();
	private Button pause = new Button();
	Button close = new Button();
	public double speed = 1;

	public FXcontrolPane(algModel model, TextArea logText) { // pass the model
																// so it acts on
																// the same
																// thing
		this.model = model;
		// this.setBackground(new Background(new
		// BackgroundFill(Color.ALICEBLUE,CornerRadii.EMPTY, Insets.EMPTY)));
		// make the slider, needs an action listener
		Slider slider = new Slider();
		slider.setSnapToTicks(true);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMin(0);
		slider.setMax(2);
		slider.setValue(1);
		slider.setMajorTickUnit(.5);
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				speed = new_val.doubleValue();
			}
		});

		// buttons creation
		back = new Button("|<<");
		back.setOnAction(e -> {
			if (btnDisabledBack) {
				logText.appendText("\n Please wait for the action to complete before starting another");
				System.out.println("Please wait for the action to complete before starting another");
			} else {
				disableBack();
				//back.setDisable(true);
				model.goBack();
			}
			//back.setDisable(btnDisabled);
		});
		play = new Button("Play");
		play.setOnAction(e -> {
			if (btnDisabledPlay) {
				logText.appendText("\n Please wait for the action to complete before starting another");
				System.out.println("Please wait for the action to complete before starting another");
			} else {
				disablePlay();
				System.out.println("Play");
				logText.appendText("\n Play");
				model.play();
			}
			//play.setDisable(btnDisabled);
		});

		pause = new Button("Stop");
		pause = new Button("Stop");
		pause.setOnAction(e -> {
			// System.out.println("pause");
			logText.appendText("\n Stop");
			model.stop();
			play.setDisable(btnDisabledPlay);
		});

		forward = new Button(">>|");
		forward.setOnAction(e -> {
			if (btnDisabledForw) {
				logText.appendText("\n Please wait for the action to complete before starting another");
				System.out.println("Please wait for the action to complete before starting another");
			} else {
				disableForward();
				// forward.setDisable(btnDisabled);
				model.goForward();
			}
			//forward.setDisable(btnDisabled);
		});

		close = new Button("Close");
		close.setOnAction(e -> {
			int intID = this.model.getID();
			String stringID = Integer.toString(intID);
			String ID = "#" + stringID;
			// System.out.println("close");
			logText.appendText("\n Close");
			model.stop();
			FXmainMenuGUI.removeVis(ID);
		});

		// speed label
		Text speed = new Text("Speed");
		speed.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		// add all the controls into the grid
		this.add(speed, 0, 1);
		this.add(slider, 0, 2);
		this.add(back, 1, 2);
		this.add(play, 2, 2);
		this.add(pause, 3, 2);
		this.add(forward, 4, 2);
		this.add(close, 6, 2);
	}/*
		 * public void enableBtn(){ btnDisabled = false;
		 * forward.setDisable(false); back.setDisable(false); } public void
		 * disableBtn(){ btnDisabled = true; forward.setDisable(true);
		 * back.setDisable(true); }
		 */

	public void disableBack() {
		btnDisabledBack = true;
		back.setDisable(true);
	}

	public void disableForward() {
		btnDisabledForw = true;
		forward.setDisable(true);
	}

	public void disablePlay() {
		btnDisabledPlay = true;
		play.setDisable(true);
	}

	public void disableStop() {
		btnDisabledStop = true;
		pause.setDisable(true);
	}

	public void enableForward() {
		btnDisabledForw = false;
		forward.setDisable(false);
	}

	public void enableBack() {
		btnDisabledBack = false;
		back.setDisable(false);
	}

	public void enablePlay() {
		btnDisabledPlay = false;
		play.setDisable(false);
	}

	public void enableStop() {
		btnDisabledStop = false;
		pause.setDisable(false);
	}

	public void clickPlay() {
		// forward.fire() //just to test if it works
		play.fire();
	}

	public void clickStop() {
		pause.fire();
	}

	public void clickClose() {
		close.fire();
	}

	public double getSpeed() {
		return (2.2-speed);
	}
}
