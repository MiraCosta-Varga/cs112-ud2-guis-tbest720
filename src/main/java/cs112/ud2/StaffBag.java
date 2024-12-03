package cs112.ud2;

public class StaffBag extends Product{
    // INSTANCE VARIABLES
    private boolean bellyPanel;

    //DEFAULT CONSTRUCTOR
    public StaffBag() {
        super();
        this.bellyPanel = false;
    }

    // FULL CONSTRUCTOR
    public StaffBag(String sku, int year, String modelDescription,
               String color1, String color2, String color3, String color4,
               String productColor, String tonalColor,
               boolean bellyPanel)
            throws InvalidSkuException, InvalidYearException, InvalidThreadCodeException {
        super(sku, year, modelDescription, color1, color2, color3, color4, productColor, tonalColor);
        this.bellyPanel = bellyPanel;

    }
    public StaffBag(StaffBag other) {
        super(other);
        this.bellyPanel = other.bellyPanel;
    }

    //SETTERS
    public void setBellyPanel(boolean bellyPanel) {

    }
    // GETTERS
    public boolean hasBellyPanel() {
        return bellyPanel;
    }

    // SETALL
    public void setAll(
            String sku, int year, String modelDescription,
            String color1, String color2, String color3, String color4,
            String productColor, String tonalColor,
            boolean ballPocket, boolean sidePocket, boolean qtrPanel
    ) throws InvalidSkuException, InvalidYearException, InvalidThreadCodeException {

        super.setAll(sku, year, modelDescription, color1, color2, color3, color4, productColor, tonalColor);

        this.bellyPanel = bellyPanel;


    }

    @Override
    public String toString() {
        return super.toString() +
                ", Staff Bag{" + "Belly Panel = " + bellyPanel + '}';

    }
}
