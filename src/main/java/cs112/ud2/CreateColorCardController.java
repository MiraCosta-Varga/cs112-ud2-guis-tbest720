package cs112.ud2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CreateColorCardController {
    private String productSku;
    private String logoID;

    private Product product;
    private Logo logo;


    @FXML private Label logoIDLabel;
    @FXML private Label yearLabel;
    @FXML private Label productDescriptionLabel;
    @FXML private Label skuLabel;


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

    }

    public void createStopDetail(Product product, Logo logo) {
        for (int i = 0 ; i < logo.getNumberOfStops(); i++){

        }

    }



}
