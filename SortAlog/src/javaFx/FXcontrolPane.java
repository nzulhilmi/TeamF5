package javaFx;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
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
	private int period;

	public FXcontrolPane(/* algModel model */) {
		this.model = model;
		this.period = 1000;
		Slider slider = new Slider();
		slider.setSnapToTicks(true);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMin(0);
		slider.setMax(2);
		slider.setValue(1);
		slider.setMajorTickUnit(.5);


		Button back = new Button("|<<");
		back.setOnAction(e -> System.out.println("back") /* model.goBack() */);

		Button play = new Button("play");
		play.setOnAction(e -> System.out.println("play") /* timer.start() */);

		Button pause = new Button("pause");
		pause.setOnAction(e -> System.out.println("pause")/* timer.stop() */);

		Button forward = new Button(">>|");
		forward.setOnAction(e -> System.out.println("forward") /* model.goForward() */);

		Button close = new Button("Close");
		//back.setOnAction(e -> getParent().close());
		
		Text speed = new Text("Speed");
		speed.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

		this.add(speed, 0, 1);
		this.add(slider, 0, 2);
		this.add(back, 1, 2);
		this.add(play, 2, 2);
		this.add(pause, 3, 2);
		this.add(forward, 4, 2);
		this.add(close, 6, 2);

	}
}
