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

// TODO: Auto-generated Javadoc
/**
 * Controls panel for the visualisation.
 *
 * @author Elliott Upton, Kiril Nedkov
 */

public class FXcontrolPane extends GridPane {

	/** The model. */
	AlgModel model;

	/** The button disabled play flag. */
	public Boolean btnDisabledPlay = false;

	/** The button disabled stop. */
	public Boolean btnDisabledStop = false;

	/** The button disabled forward flag. */
	public Boolean btnDisabledForw = false;

	/** The button disabled back flag. */
	public Boolean btnDisabledBack = false;

	/** The forward button. */
	private Button forward = new Button();

	/** The back button . */
	private Button back = new Button();

	/** The play button. */
	private Button play = new Button();

	/** The pause button. */
	private Button pause = new Button();

	/** The close button. */
	Button close = new Button();

	/** The speed. */
	public double speed = 1;

	/**
	 * Instantiates a new FXcontrol pane.
	 *
	 * @param model
	 *            the model
	 * @param logText
	 *            the log text
	 */
	public FXcontrolPane(AlgModel model, TextArea logText) {
		// set the model
		this.model = model;
		// make the slider and give it the needed properties
		Slider slider = new Slider();
		slider.setSnapToTicks(true);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMin(0);
		slider.setMax(2);
		slider.setValue(1);
		slider.setMajorTickUnit(.5);
		// add a listener on the slider
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				speed = new_val.doubleValue();
			}
		});

		// create the back button
		back = new Button("|<<");
		// set the action
		back.setOnAction(e -> {
			if (btnDisabledBack) {
				// log failed attempt
				logText.appendText("\n Please wait for the action to complete before starting another");
			} else {
				// call function for back and disable back button
				disableBack();
				model.goBack();
			}
		});
		// create the play button
		play = new Button("Play");
		// set the action
		play.setOnAction(e -> {
			if (btnDisabledPlay) {
				// log the failed attempt
				logText.appendText("\n Please wait for the action to complete before starting another");
			} else {
				// call function for play and disable play button
				disablePlay();
				logText.appendText("\n Play");
				model.play();
			}
		});
		// create the stop button
		pause = new Button("Stop");
		// set the action
		pause.setOnAction(e -> {
			// log the stop
			logText.appendText("\n Stop");
			// call the stop function
			model.stop();
			// set flag to the value of btnDisabledPlay
			play.setDisable(btnDisabledPlay);
		});
		// create the forwards button
		forward = new Button(">>|");
		// set the action
		forward.setOnAction(e -> {
			if (btnDisabledForw) {
				// log the failed attempt
				logText.appendText("\n Please wait for the action to complete before starting another");
			} else {
				// disable the forward button
				disableForward();
				// call the forward method
				model.goForward();
			}
		});
		// create the close button
		close = new Button("Close");
		// set the action
		close.setOnAction(e -> {
			// get the id
			int intID = this.model.getID();
			// make it a string
			String stringID = Integer.toString(intID);
			// append #
			String ID = "#" + stringID;
			// log the close
			logText.appendText("\n Close");
			// stop the timer in the model
			model.stop();
			// remove the visualiser by ID
			FXmainMenuGUI.removeVis(ID);
		});

		// create the speed label
		Text speed = new Text("Speed");
		// set the properties
		speed.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		// add all the controls into the grid
		this.add(speed, 0, 1);
		this.add(slider, 0, 2);
		this.add(back, 1, 2);
		this.add(play, 2, 2);
		this.add(pause, 3, 2);
		this.add(forward, 4, 2);
		this.add(close, 6, 2);
	}

	/**
	 * Disable back button.
	 */
	public void disableBack() {
		btnDisabledBack = true;
		back.setDisable(true);
	}

	/**
	 * Disable forward button.
	 */
	public void disableForward() {
		btnDisabledForw = true;
		forward.setDisable(true);
	}

	/**
	 * Disable play button.
	 */
	public void disablePlay() {
		btnDisabledPlay = true;
		play.setDisable(true);
	}

	/**
	 * Disable stop button.
	 */
	public void disableStop() {
		btnDisabledStop = true;
		pause.setDisable(true);
	}

	/**
	 * Enable forward button.
	 */
	public void enableForward() {
		btnDisabledForw = false;
		forward.setDisable(false);
	}

	/**
	 * Enable back button.
	 */
	public void enableBack() {
		btnDisabledBack = false;
		back.setDisable(false);
	}

	/**
	 * Enable play button.
	 */
	public void enablePlay() {
		btnDisabledPlay = false;
		play.setDisable(false);
	}

	/**
	 * Enable stop button.
	 */
	public void enableStop() {
		btnDisabledStop = false;
		pause.setDisable(false);
	}

	/**
	 * Click play button.
	 */
	public void clickPlay() {
		play.fire();
	}

	/**
	 * Click stop button.
	 */
	public void clickStop() {
		pause.fire();
	}

	/**
	 * Click close button.
	 */
	public void clickClose() {
		close.fire();
	}

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public double getSpeed() {
		// remove the delay from a number to get the speed setting
		return (2.2 - speed);
	}
}
