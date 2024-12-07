package cs112.ud2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;

public class CreateColorCardController {
    private String productSku;
    private String logoID;

    private Product product;
    private Logo logo;



    @FXML private Label logoIDLabel;
    @FXML private Label yearLabel;
    @FXML private Label productDescriptionLabel;
    @FXML private Label skuLabel;

    @FXML private ScrollPane scrollPane;

    @FXML private VBox stopDetailsVbox;




    public void setProductLogo(String productSku, String logoID) {
        this.logoID = logoID;
        this.productSku = productSku;


        product = ProductUtils.getProductBySku(productSku);
        logo = LogoManager.getLogoByID(logoID);

        if (product != null) {
            skuLabel.setText("SKU: " + product.getSku());
            productDescriptionLabel.setText(product.getModelDescription());
            yearLabel.setText(Integer.toString(product.getYear()));

        }else{
            skuLabel.setText("Product Not Found");
        }

        if(logo != null){
            logoIDLabel.setText(logo.getLogoID());
        } else {
            logoIDLabel.setText("Logo Not Found");
        }

        if(product != null||logo != null){

            createStopDetail(logo,product);
        }

    }

    public void createStopDetail(Logo logo, Product product) {
        stopDetailsVbox.getChildren().clear();
        for (int i = 0 ; i < logo.getNumberOfStops(); i++){
            HBox colorStopHBox= createColorStopHBox(i,product);
            stopDetailsVbox.getChildren().add(colorStopHBox);

        }
         // Scroll to the bottom after adding content

    }


    private HBox createColorStopHBox(int stopIndex, Product product) {
        String threadCode;
        switch (stopIndex) {
            case 0:
                threadCode = product.getProductColor();
                break;
            case 1:
                threadCode = product.getColor1();
                break;
            case 2:
                threadCode = product.getColor2();
                break;
            case 3:
                threadCode = product.getColor3();
                break;
            case 4:
                threadCode = product.getColor4();
                break;
            case 5:
                threadCode = product.getTonalColor();
                break;
            default:
                threadCode = "error";

        }
        HBox colorStopHBox = new HBox();
        colorStopHBox.setSpacing(10);
        colorStopHBox.setStyle("-fx-padding: 10; -fx-background-color: #f0f0f0; -fx-border-color: #d3d3d3; -fx-alignment: center;");

        Label stopLabel = new Label("Stop #" + (stopIndex + 1) + ":" + threadCode);
        colorStopHBox.getChildren().add(stopLabel);

        return colorStopHBox;

    }


}
