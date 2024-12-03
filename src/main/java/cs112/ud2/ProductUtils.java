package cs112.ud2;

public class ProductUtils {
    /**CREATE HAT
     * Creates a Hat object with the specified properties.
     *
     * @param sku             The stock keeping unit (SKU) of the hat.
     * @param year            The year the hat was produced.
     * @param modelDescription The description of the hat model.
     * @param color1          The primary color of the hat.
     * @param color2          The secondary color of the hat.
     * @param color3          The tertiary color of the hat.
     * @param color4          The quaternary color of the hat.
     * @param productColor    The product's base color.
     * @param tonalColor      The tonal color used for accents.
     * @param front           Indicates if the front is open for embroidery.
     * @param rightSide       Indicates if the right side is open for embroidery.
     * @param leftSide        Indicates if the left side is open for embroidery.
     * @param backArch        Indicates if the back arch is open for embroidery.
     * @return A Hat object if successfully created, or null if an exception occurs.
     */
    public static Hat createHat(String sku, int year, String modelDescription,
                                String color1, String color2, String color3, String color4,
                                String productColor, String tonalColor,
                                boolean front, boolean rightSide, boolean leftSide, boolean backArch) {
        Hat hat = null;
        try {

            hat = new Hat(sku,year,modelDescription,color1,color2,color3,color4,productColor,tonalColor,
                    front,rightSide,leftSide,backArch);

        } catch (InvalidSkuException ise) {
            System.out.println(ise.getMessage());
        } catch (InvalidThreadCodeException itce) {
            System.out.println(itce.getMessage());
        } catch (InvalidYearException iye) {
            System.out.println(iye.getMessage());
        }

        return hat;
    }


    /**CREATE STAND BAG
     * Creates a StandBag object with the specified properties.
     *
     * @param sku             The stock keeping unit (SKU) of the stand bag.
     * @param year            The year the stand bag was produced.
     * @param modelDescription The description of the stand bag model.
     * @param color1          The primary color of the stand bag.
     * @param color2          The secondary color of the stand bag.
     * @param color3          The tertiary color of the stand bag.
     * @param color4          The quaternary color of the stand bag.
     * @param productColor    The product's base color.
     * @param tonalColor      The tonal color used for accents.
     * @param ballPocket      Indicates if the ball pocket is open for embroidery.
     * @param sidePocket      Indicates if the side pocket is open for embroidery.
     * @param qtrPanel        Indicates if the quarter panel is open for embroidery.
     * @return A StandBag object if successfully created, or null if an exception occurs.
     */
    public static StandBag createStandBag(String sku, int year, String modelDescription,
                                          String color1, String color2, String color3, String color4,
                                          String productColor, String tonalColor,
                                          boolean ballPocket, boolean sidePocket, boolean qtrPanel){
        StandBag standBag = null;
        try {

            standBag = new StandBag(sku,year,modelDescription,color1,color2,color3,color4,productColor,tonalColor,
                    ballPocket,sidePocket,qtrPanel);


        } catch (InvalidSkuException ise) {
            System.out.println(ise.getMessage());
        } catch (InvalidThreadCodeException itce) {
            System.out.println(itce.getMessage());
        } catch (InvalidYearException iye) {
            System.out.println(iye.getMessage());
        }
        return standBag;

    }


    /**CREATE STAFF BAG
     * Creates a StaffBag object with the specified properties.
     *
     * @param sku             The stock keeping unit (SKU) of the staff bag.
     * @param year            The year the staff bag was produced.
     * @param modelDescription The description of the staff bag model.
     * @param color1          The primary color of the staff bag.
     * @param color2          The secondary color of the staff bag.
     * @param color3          The tertiary color of the staff bag.
     * @param color4          The quaternary color of the staff bag.
     * @param productColor    The product's base color.
     * @param tonalColor      The tonal color used for accents.
     * @param bellyPanel      Indicates if the belly panel is open for embroidery.
     * @return A StaffBag object if successfully created, or null if an exception occurs.
     * @throws InvalidSkuException       If the SKU is invalid.
     * @throws InvalidThreadCodeException If one of the color codes is invalid.
     * @throws InvalidYearException      If the year is outside the allowed range.
     */

    public static StaffBag createStaffBag(String sku, int year, String modelDescription,
                                          String color1, String color2, String color3, String color4,
                                          String productColor, String tonalColor,
                                          boolean bellyPanel) {
        StaffBag staffBag = null;
        try {
            staffBag = new StaffBag(sku, year, modelDescription, color1, color2, color3, color4, productColor, tonalColor, bellyPanel);
        } catch (InvalidSkuException ise) {
            System.out.println("Invalid SKU: " + ise.getMessage());
        } catch (InvalidThreadCodeException itce) {
            System.out.println("Invalid Thread Code: " + itce.getMessage());
        } catch (InvalidYearException iye) {
            System.out.println("Invalid Year: " + iye.getMessage());
        }
        return staffBag;
    }



}
