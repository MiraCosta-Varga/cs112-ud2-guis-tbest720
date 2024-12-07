package cs112.ud2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CardInfoController {

    @FXML private TextField productSkuTextField;
    @FXML private TextField logoIDTextField;
    @FXML private Button generateColorCardButton;

    private String productSku;
    private String logoID;

    @FXML
    private void setProductLogoValues() {
        productSku = productSkuTextField.getText();
        logoID = logoIDTextField.getText();
        System.out.println("Retrieving Product: " + productSku);
        System.out.println("Retrieving Logo: " + logoID);

        openColorCardWindow(productSku, logoID);
    }

    public void openColorCardWindow(String productSku, String logoID) {

         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateColorCard.fxml"));
            Parent root = loader.load();
            CreateColorCardController createColorCardController = loader.getController();
            createColorCardController.setProductLogo(productSku, logoID);

            CreateColorCardController controller = loader.getController();

            // Create a new stage (window)
            Stage colorCardStage = new Stage();
            colorCardStage.setTitle("Color Card");
            colorCardStage.setScene(new Scene(root, 300, 300));
            colorCardStage.setResizable(false);
            colorCardStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
