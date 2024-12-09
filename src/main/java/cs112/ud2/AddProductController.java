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
    //Create Menubuttons and items to add
    @FXML private MenuButton productTypeMenuButton;
    @FXML private MenuItem standBag;
    @FXML private MenuItem staffBag;
    @FXML private MenuItem hat;

    //Initialize the page with the MenuItems added
    public void initialize() {
        standBag = new MenuItem("Stand Bag");
        staffBag = new MenuItem("Staff Bag");
        hat = new MenuItem("Hat");

        standBag.setOnAction(event -> productTypeMenuButton.setText(standBag.getText()));
        staffBag.setOnAction(event -> productTypeMenuButton.setText(staffBag.getText()));
        hat.setOnAction(event -> productTypeMenuButton.setText(hat.getText()));

        productTypeMenuButton.getItems().addAll(standBag, staffBag, hat);
    }



    //Create all the text fields
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

        //Grab strings and ints from all the elements on the page
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

        //If the product type is a stand bag, create a stand bag
        if (productType.equals("Stand Bag")) {
            StandBag standBag = ProductUtils.createStandBag(sku,year, description,colorOne,colorTwo,colorThree,colorFour,
                    bagColor,tonalColor, true, true,true); //Call method from ProductUtils Class

            System.out.println("Product Added: " + standBag);
            openProductPositions(standBag);
        }

        //If the product type is a hat, create a hat
        if (productType.equals("Hat")) {
            Hat hat = ProductUtils.createHat(sku,year, description,colorOne,colorTwo,colorThree,colorFour,
                    bagColor,tonalColor, true, true,true,true); //Call method from ProductUtils Class

            System.out.println("Product Added: " + hat);
            openProductPositions(hat);

        //If the product type is a Staff bag, create a Staff Bag
        }if (productType.equals("Staff Bag")) {
            StaffBag staffBag = ProductUtils.createStaffBag(sku, year, description, colorOne, colorTwo, colorThree, colorFour,
                    bagColor, tonalColor, true); //Call method from ProductUtils Class

            System.out.println("Product Added: " + staffBag);
            openProductPositions(staffBag);
        }

        //Open the Product positions popup and pass in the product type


    }

    public void openProductPositions(Product product) {
        try {

            // Load the CreateProduct.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductPositions.fxml"));
            Parent root = loader.load();

            ProductPositionsController controller = loader.getController();
            controller.setProduct(product); // initialise the product positions popup with the correct product type
            //so that the correct checkboxes show up.

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
