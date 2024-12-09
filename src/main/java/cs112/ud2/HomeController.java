package cs112.ud2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {


    private Stage addProductStage;
    private Stage addLogoStage;
    private Stage editProductStage;
    private Stage colorCardStage;

    @FXML
    public void openAddProductWindow() {
            try {

                // Load the AddProduct.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
                Parent root = loader.load();


                // Create a new window
                Stage addProductStage  = new Stage();
                addProductStage.setTitle("Add Product");
                addProductStage.setScene(new Scene(root, 600, 350));
                addProductStage.setResizable(false);// Set your preferred dimensions
                addProductStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }



    @FXML
    public void openAddLogoWindow() {
            try {

                // Load the AddLogo.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddLogo.fxml"));
                Parent root = loader.load();


                // Create a new window
                Stage addLogoStage = new Stage();
                addLogoStage.setTitle("Add Logo");
                addLogoStage.setScene(new Scene(root, 600, 350));
                addLogoStage.setResizable(false);
                addLogoStage.show();
            } catch (IOException e) {
            e.printStackTrace();
            }
    }


    @FXML
    public void openEditProductWindow() {

        // Load the EditProduct.fxml file
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProduct.fxml"));
                Parent root = loader.load();


                // Create a new stage (window)
                Stage editProductStage = new Stage();
                editProductStage.setTitle("Edit Product");
                editProductStage.setScene(new Scene(root, 600, 350));
                editProductStage.setResizable(false);
                editProductStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public void openCardInfo(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CardInfo.fxml"));
            Parent root = loader.load();

            // Create a new stage (window)
            Stage colorCardStage = new Stage();
            colorCardStage.setTitle("Color Card");
            colorCardStage.setScene(new Scene(root));
            colorCardStage.setResizable(false);
            colorCardStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void exitApplication() {
        Platform.exit();
        System.exit(0);
    }




}