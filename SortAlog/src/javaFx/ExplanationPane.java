package javaFx;

import javax.print.attribute.standard.RequestingUserName;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class ExplanationPane extends GridPane {
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

		TextArea explanation = new TextArea();
		explanation.setWrapText(true);
		explanation.setText("Select a sort from the drop down list to display a discrition of how it works");
		comboBox.setOnAction(e -> explanation.setText(TextExplanation(comboBox.getValue())));

		this.add(ExplanationTitle, 0, 0, 2, 1);
		this.add(comboBox, 1, 1);
		this.add(explanation, 1, 2);
		// this.add(insertion, 1, 3);
		// this.add(advanced, 1, 4);
	}

	private String TextExplanation(String sort) {
		String text = "Nothing";
		switch (sort) {
		case "Bubble":
			return text = "this is bubble sort";
		case "Quick":
			return text = "This is Quick Sort";
		default:
			break;
		}
		return text;
	}
}
