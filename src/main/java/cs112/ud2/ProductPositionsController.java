package cs112.ud2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ProductPositionsController {
    private ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    @FXML
    private VBox positionsVBox;

    public void initializePositions(String productType) {
        positionsVBox.getChildren().clear();
        checkBoxes.clear();
        if(productType.equals("Stand Bag")){
            addCheckBox("Ball Pocket");
            addCheckBox("Side Pocket");
            addCheckBox("Quarter Panel");

        } else if(productType.equals("Staff Bag")){
            addCheckBox("Belly Panel");

        } else if(productType.equals("Hat")) {
            addCheckBox("Front");
            addCheckBox("Right Side");
            addCheckBox("Left Side");
            addCheckBox("Back Arch");
        } else {
            Label warningLabel = new Label();
            warningLabel.setText("ERROR: Invalid Product Type.\nPlease close this popup and select a valid product type.");
        }

    }


    private void addCheckBox(String position){

        CheckBox checkBox = new CheckBox(position);
        checkBoxes.add(checkBox);
        positionsVBox.getChildren().add(checkBox);

    }
}

