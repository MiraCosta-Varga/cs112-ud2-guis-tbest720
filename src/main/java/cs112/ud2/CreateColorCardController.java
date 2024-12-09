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
    @FXML private HBox positionsHBox;




    public void setProductLogo(String productSku, String logoID) {
        this.logoID = logoID;
        this.productSku = productSku;


        product = ProductUtils.getProductBySku(productSku);
        logo = LogoManager.getLogoByID(logoID);

        if (product != null) {
            addPositions(product);
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
            HBox colorStopHBox= createColorStopHBox(logo.getThreadCode(i),product,i);
            stopDetailsVbox.getChildren().add(colorStopHBox);

        }
         // Scroll to the bottom after adding content

    }

    public void addPositions(Product product) {
        positionsHBox.getChildren().clear();
        if (product instanceof StandBag){
            StandBag standBag = (StandBag) product;
            boolean hasBallPocket = standBag.hasBallPocket();
            boolean hasSidePocket = standBag.hasSidePocket();
            boolean hasQuarterPanel = standBag.hasQtrPanel();
            if (hasBallPocket == true){
                Label label = createPositionsLabel("Ball Pocket");
                positionsHBox.getChildren().add(label);
            }
            if (hasSidePocket == true){
                Label label = createPositionsLabel("Side Pocket");
                positionsHBox.getChildren().add(label);
            }
            if (hasQuarterPanel == true){
                Label label = createPositionsLabel("Quarter Panel");
                positionsHBox.getChildren().add(label);

            }
            if (hasBallPocket == false && hasSidePocket == false &&hasQuarterPanel == false ){
                Label label = createPositionsLabel("No Open Positions");
                positionsHBox.getChildren().add(label);
            }
        }
        if (product instanceof StaffBag){
            StaffBag staffBag = (StaffBag) product;
            boolean hasBellyPanel = staffBag.hasBellyPanel();
            if (hasBellyPanel == true){
                Label label = createPositionsLabel("Belly Panel");
                positionsHBox.getChildren().add(label);
            } else {
                Label label = createPositionsLabel("No Open Positions");
                positionsHBox.getChildren().add(label);
            }
        }
        if (product instanceof Hat){
            Hat hat = (Hat) product;
            boolean hasRightSide = hat.hasRightSide();
            boolean hasLeftSide = hat.hasLeftSide();
            boolean hasBackArch = hat.hasBackArch();
            boolean hasFront = hat.hasFront();
            if (hasBackArch == true){
                Label label = createPositionsLabel("Back Arch");
                positionsHBox.getChildren().add(label);
            }
            if (hasFront == true){
                Label label = createPositionsLabel("Front");
                positionsHBox.getChildren().add(label);
            }
            if (hasLeftSide == true){
                Label label = createPositionsLabel("Left Side");
                positionsHBox.getChildren().add(label);
            }
            if (hasRightSide == true){
                Label label = createPositionsLabel("Right Side");
                positionsHBox.getChildren().add(label);
            }
            if (hasBackArch == false && hasFront == false && hasLeftSide == false && hasRightSide == false ){
                Label label = createPositionsLabel("No Open Positions");
                positionsHBox.getChildren().add(label);
            }
        }

    }

    private HBox createColorStopHBox(int stopIndex, Product product, int i) {
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

        Label stopLabel = new Label("Stop #" + (i + 1) + ": " + threadCode);
        colorStopHBox.getChildren().add(stopLabel);

        return colorStopHBox;

    }
    private Label createPositionsLabel(String position) {
        Label label = new Label(position);
        label.setStyle("-fx-padding: 10; -fx-background-color: #5b95cf; -fx-border-color: #2c5782; -fx-border-radius: 5; -fx-background-radius: 5;");
        return label;
    }



}
