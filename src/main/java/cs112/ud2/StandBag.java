package cs112.ud2;

import java.awt.*;

public class StandBag extends Product {
    // INSTANCE VARIABLES
    private boolean ballPocket;
    private boolean sidePocket;
    private boolean qtrPanel;

    //DEFAULT CONSTRUCTOR
    public StandBag() {
        this.ballPocket = false;
        this.sidePocket = false;
        this.qtrPanel = false;
    }

    // FULL CONSTRUCTOR
    public StandBag(String sku, int year, String modelDescription,
               String color1, String color2, String color3, String color4,
               String productColor, String tonalColor,
               boolean ballPocket, boolean sidePocket, boolean qtrPanel)
            throws InvalidSkuException, InvalidYearException, InvalidThreadCodeException {

    }
    //COPY CONSTRUCTOR
    public StandBag(StandBag other) {
        super(other);
        this.ballPocket = other.ballPocket;
        this.sidePocket = other.sidePocket;
        this.qtrPanel = other.qtrPanel;
    }
    /****************************************************/

   public void setBallPocket(boolean ballPocket) {
       this.ballPocket = ballPocket;
   }

    public void setSidePocket(boolean sidePocket) {
        this.sidePocket = sidePocket;
    }

    public void setQtrPanel(boolean qtrPanel) {
        this.qtrPanel = qtrPanel;
    }
    /****************************************************/

    // GETTERS
    public boolean isBallPocket() {
        return ballPocket;
    }

    public boolean isSidePocket() {
        return sidePocket;
    }

    public boolean isQtrPanel() {
        return qtrPanel;
    }

    /****************************************************/
    // SETALL
    public void setAll(
            String sku, int year, String modelDescription,
            String color1, String color2, String color3, String color4,
            String productColor, String tonalColor,
            boolean ballPocket, boolean sidePocket, boolean qtrPanel
    ) throws InvalidSkuException, InvalidYearException, InvalidThreadCodeException {

        super.setAll(sku, year, modelDescription, color1, color2, color3, color4, productColor, tonalColor);

        this.ballPocket = ballPocket;
        this.sidePocket = sidePocket;
        this.qtrPanel = qtrPanel;

    }
    @Override
    public String toString() {
        return super.toString() +
                ", Stand Bag{" +
                "Ball Pocket = " + ballPocket +
                ", Side Pocket = " + sidePocket +
                ", Quarter Panerl = " + qtrPanel +
                '}';
    }

}
