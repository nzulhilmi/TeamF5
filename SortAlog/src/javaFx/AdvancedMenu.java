package javaFx;

import java.util.Arrays;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Stores all the buttons and text area for advanced menu feature.
 * @author Nik Zulhilmi
 *
 */
public class AdvancedMenu extends BorderPane{
    private Stage stage;
    private BorderPane border;
    private static int[] input = {1,2,3,4,5,6,7,8,9,10};
    private Boolean textArea = false;

    public AdvancedMenu(Stage stage, BorderPane border) {
	this.setId("advanced");
	this.stage = stage;
	this.border = border;

	TilePane advancedTop = new TilePane();
	advancedTop.setPadding(new Insets(2, 10, 2, 10));
	advancedTop.setVgap(5);
	advancedTop.setHgap(5);
	advancedTop.setAlignment(Pos.CENTER);

	GridPane advancedBottom = new GridPane();
	advancedBottom.setPadding(new Insets(2, 10, 2, 10));
	advancedBottom.setVgap(5);
	advancedBottom.setHgap(5);
	advancedBottom.setAlignment(Pos.CENTER);

	Label advancedLabel = new Label("Choose input: ");

	TextArea customInput = new TextArea("1,2,3,4,5,6,7,8,9,10"); //text area to fill custom inputs
	customInput.setPrefSize(200, 10);
	customInput.setMaxHeight(10);
	customInput.setOnMouseClicked(e-> {
	    if(textArea) {
		customInput.setText("");
		textArea = false;
	    }
	});

	ToggleGroup group = new ToggleGroup();

	//buttons for custom inputs
	RadioButton sorted = new RadioButton("Sorted");
	sorted.setToggleGroup(group);
	sorted.setSelected(true);
	sorted.setOnAction(e -> {
	    textArea = false;
	    input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	    customInput.setText("1,2,3,4,5,6,7,8,9,10");
	    System.out.println("sorted input");
	});

	RadioButton random = new RadioButton("Random");
	random.setToggleGroup(group);
	random.setOnMouseClicked(e -> {
	    textArea = false;
	    System.out.println("random input");
	    shuffleArray(input); //shuffle the array
	    String s = Arrays.toString(input); //convert array to string
	    s = s.replaceAll("\\s+", ""); //remove all the white spaces
	    s = s.substring(1, s.length()-1); //remove the '[' and ']'
	    customInput.setText(s);
	});
	random.setOnAction(e -> {
	    textArea = false;
	    System.out.println("random input");
	    shuffleArray(input); //shuffle the array
	    String s = Arrays.toString(input); //convert array to string
	    s = s.replaceAll("\\s+", ""); //remove all the white spaces
	    s = s.substring(1, s.length()-1); //remove the '[' and ']'
	    customInput.setText(s);
	});

	RadioButton reverse = new RadioButton("Reversed");
	reverse.setToggleGroup(group);
	reverse.setOnAction(e -> {
	    textArea = false;
	    input = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	    customInput.setText("10,9,8,7,6,5,4,3,2,1");
	    System.out.println("reversed input");
	});

	Label customInputLabel = new Label("Insert custom input. e.g 1,2,3,4,5,6,7,8,9,10");

	Button submit = new Button("Submit");
	submit.setOnAction(e -> {
	    String getInput = customInput.getText(); //get input from text area
	    getInput = getInput.replaceAll("\\s+", ""); //remove all the white spaces
	    String s = getInput.replaceAll(",", "");
	    String regex = "[0-9]+";
	    String[] split = getInput.split(","); //split the string into elements separated by ','
	    boolean b1 = true;
	    for(int i = 0; i < getInput.length()-2; i++) { //check if there's two commas side by side
		if(getInput.charAt(i) == ',' && getInput.charAt(i+1) == ',') {
		    b1 = false;
		}
	    }
	    boolean b2 = true;
	    if(getInput.charAt(getInput.length()-1) == ',') {
		b1 = false;
	    }
	    if(s.matches(regex) && split.length == 10 && b1 && getInput.charAt(0) != ',' && b2) {
		int[] output = new int[10];
		for(int i = 0; i < split.length; i++) {
		    output[i] = Integer.parseInt(split[i]); //copy the elements into another array
		}
		input = output;
	    }
	    else {
		customInput.setText("Invalid input. Try again.");
		textArea = true;
	    }
	});

	Button closeAdv = new Button("Close");
	closeAdv.setOnAction(e -> {
	    removeAdvanced();
	    FXmainMenuGUI.setBoolean(false);
	});

	advancedTop.getChildren().add(advancedLabel);
	advancedTop.getChildren().add(sorted);
	advancedTop.getChildren().add(reverse);
	advancedTop.getChildren().add(random);
	advancedBottom.add(customInputLabel, 0, 0);
	advancedBottom.add(customInput, 0, 1);
	advancedBottom.add(submit, 1, 1);
	advancedBottom.add(closeAdv, 2, 1);

	this.setTop(advancedTop);
	this.setCenter(advancedBottom);
    }

    /**
     * Resizes the window.
     */
    public void resizeStage() {
	stage.sizeToScene();
    }

    /**
     * Closes the advanced menu.
     */
    public void removeAdvanced() {
	border.getChildren().remove(border.lookup("#advanced"));
	resizeStage();
    }

    /**
     * Shuffles the contents of the array for random input.
     * @param array The array to be shuffled.
     */
    public void shuffleArray(int[] array)
    {
	int index;
	Random random = new Random();
	for (int i = array.length - 1; i > 0; i--)
	{
	    index = random.nextInt(i + 1);
	    if (index != i)
	    {
		array[index] ^= array[i];
		array[i] ^= array[index];
		array[index] ^= array[i];
	    }
	}
    }

    /**
     * Returns the input array.
     * @return input The array passed to the algorithms
     */
    public static int[] getInput() {
	return input;
    }
}
