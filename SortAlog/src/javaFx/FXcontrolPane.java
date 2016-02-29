package javaFx;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
	TextArea logdisplay = new TextArea();

	public FXcontrolPane(algModel model ) { //pass the model so it acts on the same thing
		this.model = model;
		this.period = 1000;
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
		Button back = new Button("|<<");
		back.setOnAction(e -> {
			System.out.println("back");
			model.goBack();
			});

		Button play = new Button("play");
		play.setOnAction(e ->{
			System.out.println("play");
			//timer.start();
			});

		Button pause = new Button("pause");
		pause.setOnAction(e ->{
			System.out.println("pause");
			//timer.stop();});
		});

		Button forward = new Button(">>|");
		forward.setOnAction(e ->{
			System.out.println("forward");
			model.goForward();
		});

		//isn't working would be nice to get this working
		Button close = new Button("Close");
		//back.setOnAction(e -> getParent().getParent().remove(vis));

		//speed label
		Text speed = new Text("Speed");
		speed.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
		
		//log
		Button log = new Button("Log"); //to display the console
		
		logdisplay.setPrefSize(200, 100); //size of the text area
		logdisplay.setVisible(false);
		
		log.setOnAction(e-> {
			System.out.println("log");
			if(logdisplay.isVisible()) {
				logdisplay.setVisible(false);
			}
			else {
				logdisplay.setVisible(true);
			}
		});

		//add all the controls into the grid
		this.add(speed, 0, 1);
		this.add(slider, 0, 2);
		this.add(back, 1, 2);
		this.add(play, 2, 2);
		this.add(pause, 3, 2);
		this.add(forward, 4, 2);
		this.add(close, 6, 2);
		this.add(log, 7, 2);
		this.add(logdisplay, 10, 2);
		
		//for some strange/unexplained reasons, a thread is needed to run redirectSystemStreams.
		new Thread () {
			@Override public void run () {
				redirectSystemStreams();
			}
		}.start();
	}
	
	private void updateTextArea(final String text) {
		Platform.runLater(new Runnable() {
			public void run() {
				logdisplay.appendText(text);
			}
		});
	}
		 
	private void redirectSystemStreams() {
		OutputStream out = new OutputStream() {
			
			@Override
			public void write(int b) throws IOException {
				updateTextArea(String.valueOf((char) b));
			}
		 
		    @Override
		    public void write(byte[] b, int off, int len) throws IOException {
		    	updateTextArea(new String(b, off, len));
		    }
		 
		    @Override
		    public void write(byte[] b) throws IOException {
		    	write(b, 0, b.length);
		    }
		};

		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}
}
