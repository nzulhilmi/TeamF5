package javaFx;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.stream.IntStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ExplanationPane extends GridPane {
	public TextArea explanation = new TextArea();
	public ExplanationPane() {
		super();
		// this.setAlignment(Pos.TOP); // location of the table
		this.setHgap(10); // spacing
		this.setVgap(10); // spacing
		this.setPadding(new Insets(10, 10, 10, 10)); // padding around the
		this.setMaxSize(250, 300);

		Label ExplanationTitle = new Label();
		ExplanationTitle.setText("Sorting Explanations: ");

		ObservableList<String> options = FXCollections.observableArrayList("Bubble", "Quick", "PlaceHolder");
		final ComboBox<String> comboBox = new ComboBox<String>(options);


		explanation.setWrapText(true);
		explanation.setText("Select a sort from the drop down list to display a discrition of how it works");
		comboBox.setOnAction(e -> explanation.setText(TextExplanation(comboBox.getValue())));

		this.add(ExplanationTitle, 0, 0, 2, 1);
		this.add(comboBox, 1, 1);
		this.add(explanation, 1, 2);
		// explanation.setVisible(false);
		// this.add(insertion, 1, 3);
		// this.add(advanced, 1, 4);
	}

	private String TextExplanation(String sort) {
		String text = "Nothing";
		switch (sort) {
		case "Bubble":
			return text = "Bubble Sort \n Bubble sort compares the two elements which are next to each other and swapping them to put them in accending order.";
		case "Quick":
			return text = "Quick Sort \n Quick sort firstly picks a pivot element. All other element are then compared to the pivot and placed to the left if they are smaller or to the right if they are larger, splitting the array. \n The pivot is then marked as sorted. \n The algorithm then runs simltaniously on both the left and right sides.";
		case "PlaceHolder":
			return text = "This is placeholder Sort";
			//case "Quick":
			//return text = "This is Quick Sort";
		default:
			break;
		}
		return text;
	}
}
