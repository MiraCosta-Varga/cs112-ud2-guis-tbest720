package cs112.ud2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;

public class AddProductController {
    @FXML private MenuButton productTypeMenuButton;
    @FXML private MenuItem standBag;
    @FXML private MenuItem staffBag;
    @FXML private MenuItem hat;

    public void initialize() {
        standBag = new MenuItem("Stand Bag");
        staffBag = new MenuItem("Staff Bag");
        hat = new MenuItem("Hat");

        standBag.setOnAction(event -> productTypeMenuButton.setText(standBag.getText()));
        staffBag.setOnAction(event -> productTypeMenuButton.setText(staffBag.getText()));
        hat.setOnAction(event -> productTypeMenuButton.setText(hat.getText()));

        productTypeMenuButton.getItems().addAll(standBag, staffBag, hat);
    }




    @FXML private TextField productSkuTextField;
    @FXML private TextField productDescriptionTextField;
    @FXML private TextField yearTextField;
    @FXML private TextField colorOneTextField;
    @FXML private TextField colorTwoTextField;
    @FXML private TextField colorThreeTextField;
    @FXML private TextField colorFourTextField;
    @FXML private TextField bagColorTextField;
    @FXML private TextField tonalColorTextField;









    @FXML void addProduct(ActionEvent event) {

        System.out.println("addProduct");
        String productType = productTypeMenuButton.getText();
        String sku = productSkuTextField.getText();
        String description = productDescriptionTextField.getText();
        int year = Integer.parseInt(yearTextField.getText());
        String colorOne = colorOneTextField.getText();
        String colorTwo = colorTwoTextField.getText();
        String colorThree = colorThreeTextField.getText();
        String colorFour = colorFourTextField.getText();
        String bagColor = bagColorTextField.getText();
        String tonalColor = tonalColorTextField.getText();

        if (productType.equals("Stand Bag")) {
            StandBag standBag = null;
            try{
                standBag = new StandBag(sku,year, description,colorOne,colorTwo,colorThree,colorFour,
                        bagColor,tonalColor, true, true,true);
            }catch (InvalidSkuException ise) {
                ise.getMessage();
            }catch (InvalidYearException iye) {
                iye.getMessage();
            }catch (InvalidThreadCodeException itce){
                itce.getMessage();
            }
            System.out.println("Product Added: " + standBag);

        }
        if (productType.equals("Hat")) {
            Hat hat = null;
            try{
                hat = new Hat(sku,year, description,colorOne,colorTwo,colorThree,colorFour,
                        bagColor,tonalColor, true, true,true,true);
            }catch (InvalidSkuException ise) {
                ise.getMessage();
            }catch (InvalidYearException iye) {
                iye.getMessage();
            }catch (InvalidThreadCodeException itce){
                itce.getMessage();
            }
            System.out.println("Product Added: " + hat);

        }if (productType.equals("Staff Bag")) {
            StaffBag staffBag = null;
            try {
                staffBag = new StaffBag(sku, year, description, colorOne, colorTwo, colorThree, colorFour,
                        bagColor, tonalColor, true);
            }catch (InvalidSkuException ise) {
                ise.getMessage();
            }catch (InvalidYearException iye) {
                iye.getMessage();
            }catch (InvalidThreadCodeException itce){
                itce.getMessage();
            }
            System.out.println("Product Added: " + staffBag);
        }
        openProductPositions(productType);

    }

    public void openProductPositions(String productType) {
        try {

            // Load the CreateProduct.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductPositions.fxml"));
            Parent root = loader.load();

            ProductPositionsController controller = loader.getController();
            controller.initializePositions(productType);

            // Create a new window
            Stage productPositionsStage  = new Stage();
            productPositionsStage.setTitle("Select Positions");
            productPositionsStage.setScene(new Scene(root));
            productPositionsStage.setResizable(false);
            productPositionsStage.initOwner(productTypeMenuButton.getScene().getWindow());
            productPositionsStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
