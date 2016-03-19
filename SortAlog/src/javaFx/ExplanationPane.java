package javaFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class ExplanationPane extends GridPane {
	public TextArea explanation = new TextArea();
	private Boolean visable = false;

	public ExplanationPane() {
		super();
		// this.setAlignment(Pos.TOP); // location of the table
		this.setHgap(10); // spacing
		this.setVgap(10); // spacing
		this.setPadding(new Insets(10, 10, 10, 10)); // padding around the
		this.setMaxSize(250, 300);

		Label ExplanationTitle = new Label();
		ExplanationTitle.setText("Sorting Explanations: ");

		ObservableList<String> options = FXCollections.observableArrayList("Bubble", "Quick", "Insertion", "Selection");
		final ComboBox<String> comboBox = new ComboBox<String>(options);

		explanation.setWrapText(true);
		explanation.setText("Select a sort from the drop down list to display a discrition of how it works");
		comboBox.setOnAction(e -> {
			explanation.setText(TextExplanation(comboBox.getValue()));
			if(!visable){
			this.add(explanation, 1, 2);
			FXmainMenuGUI.resizeStage();
			visable = true;
			}
			});

		this.add(ExplanationTitle, 0, 0, 2, 1);
		this.add(comboBox, 1, 1);

		// explanation.setVisible(false);
		// this.add(insertion, 1, 3);
		// this.add(advanced, 1, 4);
	}

	private String TextExplanation(String sort) {
		String text = "Nothing";
		switch (sort) {
		case "Bubble":
			return text = "Bubble Sort \n Bubble sort compares the two elements which are next to each other and swapping them to put them in accending order."
				+ "\n \nTime complexities:"
				+ "\nBest case: O(n)"
				+ "\nAverage case: O(n^2)"
				+ "\nWorse case: O(n^2)";
		case "Quick":
			return text = "Quick Sort \n Quick sort firstly picks a pivot element. All other element are then compared to the pivot and placed to the left if they are smaller or to the right if they are larger, splitting the array. \n The pivot is then marked as sorted. \n The algorithm then runs simltaniously on both the left and right sides."
				+ "\n \nTime complexities:"
				+ "\nBest case: O(n log(n))"
				+ "\nAverage case: O(n log(n))"
				+ "\nWorse case: O(n^2)";
		case "Insertion":
			return text = "Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list."
				+ "Each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there."
			 	+ "It repeats until no input elements remain."
				+ "\n Sorting is typically done in-place, by iterating up the array, growing the sorted list behind it."
			 	+ "At each array-position, it checks the value there against the largest value in the sorted list (which happens to be next to it, in the previous array-position checked)."
				+ "If larger, it leaves the element in place and moves to the next."
			 	+ "If smaller, it finds the correct position within the sorted list, shifts all the larger values up to make a space, and inserts into that correct position."
			 	+ "\n \nTime complexities:"
				+ "\nBest case: O(n)"
				+ "\nAverage case: O(n^2)"
				+ "\nWorse case: O(n^2)";
		case "Selection":
		 return text = "Selection Sort \n "
		 		+ "Selection sort starts with the element in the first position or the list assuming that this is the minimum value in the list. \n "
		 		+ "Then the algorithm compares it with each element in the list and when it find an element with smaller value the algorithm saves the possition of this element as being the current minimum. At the point when it has reached the end of the list the algorithm would have saved the position of the smallest element in the list. Then it will swap it with the first element in the list as this is the position that we want to get sorted first. \n"
		 		+ "Now we have the first element sorted and the same cycle is repeated for each next position in the list without going back to the leading positions."
		 		+ "\n \nTime complexities:"
				+ "\nBest case: O(n^2)"
				+ "\nAverage case: O(n^2)"
				+ "\nWorse case: O(n^2)";
		default:
			break;
		}
		return text;
	}
}
