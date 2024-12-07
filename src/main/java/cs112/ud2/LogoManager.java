package cs112.ud2;

import java.util.ArrayList;

public class LogoManager {
    private static final ArrayList<Logo> logoList = new ArrayList<>();



    public static void initializeDefaultLogoList() {
        //Initalizing 5 default logos to be added into program at start
        Logo logo1 = null;
        Logo logo2 = null;
        Logo logo3 = null;
        Logo logo4 = null;
        Logo logo5 = null;

        try{
            logo1 = new Logo("000143-500",2);
            logo2 = new Logo("541332-001",4);
            logo3 = new Logo("558942-002",1);
            logo4 = new Logo("558942-501",1);
            logo5 = new Logo("558942-501",4);

        }catch (InvalidNumberOfStops inos){
            inos.getMessage();
        }
        //Set Thread codes for each logo
        //Logo1
        logo1.setThreadCode(0,1086);
        logo1.setThreadCode(1,1000);
        //Logo2
        logo2.setThreadCode(0,1147);
        logo2.setThreadCode(1,2613);
        logo2.setThreadCode(2,1147);
        logo2.setThreadCode(3,1147);
        //Logo3
        logo3.setThreadCode(0,1000);
        //Logo4
        logo4.setThreadCode(0,1118);
        //Logo5
        logo5.setThreadCode(0,2613);
        logo5.setThreadCode(1,1000);
        logo5.setThreadCode(2,1147);
        logo5.setThreadCode(3,2613);

        logoList.add(logo1);
        logoList.add(logo2);
        logoList.add(logo3);
        logoList.add(logo4);
        logoList.add(logo5);

        System.out.println("Default Logos added successfully!");
        for (Logo logo : logoList) {
            System.out.println(logo);
        }




    }



    public static void addLogo(Logo logo) {
        logoList.add(logo);
        System.out.println(logo + "added to logoList Array");
    }

    public static ArrayList<Logo> getLogos() {
        return new ArrayList<>(logoList); // Return a copy to prevent external modification
    }

    public static void printLogoList(ArrayList<Logo> logoList) {
        System.out.println("_______________________________");
        System.out.println("Logos Added to logoList Array: ");

        for (Logo logo : logoList) {
            System.out.println(logo);
        }

        System.out.println("_______________________________\n");
    }


}
