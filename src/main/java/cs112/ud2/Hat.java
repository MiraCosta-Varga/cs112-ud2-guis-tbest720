package cs112.ud2;

public class Hat extends Product {

    // INSTANCE VARIABLES
    private boolean front;
    private boolean rightSide;
    private boolean leftSide;
    private boolean backArch;

    /****************************************************/
    //DEFAULT CONSTRUCTOR
    public Hat() {
        super();
        this.front = false;
        this.rightSide = false;
        this.leftSide = false;
        this.backArch = false;
    }

    // FULL CONSTRUCTOR
    public Hat(String sku, int year, String modelDescription,
               String color1, String color2, String color3, String color4,
               String productColor, String tonalColor,
               boolean front, boolean rightSide, boolean leftSide, boolean backArch)
            throws InvalidSkuException, InvalidYearException, InvalidThreadCodeException {
        super(sku, year, modelDescription, color1, color2, color3, color4, productColor, tonalColor);
        this.front = front;
        this.rightSide = rightSide;
        this.leftSide = leftSide;
        this.backArch = backArch;
    }
    //COPY CONSTRUCTOR
    public Hat(Hat other) {
        super(other);
        this.front = other.front;
        this.rightSide = other.rightSide;
        this.leftSide = other.leftSide;
        this.backArch = other.backArch;
    }

    /****************************************************/
    // SETTERS
    public void setFront(boolean front) {
        this.front = front;
    }

    public void setRightSide(boolean rightSide) {
        this.rightSide = rightSide;
    }

    public void setLeftSide(boolean leftSide) {
        this.leftSide = leftSide;
    }

    public void setBackArch(boolean backArch) {
        this.backArch = backArch;
    }


    /****************************************************/
    // GETTERS
    public boolean isFront() {
        return front;
    }

    public boolean isRightSide() {
        return rightSide;
    }

    public boolean isLeftSide() {
        return leftSide;
    }

    public boolean isBackArch() {
        return backArch;
    }

    /****************************************************/
    // SETALL

    public void setAll(
            String sku, int year, String modelDescription,
            String color1, String color2, String color3, String color4,
            String productColor, String tonalColor,
            boolean front, boolean rightSide, boolean leftSide, boolean backArch
    ) throws InvalidSkuException, InvalidYearException, InvalidThreadCodeException {

        super.setAll(sku, year, modelDescription, color1, color2, color3, color4, productColor, tonalColor);


        this.front = front;
        this.rightSide = rightSide;
        this.leftSide = leftSide;
        this.backArch = backArch;
    }
    /****************************************************/
    // TO STRING METHOD
    @Override
    public String toString() {
        return super.toString() +
                ", Hat{" +
                "front =" + front +
                ", rightSide =" + rightSide +
                ", leftSide =" + leftSide +
                ", backArch =" + backArch +
                '}';
    }

}
