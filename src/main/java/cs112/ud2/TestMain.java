package cs112.ud2;
import java.util.ArrayList;

public class TestMain {



    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();
        //Create a Hat, and if no errors are found, add to productList
       Hat hat1 = ProductUtils.createHat("N12345", 2018,"snapback",
               "1234", "1234", "1234", "1234", "1234", "1234",
               true,true, false,true);
       System.out.println(hat1);
       if (hat1 != null) {
           productList.add(hat1);
       }

       //Create a Stand Bag, and if no errors are found, add to productList
       StandBag standBag1 = ProductUtils.createStandBag("N00000", 2022,"flextech",
               "1234", "1234", "1234", "1234", "1234", "1234",
               true,true, false);
       System.out.println(standBag1);
       if (standBag1 != null) {
           productList.add(standBag1);
       }

        //Create a Staff Bag, and if no errors are found, add to productList
       StaffBag staffBag1 = ProductUtils.createStaffBag("N54321", 2025,"TOUR",
               "1111", "2222", "3333", "4444", "pppp", "tttt",
               true);
        System.out.println(staffBag1);
        if (standBag1 != null) {
            productList.add(staffBag1);
        }

        //Print from the array
        System.out.println();
        System.out.println("-----------PRINTING ARRAY LIST------------");
        System.out.println();
        for (Product product : productList) {
            System.out.println(product);
        }



        //Create new logo
        Logo logo1 = null;
        try {
            logo1 = new Logo("000143-500", 6);
        } catch (InvalidNumberOfStops inos) {
            System.out.println(inos.getMessage());
        }
        //Set all stop index
        logo1.setThreadCode(0,2);
        logo1.setThreadCode(1,2);
        logo1.setThreadCode(2,3);
        logo1.setThreadCode(3,2);
        logo1.setThreadCode(4,2);
        logo1.setThreadCode(5,3);

        //use helper method to grab thread codes from product
        for (int i = 0 ; i < logo1.getNumberOfStops(); i++){
            System.out.println("Stop #" + (i+1) + ": " +ProductUtils.assignThreadCodes(i,staffBag1,logo1.getThreadCode(i)));
        }


    }
}
