package javaFx;
//http://stackoverflow.com/questions/33941258/simple-way-to-create-a-vertical-buttonbar-using-javafx-scene-builder-gluon
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VerticalButtonBar extends VBox {

    public VerticalButtonBar() {
        setFillWidth(true);
    }

    public void addButton(Button button) {
        button.setMaxWidth(Double.MAX_VALUE);
        getChildren().add(button);
    }

}