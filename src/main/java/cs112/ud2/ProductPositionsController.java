package cs112.ud2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class ProductPositionsController {
    private ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    @FXML
    private VBox positionsVBox;
    @FXML
    private VBox checkboxContainer;
    private Product product;



    public void setProduct(Product product){
        this.product = product;
        if (product instanceof StandBag){
            initializePositions("Stand Bag");
        } else if (product instanceof StaffBag) {
            initializePositions("Staff Bag");
        } else if (product instanceof Hat) {
            initializePositions("Hat");
        } else {
            System.out.println("Unknown product type: " + product.getClass().getName());
        }

    }

    public void initializePositions(String productType) {
        checkboxContainer.getChildren().clear();
        checkboxContainer.setStyle("-fx-padding: 0 0 0 100;");
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
            checkboxContainer.getChildren().add(warningLabel);
        }


    }


    private void addCheckBox(String position){

        CheckBox checkBox = new CheckBox(position);
        checkBoxes.add(checkBox);
        checkboxContainer.getChildren().add(checkBox);
        checkBox.setStyle("-fx-padding: 5;" +
                "-fx-border-color: #b0b0b0;" +
                "-fx-border-radius: 5;" +
                "-fx-background-radius: 5;" +
                "-fx-background-color: #f0f0f0;" +
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #333333;" +
                "-fx-font-family: 'Century Gothic';"
        );

    }
    @FXML
    private void confirmPositions() {
        for (CheckBox checkBox : checkBoxes) {
            if (product instanceof StandBag standBag) {
                switch (checkBox.getText()) {
                    case "Ball Pocket" -> standBag.setBallPocket(checkBox.isSelected());
                    case "Side Pocket" -> standBag.setSidePocket(checkBox.isSelected());
                    case "Quarter Panel" -> standBag.setQtrPanel(checkBox.isSelected());
                }
            }else if (product instanceof StaffBag staffBag) {
                if (checkBox.getText().equals("Belly Panel")) {
                    staffBag.setBellyPanel(checkBox.isSelected());
                }
            } else if (product instanceof Hat hat) {
                switch (checkBox.getText()) {
                    case "Front" -> hat.setFront(checkBox.isSelected());
                    case "Right Side" -> hat.setRightSide(checkBox.isSelected());
                    case "Left Side" -> hat.setLeftSide(checkBox.isSelected());
                    case "Back Arch" -> hat.setBackArch(checkBox.isSelected());
                }
            }

        }
        ProductUtils.addProduct(product);
        System.out.println("Product Added: " + product);
        System.out.println("-------------------------");
        System.out.println("Products in the list:");
        ProductUtils.printProducts();

    }




}

