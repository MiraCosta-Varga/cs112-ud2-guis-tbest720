package cs112.ud2;

public abstract class Product {
    // DEFAULT CONSTANTS
    public static final String DEFAULT_SKU = "UNKNOWN";
    public static final int DEFAULT_YEAR = 0;
    public static final String DEFAULT_DESCRIPTION = "No Description";
    public static final String DEFAULT_COLOR = "None";
    public static final String DEFAULT_BAG_COLOR = "None";
    public static final String DEFAULT_TONAL_COLOR = "None";

    // INSTANCE VARIABLES
    private String sku;
    private int year;
    private String modelDescription;
    private String color1;
    private String color2;
    private String color3;
    private String color4;
    private String productColor;
    private String tonalColor;

    /****************************************************/

    //DEFAULT CONSTRUCTOR
    public Product() {
        this.sku = DEFAULT_SKU;
        this.year = DEFAULT_YEAR;
        this.modelDescription = DEFAULT_DESCRIPTION;
        this.color1 = DEFAULT_COLOR;
        this.color2 = DEFAULT_COLOR;
        this.color3 = DEFAULT_COLOR;
        this.color4 = DEFAULT_COLOR;
        this.productColor = DEFAULT_BAG_COLOR;
        this.tonalColor = DEFAULT_TONAL_COLOR;
    }

    //FULL CONSTRUCTOR
    public Product(
            String sku, int year, String modelDescription,
            String color1, String color2, String color3, String color4,
            String productColor, String tonalColor)
            throws InvalidSkuException, InvalidYearException, InvalidThreadCodeException {
        this.setAll(sku, year, modelDescription, color1, color2, color3, color4, productColor, tonalColor);
    }

    //COPY CONSTRUCTOR
    public Product(Product other) {
        this.sku = other.sku;
        this.year = other.year;
        this.modelDescription = other.modelDescription;
        this.color1 = other.color1;
        this.color2 = other.color2;
        this.color3 = other.color3;
        this.color4 = other.color4;
        this.productColor = other.productColor;
        this.tonalColor = other.tonalColor;
    }

    /****************************************************/
    //EXCEPTION HANDLING METHODS
    public void validateThreadCode(String threadCode) throws InvalidThreadCodeException {
        if (threadCode.length() < 4 || threadCode.length() > 5) {
            throw new InvalidThreadCodeException(
                    "INVALID THREAD CODE: " + threadCode + ". Valid thread codes are 4 or 5 characters long");
        }
    }

    public void validateYear(int year) throws InvalidYearException {
        if (year < 2000 || year > 3000) {
            throw new InvalidYearException("INVALID YEAR ENTERED: " + year + ". Must be between years 2000 & 3000");
        }
    }

    public void validateSku(String sku) throws InvalidSkuException {
        if (sku.length() != 6) {
            throw new InvalidSkuException("INVALID SKU ENTERED: " + sku + ". Valid SKU's are 6 character/numbers long");
        }
    }

    /****************************************************/
    //SETTERS
    public void setSku(String sku) throws InvalidSkuException {
        validateSku(sku); // Validate before setting
        this.sku = sku;
    }

    public void setYear(int year) throws InvalidYearException {
        validateYear(year); // Validate before setting
        this.year = year;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public void setColor1(String color1) throws InvalidThreadCodeException {
        validateThreadCode(color1);
        this.color1 = color1;
    }

    public void setColor2(String color2) throws InvalidThreadCodeException {
        validateThreadCode(color2);
        this.color2 = color2;

    }

    public void setColor3(String color3) throws InvalidThreadCodeException {
        validateThreadCode(color3);
        this.color3 = color3;
    }

    public void setColor4(String color4) throws InvalidThreadCodeException {
        validateThreadCode(color4);
        this.color4 = color4;
    }

    public void setProductColor(String productColor) throws InvalidThreadCodeException {
        validateThreadCode(productColor);
        this.productColor = productColor;
    }

    public void setTonalColor(String tonalColor) throws InvalidThreadCodeException {
        validateThreadCode(tonalColor);
        this.tonalColor = tonalColor;
    }

    /****************************************************/
    //GETTERS
    public String getSku() {
        return sku;
    }

    public int getYear() {
        return year;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public String getColor3() {
        return color3;
    }

    public String getColor4() {
        return color4;
    }

    public String getProductColor() {
        return productColor;
    }

    public String getTonalColor() {
        return tonalColor;
    }

    /****************************************************/
    //SETALL

    public void setAll(
            String sku, int year, String modelDescription,
            String color1, String color2, String color3, String color4,
            String productColor, String tonalColor)
            throws InvalidSkuException, InvalidYearException, InvalidThreadCodeException {
        validateSku(sku);
        validateYear(year);
        validateThreadCode(color1);
        validateThreadCode(color2);
        validateThreadCode(color3);
        validateThreadCode(color4);
        validateThreadCode(productColor);
        validateThreadCode(tonalColor);
        this.sku = sku;
        this.year = year;
        this.modelDescription = modelDescription;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
        this.productColor = productColor;
        this.tonalColor = tonalColor;

    }

    /****************************************************/
    //TO STRING
    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", year=" + year +
                ", modelDescription='" + modelDescription + '\'' +
                ", color1='" + color1 + '\'' +
                ", color2='" + color2 + '\'' +
                ", color3='" + color3 + '\'' +
                ", color4='" + color4 + '\'' +
                ", productColor='" + productColor + '\'' +
                ", tonalColor='" + tonalColor + '\'' +
                '}';
    }

}

